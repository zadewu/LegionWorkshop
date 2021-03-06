package com.axonactive.workshop.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CustomerController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	CustomerMapper customerMapper;
	
	private List<CustomerBOM> customers = new ArrayList<>();
	private List<CustomerBOM> filteredCustomer;
	
	public List<CustomerBOM> getFilteredCustomer() {
		return filteredCustomer;
	}

	public void setFilteredCustomer(List<CustomerBOM> filteredCustomer) {
		this.filteredCustomer = filteredCustomer;
	}

	@PostConstruct
	public void init() {
		customers = customerMapper.toBoms(customerMapper.showAllCustomer());
	}

	public List<CustomerBOM> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerBOM> customers) {
		this.customers = customers;
	}
	
	public List<CustomerBOM> seachFunction(String search) {
		List<CustomerBOM> customers = new ArrayList<>();
		return customers;
	}
	
	
}
