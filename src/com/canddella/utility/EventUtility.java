package com.canddella.utility;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Event;
import com.canddella.entity.Venue;
import com.canddella.service.EventServiceImpl;
import com.canddella.service.VenueServiceImpl;


public class EventUtility {

	public static void main(String[] args) {
			EventMenu();
			
		}

	public static void EventMenu() {
		
		 Scanner scanner = new Scanner(System.in);
	        int ch;
	        char cont;
	        do {
	            System.out.println("1.Save Event       2.View Event       3.Delete Event       4.View All Event       5.Update Event");
	            System.out.println("Enter Your Choice");
	            ch = scanner.nextInt();
	            switch (ch) {
	                case 1:
	                    saveEvent();
	                    break;
	                case 2:
	                    viewEvent();
	                    break;
	                case 3:
	                    deleteEvent();
	                    break;
	                case 4:
	                    viewAllEvent();
	                    break;
	                case 5:
	                    updateEvent();
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	            System.out.println("Do you want to continue");	
	            scanner.nextLine();
	            cont = scanner.nextLine().charAt(0);
	        } while (cont == 'y'|| cont == 'Y');
	    }

	
	private static void updateEvent() {
		
		 Scanner scanner = new Scanner(System.in);
		    int choice;
		    char option = 'Y';
		    EventServiceImpl eventServiceImpl = new EventServiceImpl();
		    System.out.println("Enter the Event Id");
		    
		    String eventId = scanner.nextLine();
		   Event event = eventServiceImpl.getEvent(eventId);

		    if (event != null) {
		        do {
		            System.out.println("1.Event Name       2.Event Description       3.Event Start Date       4.Event End Date     5.Total Volunteers");
		            System.out.println("Enter Your Choice");
		            choice = scanner.nextInt();
		            scanner.nextLine();
		            String eventStore;
		            
		            switch (choice) {
		                case 1:
		                    eventStore = "Event_name";
		                    System.out.println("Enter the New Event Name");
		                   // scanner.nextLine(); 
		                    String eventName = scanner.nextLine();
		                    eventServiceImpl.updateEvent(eventId, eventStore, eventName);
		                    break;
		                case 2:
		                	eventStore = "Event_describtion";
		                    System.out.println("Enter the new Event Description");		                   
		                    String eventDescription = scanner.nextLine();
		                    eventServiceImpl.updateEvent(eventId, eventStore, eventDescription);
		                    break;
		                case 3:				   
	                	    eventStore = "Event_Start_Date";
	                	    System.out.println("Enter the new Event Start Date");
	                	    String eventStartDate = scanner.nextLine();	               		   
	               		    eventServiceImpl.updateEvent(eventId  , eventStore,eventStartDate);
		                    break;
			            case 4 : 
			            	 eventStore = "Event_End_Date";
			            	 System.out.println("Enter the new Event End Date");
			            	 String eventEndDate = scanner.nextLine();
			            	 eventServiceImpl.updateEvent(eventId  , eventStore,eventEndDate);
		                    break;
			            case 5 : 
			            	 eventStore = "Total_Volunteers";
			            	 System.out.println("Enter the Total Number Of Volunteers");
			            	 String totalVolunteers = scanner.nextLine();
			            	 eventServiceImpl.updateEvent(eventId  , eventStore,totalVolunteers);
			            	 break;
		                    
		                default : break  ; 
		            }
		            System.out.println("Do you want to continue the update");	
		            option = scanner.nextLine().charAt(0);
		        } while (option == 'y'|| option == 'Y');	
		    }	
	}

	public static void viewAllEvent() {
	    EventServiceImpl eventServiceImpl = new EventServiceImpl();
	    List<Event> eventList = eventServiceImpl.listAllEvent();

	    System.out.println("+----------------+----------------------+------------------------+---------------------+-------------------+---------------------+");
	    System.out.printf("| %-14s | %-20s | %-22s | %-19s | %-17s | %-19s |\n",
	            "Event Id", "Event Name", "Event Description", "Event Start Date", "Event End Date","Total Volunteers");
	    System.out.println("+----------------+----------------------+------------------------+---------------------+-------------------+---------------------+");
	    for (Event event : eventList) {
	        if (event != null) {
	            System.out.printf("| %-14s | %-20s | %-22s | %-19s | %-17s | %-19s |\n",
	                    event.getEventId(),
	                    event.getEventName(),
	                    event.getEventDescribtion(),
	                    event.getEventStartDate(),
	                    event.getEventEndDate(),
	                    event.getTotalVolunteer());
	            System.out.println("+----------------+----------------------+------------------------+---------------------+-------------------+---------------------+");
	        }
	    }
	}
	

	private static void deleteEvent() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Event Id");
		String eventId = scanner.nextLine();
		EventServiceImpl eventServiceImpl = new EventServiceImpl();
		eventServiceImpl.deleteEvent(eventId);
		
	}
	
	private static void viewEvent() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the event Id");
		String eventId = scanner.nextLine();
		EventServiceImpl eventServiceImpl = new EventServiceImpl();
		eventServiceImpl.viewEvent(eventId);
		
	}

	private static void saveEvent() {
		
		Event event = null;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Event Id");		
		String eventId = scanner.nextLine();
		System.out.println("Enter the Event Name");
		
		String eventName = scanner.nextLine();
		System.out.println("Enter the Event Description");
		
		String eventDescription = scanner.nextLine();		
		System.out.print("Enter the Event start Date\n");		
		String startDate = scanner.nextLine();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");		
		LocalDate eventStartDate = LocalDate.parse(startDate, formatter);
		
		System.out.print("Enter the Event end Date\n");	
		String endDate = scanner.nextLine();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate eventEndDate = LocalDate.parse(endDate, formatter1);
		
		System.out.println("Enter the Total Number Of Volunteers");		
		int totalVolunteers = scanner.nextInt();

		
		event = new Event (eventId,eventName ,eventDescription,eventStartDate,eventEndDate,totalVolunteers);
		EventServiceImpl eventServiceImpl = new EventServiceImpl();
			eventServiceImpl.saveEvent(event);
	}

	}

	


