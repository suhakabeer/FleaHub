package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Venue;
import com.canddella.service.VenueServiceImpl;

public class VenueUtility {
	
		public static void main(String[] args) {
			venueMenu();
			
		}

		public static void venueMenu() {
	        Scanner scanner = new Scanner(System.in);
	        int ch;
	        char cont = 'y';
	        do {
	            System.out.println("1.Save Venue       2.View Venue       3.Delete Venue       4.View All Venue       5.Update Venue");
	            System.out.println("Enter Your Choice");
	            ch = scanner.nextInt();
	            
	            switch (ch) {
	                case 1:
	                    saveVenue();
	                    break;
	                case 2:
	                    viewVenue();
	                    break;
	                case 3:
	                    deleteVenue();
	                    break;
	                case 4:
	                    viewAllVenue();
	                    break;
	                case 5:
	                    updateVenue();
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	            System.out.println("Do you want to continue the update");	
	            scanner.nextLine();
	            cont = scanner.nextLine().charAt(0);
	        } while (cont == 'y'|| cont == 'Y');
	    }
	
				private static void updateVenue() {
				    Scanner scanner = new Scanner(System.in);
				    int choice;
				    char option = 'Y';
				    VenueServiceImpl venueServiceImpl = new VenueServiceImpl();
				    System.out.println("Enter the Venue Id");
				    
				    String venueId = scanner.nextLine();
				    Venue venue = venueServiceImpl.getVenue(venueId);

				    if (venue != null) {
				        do {
				            System.out.println("1.Venue Name      2.Venue Location      3.Venue Capacity      4.Venue Contact Number");
				            System.out.println("Enter Your Choice");
				            choice = scanner.nextInt();
				            String venueStore;
				            switch (choice) {
				                case 1:
				                    venueStore = "Venue_name";
				                    System.out.println("Enter the New Venue Name");
				                    scanner.nextLine(); // Consume the newline character
				                    String venueName = scanner.nextLine();
				                    venueServiceImpl.updateVenue(venueId, venueStore, venueName);
				                    break;
				                case 2:
				                    venueStore = "Venue_location";
				                    System.out.println("Enter the New Venue location");
				                    scanner.nextLine(); // Consume the newline character
				                    String venueLocation = scanner.nextLine();
				                    venueServiceImpl.updateVenue(venueId, venueStore, venueLocation);
				                    break;
				                case 3:				   
				                    venueStore = "Venue_capacity";
				                    System.out.println("Enter the New Venue Capacity");
				                    scanner.nextLine(); // Consume the newline character
				                    int venueCapacity = scanner.nextInt();
				                    venueServiceImpl.updateVenue(venueId, venueStore, String.valueOf(venueCapacity));
				                    break;
					            case 4: 
					            	venueStore = "Venue_capacity";
				                    System.out.println("Enter the New Venue Contact Number");
				                    scanner.nextLine(); 
				                    double venueContactNo  = scanner.nextDouble();
				                    venueServiceImpl.updateVenue(venueId, venueStore, String.valueOf(venueContactNo));
				                    break;
				                default : break  ; 
				            }
				            System.out.println("Do you want to continue the update");	
				            scanner.nextLine();
				            option = scanner.nextLine().charAt(0);
				        } while (option == 'y'|| option == 'Y');	
				    }	
				}


			private static void saveVenue() {
				Venue venue = null;
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter the Venue Id");
				String venueId = scanner.nextLine();
				System.out.println("Enter the Venue Name");
				String venueName = scanner.nextLine();
				System.out.println("Enter the Venue Location");
				String venueLocation = scanner.nextLine();
				System.out.println("Enter the Venue Capacity");
				int venueCapacity = scanner.nextInt();
				System.out.println("Enter the Venue Contact Number");
				double venueContactNo = scanner.nextDouble();
				
				venue = new Venue (venueId,venueName,venueLocation,venueCapacity,venueContactNo);
				VenueServiceImpl venueServiceImpl = new VenueServiceImpl();
					venueServiceImpl.saveVenue(venue);
			}

		private static void viewVenue() {
				
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter the Venue Id");
				String venueId = scanner.nextLine();
				VenueServiceImpl venueServiceImpl = new VenueServiceImpl();
				venueServiceImpl.viewVenue(venueId);
				
			}

			private static void deleteVenue() {
				
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter the Venue Id");
				String venueId = scanner.nextLine();
				VenueServiceImpl venueServiceImpl = new VenueServiceImpl();
				venueServiceImpl.deleteVenue(venueId);
				
			}
			
			public static void viewAllVenue() {
			    VenueServiceImpl venueServiceImpl = new VenueServiceImpl();
			    List<Venue> venueList = venueServiceImpl.listAllVenue();

			    System.out.println("+-----------+---------------------+------------------+----------------+-------------------+");
			    System.out.printf("| %-9s | %-19s | %-16s | %-14s | %-17s |\n",
			            "Venue Id", "Venue Name", "Venue Location", "Venue Capacity", "Venue Contact No");
			    System.out.println("+-----------+---------------------+------------------+----------------+-------------------+");

			    for (Venue venue : venueList) {
			        if (venue != null) {
			            System.out.printf("| %-9s | %-19s | %-16s | %-14s | %-17s |\n",
			                    venue.getVenueId(), venue.getVenueName(), venue.getVenueLocation(),
			                    venue.getVenueCapacity(), venue.getVenueContactNo());
			            System.out.println("+-----------+---------------------+------------------+----------------+-------------------+");
			        }
			    }
			}
}
