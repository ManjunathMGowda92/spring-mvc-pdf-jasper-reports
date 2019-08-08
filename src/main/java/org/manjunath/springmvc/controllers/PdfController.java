package org.manjunath.springmvc.controllers;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.manjunath.springmvc.services.PDFReportView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
public class PdfController {
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private PDFReportView report;
	
	
	@RequestMapping(value = "/pdf", method = RequestMethod.GET)
	public void generatePdf(HttpServletRequest request,	HttpServletResponse response) {
		response.setContentType("application/pdf");
		response.setHeader("content-disposition", "attachment; filename=simplepdf.pdf");
		OutputStream ouputStream = null;
		
		String fileName = servletContext.getRealPath(report.getUrl());
		String sourceFileName = fileName;
		try {
			ouputStream = response.getOutputStream();
			JasperReport jasreport = (JasperReport)JRLoader.loadObject(new File(sourceFileName));
			JRDataSource source = new JRBeanCollectionDataSource(report.getJRBeanCollectionDataSource());
			
			JasperPrint print = JasperFillManager.fillReport(jasreport, report.generateParameterMap(), source);
			
			JasperExportManager.exportReportToPdfStream(print, ouputStream);
			
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ouputStream != null) {
				try {
					ouputStream.flush();
					ouputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		/*ModelAndView modelAndView = new ModelAndView("pdfReport", report.generateParameterMap());
		return modelAndView;*/
	}
	
	@RequestMapping(value = "/viewpdf", method = RequestMethod.GET)
	public void viewPdf(HttpServletRequest request,	HttpServletResponse response) {
		OutputStream ouputStream = null;
		
		String fileName = servletContext.getRealPath(report.getUrl());
		String sourceFileName = fileName;
		try {
			ouputStream = response.getOutputStream();
			JasperReport jasreport = (JasperReport)JRLoader.loadObject(new File(sourceFileName));
			JRDataSource source = new JRBeanCollectionDataSource(report.getJRBeanCollectionDataSource());
			
			JasperPrint print = JasperFillManager.fillReport(jasreport, null, source);
			
			JasperExportManager.exportReportToPdfStream(print, ouputStream);
			
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ouputStream != null) {
				try {
					ouputStream.flush();
					ouputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
