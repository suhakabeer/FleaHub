package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Customer;
import com.canddella.entity.Event;

		public interface CustomerDAO {
				public void  saveCustomer(Customer customer);
				public Customer viewCustomer(String customerId);
				public Customer deleteCustomer(String customerId);
				public List<Customer> ListAllCustomer();
				public Customer getCustomer(String CustomerId);
				public void updateCustomer(String CustomerId, String customerStore, String customerName);
		}
