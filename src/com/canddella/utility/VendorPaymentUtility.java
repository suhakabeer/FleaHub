package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.EventVendorRegistration;
import com.canddella.entity.VendorPayment;
import com.canddella.service.VendorPaymentServiceImpl;

public class VendorPaymentUtility {

	public static void main(String[] args) {
		
		vendorPaymentMenu();
	}

	public static void vendorPaymentMenu() {
		Scanner scanner = new Scanner(System.in);
		 char option;
	        int ch;
	        do {
	            System.out.println("1.Save Vendor Payment         2.View Vendor Payment      3.Delete Vendor Payment        4.View All Vendor Payment");
	            System.out.println("Enter Your Choice");
	            ch = scanner.nextInt();
	            switch (ch) {
	                case 1:
	                    saveVendorPayment();
	                    break;
	                case 2:
	                    viewVendorPayment();
	                    break;
	                case 3:
	                    deleteVendorPayment();
	                    break;
	                case 4:
	                    viewAllVendorPayment();
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	            System.out.println("Do you want to continue");
	            scanner.nextLine();
	            option = scanner.nextLine().charAt(0);
	        } while (option == 'y'|| option == 'Y');
}

	private static void viewAllVendorPayment() {

	    VendorPaymentServiceImpl vendorPaymentService = new VendorPaymentServiceImpl();
	    List<VendorPayment> vendorPaymentList = vendorPaymentService.listAllVendorPayment();
	    
	    System.out.println("+---------------------------+--------------------------------+------------------------+------------------------+------------------------+-------------------------+");
	    System.out.printf("| %-25s | %-30s | %-22s | %-22s | %-22s | %-23s |\n",
	            "Vendor Payment Id", "Event Vendor Registration Id", "Vendor Payment Amount", "Vendor Payment Date", "Vendor Payment Mode",
	            "Vendor Payment Status");
	    System.out.println("+---------------------------+--------------------------------+------------------------+------------------------+------------------------+-------------------------+");
	    
	    for (VendorPayment vendorPayment : vendorPaymentList) {
	        if (vendorPayment != null) {
	            System.out.printf("| %-25s | %-30s | %-22s | %-22s | %-22s | %-23s |\n",
	                    vendorPayment.getVendorPaymentId(), vendorPayment.getEventVendorRegistration().getEventVendorRegistrationId(), vendorPayment.getVendorPaymentAmount(),
	                    vendorPayment.getVendorPaymentDate(), vendorPayment.getVendorPaymentMode(), vendorPayment.getVendorPaymentStatus());
	    System.out.println("+---------------------------+--------------------------------+------------------------+------------------------+------------------------+-------------------------+");
	        }
	    }
	}

	

	private static void deleteVendorPayment() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Vendor Payment Id");
		String vendorPaymentId = scanner.nextLine();
		VendorPaymentServiceImpl vendorPaymentServiceImpl = new VendorPaymentServiceImpl();
		vendorPaymentServiceImpl.deleteVendorPayment(vendorPaymentId);
	}

	private static void viewVendorPayment() {
		

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Vendor Payment Id");
		String vendorPaymentId = scanner.nextLine();
		VendorPaymentServiceImpl vendorPaymentServiceImpl = new VendorPaymentServiceImpl();
		vendorPaymentServiceImpl.viewVendorPayment(vendorPaymentId);
	}

	private static void saveVendorPayment() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the  Vendor Payment Id");	
		String VendorPaymentId = scanner.nextLine();
		
		EventVendorRegistrationUtility.viewAllEventVendorRegistration();
		System.out.println("Enter the Event Vendor Registration Id");	
		String eventVendorRegistrationId = scanner.nextLine();
		
		System.out.println("Enter the Vendor Payment Amount");
		double vendorPaymentAmount = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Enter the Vendor Payment Date \n");	
		String paymentDate = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate vendorPaymentDate = LocalDate.parse(paymentDate, formatter);
		
		System.out.print("Enter the Vendor Payment Mode\n");
	    String vendorPaymentMode = scanner.nextLine();
	     
	    System.out.print("Enter the Vendor Payment Status\n");
	    String vendorPaymentStatus = scanner.nextLine();
	         
	    EventVendorRegistration eventVendorRegistration = new EventVendorRegistration();
	    eventVendorRegistration.setEventVendorRegistrationId(eventVendorRegistrationId);
        
        VendorPayment vendorPayment = new VendorPayment (VendorPaymentId,  eventVendorRegistration, vendorPaymentAmount, vendorPaymentDate, vendorPaymentMode, vendorPaymentStatus);
        VendorPaymentServiceImpl vendorPaymentServiceImpl = new VendorPaymentServiceImpl();
        vendorPaymentServiceImpl.saveVendorPayment(vendorPayment);
	}
}
