package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Vendor;
import com.canddella.entity.Venue;
import com.canddella.entity.VenuePayment;
import com.canddella.service.VenuePaymentServiceImpl;

public class VenuePaymentUtility {

	public static void main(String[] args) {
		venuePaymentMenu();

	}

	public static void venuePaymentMenu() {
		 Scanner scanner = new Scanner(System.in);
		 char option;
	        int ch;
	        do {
	            System.out.println("1.Save Venue Payment         2.View Venue Payment      3.Delete Venue Payment        4.View All Venue Payment");
	            System.out.println("Enter Your Choice");
	            ch = scanner.nextInt();
	            switch (ch) {
	                case 1:
	                    saveVenuePayment();
	                    break;
	                case 2:
	                    viewVenuePayment();
	                    break;
	                case 3:
	                    deleteVenuePayment();
	                    break;
	                case 4:
	                    viewAllVenuePayment();
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

	private static void viewAllVenuePayment() {
	    VenuePaymentServiceImpl venuePaymentService = new VenuePaymentServiceImpl();
	    List<VenuePayment> venuePaymentList = venuePaymentService.listAllVenuePayment();
	    System.out.println("+--------------------+------------------+----------------------+--------------------+--------------------+----------------------+");
	    System.out.printf("| %-18s | %-16s | %-20s | %-18s | %-18s | %-20s |\n",
	            "Venue Payment Id", "Venue Id", "Venue Payment Amount", "Venue Payment Date", "Venue Payment Mode",
	            "Venue Payment Status");
	    System.out.println("+--------------------+------------------+----------------------+--------------------+--------------------+----------------------+");
	    for (VenuePayment venuePayment : venuePaymentList) {
	        if (venuePayment != null) {
	            System.out.printf("| %-18s | %-16s | %-20s | %-18s | %-18s | %-20s |\n",
	                    venuePayment.getVenuePaymentId(), venuePayment.getVenue().getVenueId(), venuePayment.getVenuePaymentAmount(),
	                    venuePayment.getVenuePaymentDate(), venuePayment.getVenuePaymentMode(), venuePayment.getVenuePaymentStatus());
	            System.out.println("+--------------------+------------------+----------------------+--------------------+--------------------+----------------------+");
	        }
	    }
	}



	private static void deleteVenuePayment() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Venue Payment Id");
		String venuePaymentId = scanner.nextLine();
		VenuePaymentServiceImpl VenuePaymentServiceImpl = new VenuePaymentServiceImpl();
		VenuePaymentServiceImpl.deleteVenuePaymen(venuePaymentId);
		
	}

	private static void viewVenuePayment() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Venue Payment Id");
		String venuePaymentId = scanner.nextLine();
		VenuePaymentServiceImpl VenuePaymentServiceImpl = new VenuePaymentServiceImpl();
		VenuePaymentServiceImpl.viewVenuePayment(venuePaymentId);
	}

	private static void saveVenuePayment() {
		
//    VenuePayment venuePayment = null;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Venue Payment Id");	
		String venuePaymentId = scanner.nextLine();
		VenueUtility.viewAllVenue();
		System.out.println("Enter the Venue Id");	
		String venueId = scanner.nextLine();
		
		System.out.println("Enter the Venue Payment Amount");
		double venuePaymentAmount = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Enter the Venue Payment Date \n");	
		String paymentDate = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate venuePaymentDate = LocalDate.parse(paymentDate, formatter);
		
		System.out.print("Enter the Venue Payment Mode\n");
	    String venuePaymentMode = scanner.nextLine();
	     
	    System.out.print("Enter the Venue Payment Status\n");
	    String venuePaymentStatus = scanner.nextLine();
	         
	    Venue venue = new Venue();
        venue.setVenueId(venueId);
        
        VenuePayment venuePayment = new VenuePayment (venuePaymentId, venue, venuePaymentAmount, venuePaymentDate, venuePaymentMode, venuePaymentStatus);
		VenuePaymentServiceImpl VenuePaymentServiceImpl = new VenuePaymentServiceImpl();
		VenuePaymentServiceImpl.saveVenuePayment(venuePayment);
	}
		
	}

