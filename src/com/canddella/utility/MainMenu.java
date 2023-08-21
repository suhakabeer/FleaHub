package com.canddella.utility;

import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		    int ch;
		    char option;
		    
		    do {
	   System.out.println("1.Venue     \n"
		    		    + "2.Event    \n"
		    			+ "3.Customer  \n"
		    			+ "4.Volunteer \n"
		    			+ "5.Vendor    \n"
		    			+ "6.Event Registration \n"
		    			+ "7.Event Vendor Registration \n"
		    			+ "8.Venue Payment \n"
		    			+ "9.Vendor Payment  \n"
		    			+ "10.Sponsorship  \n"
		    			+ "11.Promotion   \n"
		    			+ "12.Feedback \n"
		    			+ "13.PDF Generator\n"
		    			+ "14.Event Calender");
	   
		    	System.out.println("Enter your choice");
		    	ch = scanner.nextInt();
		    	switch(ch)
		    	 {
			    	case 1 :  VenueUtility.venueMenu();
			    	break;
			    	case 2:   EventUtility.EventMenu();
			    	break;
			    	case 3 :  CustomerUtility.customerMenu();
			    	break;
			    	case 4 :  VolunteerUtility.volunteerMenu();
			    	break;
			    	case 5 :  VendorUtility.vendorMenu();
			    	break;
			    	case 6 :  EventRegistrationUtility.EventRegistrationMenu();
			    	break;
			    	case 7:   EventVendorRegistrationUtility.EventVendorRegistrationMenu();
			    	break;
			    	case 8 :  VenuePaymentUtility.venuePaymentMenu();
			    	break;
			    	case 9 :  VendorPaymentUtility.vendorPaymentMenu();
			    	break;
			    	case 10 : SponsorshipUtility.SponsorshipMenu();
			    	break;
			    	case 11 : PromotionUtility.PromotionMenu();
			    	break;
			    	case 12 : FeedbackUtility.FeedbackMenu();
			    	break;
			    	case 13 : PdfGenerator.main(args);
			    	break;
			    	case 14 : EventCalendar.main(args);
		    	    break;
			    	default : System.out.println("Invalid choice. Please try again."); 
			    	break; 
			    		
		    	 }
		    	 System.out.println("Do you want to continue the update");	
		         scanner.nextLine();
		         option = scanner.nextLine().charAt(0);
		       } while (option == 'y'|| option == 'Y');				
		}

	}

