package com.canddella.service;

import java.util.List;

import com.canddella.entity.Customer;
import com.canddella.entity.Event;

public interface CustomerService {
 public void saveCustomer(Customer customer);
 public Customer viewCustomer(String CustomerId);
 public Customer deleteCustomer(String CustomerId);
 public List<Customer> listAllCustomer();
 public Customer getCustomer(String CustomerId);
 public void updateCustomer(String CustomerId, String customerStore, String customerName);
}
