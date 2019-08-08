package org.manjunath.springmvc.jasperCompiler;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

public class CompileJasperReport {
	
	public static void main(String[] args) {
		System.out.println("Compiling the jasper xml");
		
		CompileJasperReport compileReport = new CompileJasperReport();
		compileReport.compileTheJasperXml();
		
		System.out.println("Compilation done");
	}
	
	/**
	 * Used to compile the jasper xml. Compiled jasper report will be stored in
	 * target/classes/reports folder
	 */
	private void compileTheJasperXml(){
		String jasperXmlFile = getClass().getClassLoader()
										 .getResource("reports/jasper_report_template.jrxml")
										 .getFile();
		try {
			JasperCompileManager.compileReportToFile(jasperXmlFile);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}
