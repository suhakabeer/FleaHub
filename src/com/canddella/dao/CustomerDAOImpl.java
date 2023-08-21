package com.canddella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Customer;
import com.canddella.entity.Event;


public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public void saveCustomer(Customer customer) {
		DataSource ds=DBConnectionPool.getDataSource();
		try 
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into customer( Customer_id,  Customer_name,   Customer_address,  Customer_Zipcode, Customer_Phone_no, Customer_email, Customer_date ) values(?,?,?,?,?,?,?)");
			statement.setString(1,customer.getCustomerId());
			statement.setString(2,customer.getCustomerName() );
			statement.setString(3,customer.getCustomerAddress());
			statement.setInt(4,customer.getCustomerzipcode());
			statement.setDouble(5,customer.getCustomerPhoneNo());
			statement.setString(6,customer.getCustomerEmail());
			statement.setDate(7,Date.valueOf(customer.getCustomerDate()));
			int count=0;
			count=statement.executeUpdate();
			if(count>0)
				{
					System.out.println("Updated Successfully");
				}
			connection.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}	
		
	}

	@Override
	public Customer viewCustomer(String customerId) {
		
		DataSource ds=DBConnectionPool.getDataSource();
		Customer customer = null;
		try 
		{
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from customer where customer_id = ?");
			statement.setString(1, customerId);
			ResultSet resultSet=statement.executeQuery();
			
			while(resultSet.next())
			{
				System.out.println("***********************************************************************");	
				System.out.println("Customer Id             : - " + resultSet.getString("Customer_id") + "\n"
				                  +"Customer Name           : - " + resultSet.getString("Customer_name")+ "\n"
				                  +"Customer Address        : - " +resultSet.getString("Customer_address") +"\n"
			                      +"Customer Zipcode        : -  " + resultSet.getString("Customer_Zipcode") +"\n"
			                      +"Customer Phone Number   : -  " + resultSet.getString("Customer_Phone_no") +"\n"
			                      +"Customer Email id       : -  " + resultSet.getString("Customer_email") +"\n"
				                  +"Event End Date          : -  " + resultSet.getDate("Customer_date"));
				System.out.println("***********************************************************************");
					
			}
			connection.close();
 
			
					
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}	
		
		return customer;
	}

	@Override
	public Customer deleteCustomer(String customerId) {
	
		DataSource ds=DBConnectionPool.getDataSource();
		Customer customer = null;
		
			try
				{
					Connection connection = ds.getConnection();
					PreparedStatement statement =connection.prepareStatement("delete from customer where Customer_id=?");
					statement.setString(1, customerId);
					statement.executeUpdate();
					System.out.println("Customer deleted successfully");
					
				}
			
			catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
	
		return customer;
		
	}

	@Override
	public List<Customer> ListAllCustomer() {
		

		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList <Customer> customerList = new ArrayList<>();
		
		try
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from customer");
				
				ResultSet resultSet=statement.executeQuery();
					 while (resultSet.next()) {
				            String customerId = resultSet.getString("Customer_id");
				            String customerName = resultSet.getString("Customer_name");
				            String customerAddress = resultSet.getString("Customer_address"); 
				            int customerZipcode = resultSet.getInt("Customer_Zipcode");
				            
				            double customerPhoneNo = resultSet.getDouble("Customer_Phone_no");
				            String customerEmail= resultSet.getString("Customer_email");
				            
				           
				            Date customerDate = resultSet.getDate("Customer_date");
				            LocalDate customerRegDate = customerDate.toLocalDate();

				            
				            
				            Customer customer = new Customer(customerId,customerName,customerAddress,customerZipcode, customerPhoneNo,customerEmail,customerRegDate);
				            customerList.add(customer);
				          
				        }
					     
					
			}
		catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
		return customerList;
		
		
	}

	@Override
	public Customer getCustomer(String CustomerId) {
	

		Customer customer1 = null;
		DataSource ds=DBConnectionPool.getDataSource();
		
		
		try
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from customer");
				
				ResultSet resultSet=statement.executeQuery();
					 while (resultSet.next()) {
				            String customerId = resultSet.getString("Customer_id");
				            String customerName = resultSet.getString("Customer_name");
				            String customerAddress = resultSet.getString("Customer_address"); 
				            int customerZipcode = resultSet.getInt("Customer_Zipcode");
				            
				            double customerPhoneNo = resultSet.getDouble("Customer_Phone_no");
				            String customerEmail= resultSet.getString("Customer_email");
				            
				           
				            Date customerDate = resultSet.getDate("Customer_date");
				            LocalDate customerRegDate = customerDate.toLocalDate();

				            
				            
				            customer1 = new Customer(customerId,customerName,customerAddress,customerZipcode, customerPhoneNo,customerEmail,customerRegDate);
				            
				          
				        }
					     
					
			}
		catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
		return customer1;
	}

	@Override
	public void updateCustomer(String CustomerId, String customerStore, String customerName) {
		DataSource ds=DBConnectionPool.getDataSource();
		
		   try
				{
					Connection connection = ds.getConnection();
					PreparedStatement statement = connection.prepareStatement("update customer set " + customerStore + " = ? where Customer_id = ? ");
					statement.setString(1, customerName);
					statement.setString(2, CustomerId);
					statement.executeUpdate();
														     
						
				}
			catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
		
	}



	
}
