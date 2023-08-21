package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.EventRegistration;
import com.canddella.entity.EventVendorRegistration;
import com.canddella.entity.Vendor;
import com.canddella.service.EventVendorRegistrationServiceImpl;

public class EventVendorRegistrationUtility {

	public static void main(String[] args) {
		EventVendorRegistrationMenu();

	}

	public static void EventVendorRegistrationMenu() {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter Your Choice");
		 int ch;
	        char option;
	        do {
	            System.out.println("1.Save Event Vendor Registration      2.View Event Vendor Registration       3.Delete Event  Vendor Registration       4.View All Event  Vendor Registration");
	            ch = scanner.nextInt();
	            switch (ch) {
	                case 1:
	                    saveEventVendorRegistration();
	                    break;
	                case 2:
	                    viewEventVendorRegistration();
	                    break;
	                case 3:
	                    deleteEventVendorRegistration();
	                    break;
	                case 4:
	                    viewAllEventVendorRegistration();
	                    break;
	               
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	            System.out.println("Do you want to continue the update");	
	            scanner.nextLine();
	            option = scanner.nextLine().charAt(0);
	        } while (option == 'y'|| option == 'Y');	
	    }	
	
	

	
	public static void viewAllEventVendorRegistration() {
	    EventVendorRegistrationServiceImpl eventVendorRegistrationServiceImpl = new EventVendorRegistrationServiceImpl();
	    List<EventVendorRegistration> eventVendorRegistrationList = eventVendorRegistrationServiceImpl.viewAllEventVendorRegistration();

	    System.out.println("+-----------------------+----------------+-------------------+-------------------------+------------------+");
	    System.out.printf("| %-21s | %-14s | %-17s | %-23s | %-16s |\n",
	            "Registration Id", "Vendor Id", "Event Id", "Event Registration Date", "Number Of Tables");
	    System.out.println("+-----------------------+----------------+-------------------+-------------------------+------------------+");

	    for (EventVendorRegistration eventVendorRegistration : eventVendorRegistrationList) {
	        if (eventVendorRegistration != null) {
	            System.out.printf("| %-21s | %-14s | %-17s | %-23s | %-16s |\n",
	                    eventVendorRegistration.getEventVendorRegistrationId(),
	                    eventVendorRegistration.getVendor().getVendorId(),
	                    eventVendorRegistration.getEventRegistration().getEventRegistrationId(),
	                    eventVendorRegistration.getEventVendorRegistrationDate(),
	                    eventVendorRegistration.getNumberOfTables());
	            System.out.println("+-----------------------+----------------+-------------------+-------------------------+------------------+");
	        }
	    }
	}

		
			private static void deleteEventVendorRegistration() {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter the Event Vendor Registration Id");		
				String eventVendorRegistrationId = scanner.nextLine();
				EventVendorRegistrationServiceImpl eventVendorRegistrationServiceImpl = new EventVendorRegistrationServiceImpl();
				eventVendorRegistrationServiceImpl.deleteEventVendorRegistration(eventVendorRegistrationId);
			}

			private static void viewEventVendorRegistration() {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter the Event Vendor Registration Id");		
				String eventVendorRegistrationId = scanner.nextLine();
				EventVendorRegistrationServiceImpl eventVendorRegistrationServiceImpl = new EventVendorRegistrationServiceImpl();
				eventVendorRegistrationServiceImpl.viewEventVendorRegistration(eventVendorRegistrationId);
			}
			private static void saveEventVendorRegistration() {
			    Scanner scanner = new Scanner(System.in);
		
			    System.out.println("Enter the Event Vendor Registration Id");		
			    String eventVendorRegistrationId = scanner.nextLine();
		
			    VendorUtility.viewAllVendor();
			    System.out.println("Enter the Vendor Id");
			    String vendorId = scanner.nextLine();
		
			    EventRegistrationUtility.viewAllEventRegistration();
			    System.out.println("Enter the Event Registration Id");		
			    String eventRegistrationId = scanner.nextLine();
		
			    System.out.print("Enter the Event Vendor Registration Date\n");	
			    String registrationDate = scanner.nextLine();
			    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			    LocalDate eventVendorRegistrationDate = LocalDate.parse(registrationDate, formatter1);
		
			    System.out.println("Enter the Number of tables");		
			    int numberOfTables = scanner.nextInt();
		
			 // EventVendorRegistration eventVendorRegistration = null;
			    EventRegistration eventRegistration = new EventRegistration();
			    eventRegistration.setEventRegistrationId(eventRegistrationId);
			    Vendor vendor = new Vendor();
			    vendor.setVendorId(vendorId);
		
			    EventVendorRegistrationServiceImpl eventVendorRegistrationServiceImpl = new EventVendorRegistrationServiceImpl();
			  
			    
			    int totalCapacity = eventVendorRegistrationServiceImpl.TotalCapacity(eventRegistrationId);
			   System.out.println("Total Capacity for Event Registration : " + totalCapacity);
			    
			    int totalTables = eventVendorRegistrationServiceImpl.totalNumberOfTables(eventRegistrationId) + numberOfTables;
			    System.out.println("Total Number of Tables for Event Registration : " + totalTables);
			    
		     
			    int currentCapacity = totalCapacity - totalTables;
		
			    if (currentCapacity >= 0)
					  {
					   EventVendorRegistration eventVendorRegistration = new EventVendorRegistration(eventVendorRegistrationId, vendor, eventRegistration, eventVendorRegistrationDate, numberOfTables);
					   eventVendorRegistrationServiceImpl.saveEventVendorRegistration(eventVendorRegistration);
					  } 
			    else {
								        System.out.println("No more tables are available in this venue");
					 }
			
			}
}
