package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.service.CustomerServiceImpl;

public class CustomerUtility {

			public static void main(String[] args) {
				customerMenu();
			}
		
			public static void customerMenu() {
			    Scanner scanner = new Scanner(System.in);
			    int ch;
			    char cont;
			    
			    do {
			    	System.out.println("1.Save Customer      2.View Customer      3.Delete Customer      4.View All Customer      5.Update Customer      6.Exit\n");
			    	System.out.println("Enter your choice");
			    	ch = scanner.nextInt();
			    	switch(ch)
			    	 {
				    	case 1 : saveCustomer();
				    	break;
				    	case 2: viewCustomer();
				    	break;
				    	case 3 : deleteCustomer();
				    	break;
				    	case 4 : viewAllCustomer();
				    	break;
				    	case 5 : updateCustomer();
				    	break;
				    	default : System.out.println("Invalid choice. Please try again."); 
				    	break; 
				    		
			    	 }
			    	 System.out.println("Do you want to continue the update");	
			         scanner.nextLine();
			         cont = scanner.nextLine().charAt(0);
			       } while (cont == 'y'|| cont == 'Y');				
			}

		private static void updateCustomer() {
			
			 Scanner scanner = new Scanner(System.in);
			    int choice;
			    char option = 'Y';
			    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
			    System.out.println("Enter the Customer Id");
			    
			    String customerId = scanner.nextLine();
			   Customer customer =customerServiceImpl.getCustomer(customerId);
	
			    if (customer != null) {
			        do {
			            System.out.println("1.Customer Name     2.Customer Address     3.Customer Zipcode      4.Customer Phone number     5.Customer Email     6.Customer Registration Date");
			            System.out.println("Enter Your Choice");
			            choice = scanner.nextInt();
			            scanner.nextLine();
			            String customerStore;
			            
			            switch (choice) {
			                case 1:
			                    customerStore = "Customer_name";
			                    System.out.println("Enter the New Customer Name");
			                    scanner.nextLine(); 
			                    String customerName = scanner.nextLine();
			                    customerServiceImpl.updateCustomer(customerId, customerStore, customerName);
			                    break;
			                case 2:
			                	customerStore = "Customer_address";
			                    System.out.println("Enter the new Customer Address");		                   
			                    String customerAddress = scanner.nextLine();
			                    customerServiceImpl.updateCustomer(customerId, customerStore, customerAddress);
			                    break;
			                case 3:				   
			                	customerStore = "Customer_Zipcode";
		                	    System.out.println("Enter the new customer Zipcode");
		                	    String customerZipcode = scanner.nextLine();	               		   
		                	    customerServiceImpl.updateCustomer(customerId  , customerStore, customerZipcode);
			                    break;
				                 
				            case 4:  
				            	customerStore = "Customer_Phone_no";
		                	    System.out.println("Enter the new Phone number");
		                	    String customerPhoneNo = scanner.nextLine();	               		   
		                	    customerServiceImpl.updateCustomer(customerId, customerStore,customerPhoneNo);
				                break;
				                
				            case 5 : 
				                customerStore = "Customer_email";
		                	    System.out.println("Enter the new Customer Email Id");
		                	    String customerEmail = scanner.nextLine();	               		   
		                	    customerServiceImpl.updateCustomer(customerId, customerStore,customerEmail); 
				                break;
			                
			                    
				            case 6 : 
				            	 customerStore = "Customer_date";
				            	 System.out.println("Enter the new Customer registration date");
				            	 String customerDate = scanner.nextLine();
				            	 customerServiceImpl.updateCustomer(customerId, customerStore, customerDate);
			                    break;
			                   
			                    
			                default : break  ; 
			            }
			            System.out.println("Do you want to continue");	
			            option = scanner.nextLine().charAt(0);
			        } while (option == 'y'|| option == 'Y');	
			    }	
		}
		public static void viewAllCustomer() {
		    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		    List<Customer> customerList = customerServiceImpl.listAllCustomer();

		    System.out.println("+------------------+------------------+------------------+------------------+----------------+----------------------+-------------------------+");
		    System.out.printf("| %-16s | %-16s | %-16s | %-16s | %-14s | %-20s | %-23s |\n",
		            "Customer Id", "Customer Name", "Customer Address", "Customer Zipcode", "Customer Phone No", "Customer Email", "Registration Date");
		    System.out.println("+------------------+------------------+------------------+------------------+----------------+----------------------+-------------------------+");

		    for (Customer customer : customerList) {
		        if (customer != null) {
		            System.out.printf("| %-16s | %-16s | %-16s | %-16s | %-14s | %-20s | %-23s |\n",
		                    customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerAddress(),
		                    customer.getCustomerzipcode(), customer.getCustomerPhoneNo(),
		                    customer.getCustomerEmail(), customer.getCustomerDate());
		            System.out.println("+------------------+------------------+------------------+------------------+----------------+----------------------+-------------------------+");
		        }
		    }
		}
				
		
			private static void deleteCustomer() {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter the Customer Id");
				String customerId = scanner.nextLine();
				CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
				customerServiceImpl.deleteCustomer(customerId);
			}
		
			private static void viewCustomer() {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter the Customer Id");
				String customerId = scanner.nextLine();
				CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
				customerServiceImpl.viewCustomer(customerId);
				
			}

			private static void saveCustomer() {
				
				Customer customer = null;
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter the Customer Id");
				
				String customerId = scanner.nextLine();
				System.out.println("Enter the Customer Name");
				
				String customerName = scanner.nextLine();
				System.out.println("Enter the Customer Address");
				
				String customerAddress= scanner.nextLine();;
				System.out.println("Enter the Customer Zipcode");
				
				int customerZipcode= scanner.nextInt();
				System.out.println("Enter the Customer Customer Phone Number");
				
				double customerPhoneNo= scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Enter the Customer Customer Email");
				String customerEmail= scanner.nextLine();
				System.out.println("Enter the Customer Customer Registration Date");
				String customerDate= scanner.nextLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate customerRegDate = LocalDate.parse(customerDate, formatter);
				
			    customer = new Customer(customerId,customerName,customerAddress,customerZipcode,customerPhoneNo,customerEmail,customerRegDate);
				CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
				customerServiceImpl.saveCustomer(customer);
			}
	
}
