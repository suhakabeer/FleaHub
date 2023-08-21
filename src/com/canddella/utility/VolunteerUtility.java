package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.entity.Event;
import com.canddella.entity.Vendor;
import com.canddella.entity.Volunteer;
import com.canddella.service.VendorServiceImpl;
import com.canddella.service.VolunteerServiceImpl;

public class VolunteerUtility {

	public static void main(String[] args) {
		volunteerMenu();

	}

	public static void volunteerMenu() {
		Scanner scanner = new Scanner(System.in);
        int ch;
        char option;
        do {
            System.out.println("1.Save Volunteer Registration      2.View Volunteer Registration       3.Delete Volunteer Registration       4.View All Volunteer Registration");
            System.out.println("Enter Your Choice");
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    saveVolunteerRegistration();
                    break;
                case 2:
                    viewVolunteerRegistration();
                    break;
                case 3:
                    deleteVolunteerRegistration();
                    break;
                case 4:
                    viewAllVolunteerRegistration();
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

	private static void viewAllVolunteerRegistration() {
	    VolunteerServiceImpl volunteerServiceImpl = new VolunteerServiceImpl();
	    List<Volunteer> volunteerList = volunteerServiceImpl.listAllVolunteer();

	    System.out.println("+--------------+---------------+------------------+---------------------------+------------------------+-------------------+----------------+-----------------+-------------------+-------------------------+-----------------------------+");
	    System.out.printf("| %-12s | %-13s | %-16s | %-25s | %-22s | %-17s | %-14s | %-15s | %-17s | %-23s |%-28s |\n",
	            "Volunteer Id", "Event Id", "Volunteer Name", "Volunteer Email", "Volunteer Phone Number", "Volunteer Address",
	            "Volunteer City", "Volunteer State", "Volunteer Country", "Volunteer Zipcode", "Volunteer Registration Date");
	    System.out.println("+--------------+---------------+------------------+---------------------------+------------------------+-------------------+----------------+-----------------+-------------------+-------------------------+-----------------------------+");

	    for (Volunteer volunteer : volunteerList) {
	        if (volunteer != null) {
	            System.out.printf("| %-12s | %-13s | %-16s | %-25s | %-22s | %-17s | %-14s | %-15s | %-17s | %-23s |%-28s |\n",
	                    volunteer.getVolunteerId(), volunteer.getEvent().getEventId(), volunteer.getVolunteerName(),
	                    volunteer.getVolunteerEmail(), volunteer.getVolunteerPhoneNo(), volunteer.getVolunteerAddress(),
	                    volunteer.getVolunteerCity(), volunteer.getVolunteerState(), volunteer.getVolunteerCountry(),
	                    volunteer.getVolunteerZipcode(), volunteer.getVolunteerRegistrationDate());
	            System.out.println("+--------------+---------------+------------------+---------------------------+------------------------+-------------------+----------------+-----------------+-------------------+-------------------------+-----------------------------+");
	        }
	    }
	}


	private static void deleteVolunteerRegistration() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Volunteer Id");
		String volunteerId = scanner.nextLine();
		VolunteerServiceImpl volunteerServiceImpl = new VolunteerServiceImpl();
		volunteerServiceImpl.deleteVolunteer(volunteerId);
		
	}

	private static void viewVolunteerRegistration() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Volunteer Id");
		String volunteerId = scanner.nextLine();
		VolunteerServiceImpl volunteerServiceImpl = new VolunteerServiceImpl();
		volunteerServiceImpl.viewVolunteer(volunteerId);
		
	}

	private static void saveVolunteerRegistration() {

		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Vounteer Id");
		String volunteerId = scanner.nextLine();
		EventUtility.viewAllEvent();
		System.out.println("Enter the Event Id");
		String eventId = scanner.nextLine();
		System.out.println("Enter the Vounteer Name");
		String volunteerName = scanner.nextLine();
		System.out.println("Enter the Vounteer Email");
		String volunteerEmail = scanner.nextLine();
		System.out.println("Enter the Vounteer Phone Number");
		double volunteerPhoneNo= scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter the Vounteer Address");
		String volunteerAddress = scanner.nextLine();
		System.out.println("Enter the Vounteer City");
		String volunteerCity = scanner.nextLine();
		System.out.println("Enter the Vounteer State");
		String volunteerState = scanner.nextLine();
		System.out.println("Enter the Vounteer Country");
		String volunteerCountry = scanner.nextLine();
		System.out.println("Enter the Vounteer Zipcode");
		int volunteerZipcode = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Vounteer Registration Date");
		String registrationDate = scanner.nextLine();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate volunteerRegistrationDate = LocalDate.parse(registrationDate, formatter1);
	    
	    Event event = new Event();
		event.setEventId(eventId);
	    
	    VolunteerServiceImpl volunteerServiceImpl = new VolunteerServiceImpl();
	    
	    int totalVolunteers = volunteerServiceImpl.totalVolunteers(eventId);
	    System.out.println("Total Volunteers :-"+ totalVolunteers);
		
	    int totalVolunteerCapacity = volunteerServiceImpl.TotalVolunteerCapacity(eventId);
	     System.out.println("Total Volunteers Capacity :-"+ totalVolunteerCapacity);
	    
	    int vacancy =  totalVolunteerCapacity - totalVolunteers;
	    
	    if (vacancy >= 0)
	    {
	    	Volunteer volunteer = new Volunteer (volunteerId,event,volunteerName,volunteerEmail,volunteerPhoneNo,volunteerAddress,volunteerCity,volunteerState,volunteerCountry,volunteerZipcode,volunteerRegistrationDate);			
			volunteerServiceImpl.saveVolunteer(volunteer);
	    }
	    
	    else
	    {
		    System.out.println("No More Volunteeers Can Be Registered");
	    }		
	}	
}
		
	


