package org.manjunath.springmvc.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.manjunath.springmvc.model.Customer;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class PDFReportView {
	
	private String url;
	
	public PDFReportView() {}
	
	public PDFReportView(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, Object> generateParameterMap(){
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(getJRBeanCollectionDataSource());		
		parameterMap.put("datasource", jrBeanCollectionDataSource);
		
		return parameterMap;
	}
	
	
	public List<Customer> getJRBeanCollectionDataSource() {
		
		List<Customer> customerList = new ArrayList<Customer>();
		
		Customer cust1 = new Customer("CUST1", "Manjunath", 237, "8723178632", "CUST1 ADDR", "BATCH1");
		Customer cust2 = new Customer("CUST2", "Manoj", 237, "8723178632", "CUST2 ADDR", "BATCH2");
		Customer cust3 = new Customer("CUST3", "Abhilash", 237, "8723178632", "CUST3 ADDR", "BATCH3");
		Customer cust4 = new Customer("CUST4", "Rajani", 237, "8723178632", "CUST4 ADDR", "BATCH4");
		Customer cust5 = new Customer("CUST5", "Kumari", 237, "8723178632", "CUST5 ADDR", "BATCH5");
		Customer cust6 = new Customer("CUST6", "Durga", 237, "8723178632", "CUST6 ADDR", "BATCH6");
		Customer cust7 = new Customer("CUST7", "Ramanna", 237, "8723178632", "CUST7 ADDR", "BATCH7");
		
		customerList.add(cust1);
		customerList.add(cust2);
		customerList.add(cust3);
		customerList.add(cust4);
		customerList.add(cust5);
		customerList.add(cust6);
		customerList.add(cust7);
		
		return customerList;
		
	}
}
