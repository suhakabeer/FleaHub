package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Event;
import com.canddella.entity.EventRegistration;
import com.canddella.entity.Venue;
import com.canddella.service.EventRegistrationServiceImpl;

public class EventRegistrationUtility {

	public static void main(String[] args) {
		
			EventRegistrationMenu();
			
		}

	public static void EventRegistrationMenu() {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter Your Choice");
		 int ch;
		 char option;
	        do {
	            System.out.println("1.Save Event Registration       2.View  Event Registration       3.Delete  Event Registration       4.View All  Event Registration       5.Update  Event Registration");
	            ch = scanner.nextInt();
	            switch (ch) {
	                case 1:
	                    saveEventRegistration();
	                    break;
	                case 2:
	                    viewEventRegistration();
	                    break;
	                case 3:
	                    deleteEventRegistration();
	                    break;
	                case 4:
	                    viewAllEventRegistration();
	                    break;
	                case 5:
	                    updateEventRegistration();
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

	private static void updateEventRegistration() {
		
		
		
	}

	public static void viewAllEventRegistration() {
	    EventRegistrationServiceImpl eventRegistrationServiceImpl = new EventRegistrationServiceImpl();
	    List<EventRegistration> eventRegistrationList = eventRegistrationServiceImpl.viewAllEventRegistration();

	    System.out.println("+-------------------------+----------------+----------------+-------------------------+");
	    System.out.printf("| %-23s | %-14s | %-14s | %-23s |\n",
	            "Event Registration Id", "Venue Id", "Event Id", "Event Registration Date");
	    System.out.println("+-------------------------+----------------+----------------+-------------------------+");

	    for (EventRegistration eventRegistration : eventRegistrationList) {
	        if (eventRegistration != null) {
	            System.out.printf("| %-23s | %-14s | %-14s | %-23s |\n",
	                    eventRegistration.getEventRegistrationId(),
	                    eventRegistration.getVenue().getVenueId(),
	                    eventRegistration.getEvent().getEventId(),
	                    eventRegistration.getEventRegistrationDate());
	            System.out.println("+-------------------------+----------------+----------------+-------------------------+");
	        }
	    }
	}

	private static void deleteEventRegistration() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Event Registration Id");		
		String eventRegistrationId = scanner.nextLine();
		EventRegistrationServiceImpl eventRegistrationServiceImpl = new EventRegistrationServiceImpl();
		eventRegistrationServiceImpl.deleteEventRegistration(eventRegistrationId);
		
	}

	private static void viewEventRegistration() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Event Registration Id");		
		String eventRegistrationId = scanner.nextLine();
		EventRegistrationServiceImpl eventRegistrationServiceImpl = new EventRegistrationServiceImpl();
		eventRegistrationServiceImpl.viewEventRegistration(eventRegistrationId);
	}

	private static void saveEventRegistration() {
		
		EventRegistration eventRegistration = null;
		//Event event = null;
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		System.out.println("Enter the Event Registration Id");		
		String eventRegistrationId = scanner.nextLine();
		
		VenueUtility.viewAllVenue();
		System.out.println("Enter the Venue Id");		
		String venueId = scanner.nextLine();
		
		EventUtility.viewAllEvent();
		System.out.println("Enter the Event Id");
		String eventId = scanner.nextLine();
		
		System.out.print("Enter the Event Registration Date\n");	
		String RegistrationDate = scanner.nextLine();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate eventRegistrationDate = LocalDate.parse(RegistrationDate, formatter1);
		
		Venue venue = new Venue();
        venue.setVenueId(venueId);
	
        Event event = new Event();
	    event.setEventId(eventId);
       
		

		eventRegistration = new EventRegistration(eventRegistrationId,venue, event, eventRegistrationDate);

		EventRegistrationServiceImpl eventRegistrationServiceImpl = new EventRegistrationServiceImpl();
		eventRegistrationServiceImpl.saveEventRegistration(eventRegistration);

	}

}


