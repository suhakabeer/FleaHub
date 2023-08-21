package com.canddella.service;

import java.util.List;

import com.canddella.dao.CustomerDAOImpl;
import com.canddella.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
	@Override
	public void saveCustomer(Customer customer) {
		
		customerDAOImpl.saveCustomer(customer);
	}

	@Override
	public Customer viewCustomer(String CustomerId) {
		
		return customerDAOImpl.viewCustomer(CustomerId);
	}

	@Override
	public Customer deleteCustomer(String CustomerId) {
		
		return customerDAOImpl.deleteCustomer(CustomerId);
	}

	@Override
	public List<Customer> listAllCustomer() {
		
		return customerDAOImpl.ListAllCustomer();
	}

	@Override
	public Customer getCustomer(String CustomerId) {
		
		return customerDAOImpl.getCustomer(CustomerId);
	}

	@Override
	public void updateCustomer(String CustomerId, String customerStore, String customerName) {
		
		customerDAOImpl.updateCustomer(CustomerId, customerStore, customerName);
	}

}
