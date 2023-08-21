package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Vendor;

import com.canddella.service.VendorServiceImpl;
import com.canddella.service.VenueServiceImpl;

public class VendorUtility {

	public static void main(String[] args) {
		
			vendorMenu();
			
		}

	public static void vendorMenu() {
		 Scanner scanner = new Scanner(System.in);
	        int ch;
	        char cont;
	        do {
	            System.out.println("1.Save Vendor       2.View Vendor      3.Delete Vendor      4.View All Vendor      5.Update Vendor");
	            System.out.println("Enter Your Choice");
	            ch = scanner.nextInt();
	            switch (ch) {
	                case 1:
	                    saveVendor();
	                    break;
	                case 2:
	                    viewVendor();
	                    break;
	                case 3:
	                    deleteVendor();
	                    break;
	                case 4:
	                    viewAllVendor();
	                    break;
	                case 5:
	                    updateVendor();
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

	private static void updateVendor() {
		
		 Scanner scanner = new Scanner(System.in);
		    int choice;
		    char option = 'Y';
		    VendorServiceImpl vendorServiceImpl = new VendorServiceImpl();
		    System.out.println("Enter the Vendor Id");
		    
		    String vendorId = scanner.nextLine();
		    Vendor vendor = vendorServiceImpl.getVendor(vendorId);

		    if (vendor != null) {
		        do {
		            System.out.println("1.Vendor Name      2.Vendor firm name       3.Vendor Address   4.Vendor City     5.Vendor State    6.Vendor Zipcode    7.Vendor Contact Number  8.Vendor Lisence Number    9.Vendor Product Category");
		            System.out.println("Enter Your Choice");
		            choice = scanner.nextInt();
		            String vendorStore;
		            switch (choice) {
		                case 1:
		                    vendorStore = "Vendor_name";
		                    System.out.println("Enter the New Vendor Name");
		                    scanner.nextLine(); // Consume the newline character
		                    String vendorName = scanner.nextLine();
		                    vendorServiceImpl.updateVendor(vendorId, vendorStore, vendorName);
		                    break;
		                case 2:
		                    vendorStore = "Vendor_firm_name";
		                    System.out.println("Enter the New Vendor Firm name");
		                    scanner.nextLine(); // Consume the newline character
		                    String vendorFirmName = scanner.nextLine();
		                    vendorServiceImpl.updateVendor(vendorId, vendorStore, vendorFirmName);
		                    break;
		               
			            case 3:
			            	vendorStore = "Vendor_address";
		                    System.out.println("Enter the New Vendor Address");
		                    scanner.nextLine(); // Consume the newline character
		                    String vendorAddress = scanner.nextLine();
		                    vendorServiceImpl.updateVendor(vendorId, vendorStore, vendorAddress);		   
		                    
		                    break;
			            case 4: 
				            vendorStore = "Vendor_city";
		                    System.out.println("Enter the New Vendor City");
		                    scanner.nextLine(); // Consume the newline character
		                    String vendorCity = scanner.nextLine();
		                    vendorServiceImpl.updateVendor(vendorId, vendorStore,  vendorCity );
			            	
		                    break;
		            case 5 :  
		                    vendorStore = "Vendor_state";
		                    System.out.println("Enter the New Vendor State");
		                    scanner.nextLine(); // Consume the newline character
		                    String vendorState = scanner.nextLine();
		                    vendorServiceImpl.updateVendor(vendorId, vendorStore,  vendorState );
			            break;
			            case 6 : vendorStore = "Vendor_zipcode";
	                    System.out.println("Enter the New Venue Capacity");
	                    scanner.nextLine(); // Consume the newline character
	                    int vendorZipcode = scanner.nextInt();
	                    vendorServiceImpl.updateVendor(vendorId, vendorStore, String.valueOf(vendorZipcode));;
			            break;
			            case 7 : vendorStore = " Vendor_phone_no";
	                    System.out.println("Enter the New Venue Contact Number");
	                    scanner.nextLine(); 
	                    double vendorPhoneNo  = scanner.nextDouble();
	                    vendorServiceImpl.updateVendor(vendorId, vendorStore, String.valueOf(vendorPhoneNo));;
			            break;
			            case 8 :  
			            	vendorStore = "Vendor_license_no";
		                    System.out.println("Enter the New Vendor License Number");
		                    scanner.nextLine(); // Consume the newline character
		                    String vendorLicenseNo = scanner.nextLine();
		                    vendorServiceImpl.updateVendor(vendorId, vendorStore,  vendorLicenseNo);
			            break;
			            case 9 : 
			            	vendorStore = "Vendor_product_category";
		                    System.out.println("Enter the New Vendor Product Category");
		                    scanner.nextLine(); // Consume the newline character
		                    String vendorProductCategory = scanner.nextLine();
		                    vendorServiceImpl.updateVendor(vendorId, vendorStore,  vendorProductCategory );
			            break;
		                default : break  ; 
		            }
		            System.out.println("Do you want to continue the update");	
		            scanner.nextLine();
		            option = scanner.nextLine().charAt(0);
		        } while (option == 'y'|| option == 'Y');	
		    }	
		}
	

	public static void viewAllVendor() {
		VendorServiceImpl vendorServiceImpl = new VendorServiceImpl();
		List<Vendor> vendorList = vendorServiceImpl.listAllVendor();
		System.out.println("+-----------+---------------+---------------------+----------------+--------------+--------------+----------------+-----------------+-------------------+---------------------------+");
        System.out.printf("| %-9s | %-13s | %-19s | %-14s | %-12s | %-12s | %-14s | %-15s | %-17s | %-25s |\n",
                "Vendor Id", "Vendor Name", "Vendor Firm Name", "Vendor Address", "Vendor City",
                "Vendor State", "Vendor Zipcode", "Vendor Phone No", "Vendor License No", "Vendor Product Category");
        System.out.println("+-----------+---------------+---------------------+----------------+--------------+--------------+----------------+-----------------+-------------------+---------------------------+");
		for (Vendor vendor : vendorList) {
			if (vendor!=null)
			{
				
	            System.out.printf("| %-9s | %-13s | %-19s | %-14s | %-12s | %-12s | %-14s | %-15s | %-17s | %-25s |\n",
	                    vendor.getVendorId(), vendor.getVendorName(), vendor.getVendorFirmName(),
	                    vendor.getVendorAddress(), vendor.getVendorCity(), vendor.getVendorState(),
	                    vendor.getVendorZipcode(), vendor.getVendorPhoneNo(),
	                    vendor.getVendorLicenseNo(), vendor.getVendorProductCategory());
            System.out.println("+-----------+---------------+---------------------+----------------+--------------+--------------+----------------+-----------------+-------------------+---------------------------+");
			    }
		}
	}
	private static void deleteVendor() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Venue Id");
		String vendorId = scanner.nextLine();
		VendorServiceImpl vendorServiceImpl = new VendorServiceImpl();
		vendorServiceImpl.deleteVendor(vendorId);
	}

	private static void viewVendor() {
		

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Vendor Id");
		String vendorId = scanner.nextLine();
		VendorServiceImpl vendorServiceImpl = new VendorServiceImpl();
		vendorServiceImpl.viewVendor(vendorId);
	}

	private static void saveVendor() {
		Vendor vendor = null;
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		System.out.println("Enter the Vendor Id");
		String vendorId = scanner.nextLine();
		System.out.println("Enter the Vendor Name");
		String vendorName = scanner.nextLine();
		System.out.println("Enter the Vendor firm Name");
		String vendorFirmName = scanner.nextLine();
		System.out.println("Enter the Vendor Address");
		String vendorAddress = scanner.nextLine();
		System.out.println("Enter the Vendor City");
		String vendorCity = scanner.nextLine();
		System.out.println("Enter the Vendor State");
		String vendorState = scanner.nextLine();
		System.out.println("Enter the Vendor Zipcode");
		int vendorZipcode = scanner.nextInt();
		System.out.println("Enter the Vendor Phone Number");
		double vendorPhoneNo = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter the Vendor License Number");
		String vendorLicenseNo = scanner.nextLine();
		//scanner.nextLine();
		System.out.println("Enter the Vendor Product Category");
		String vendorProductCategory = scanner.nextLine();
		
		
		vendor = new Vendor (vendorId ,vendorName,vendorFirmName,vendorAddress,vendorCity,vendorState,vendorZipcode,vendorPhoneNo,vendorLicenseNo,vendorProductCategory);
		VendorServiceImpl vendorServiceImpl = new VendorServiceImpl();
			vendorServiceImpl.saveVendor(vendor);
		
	}
		
	}



