package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Event;
import com.canddella.entity.Promotion;
import com.canddella.entity.Sponsorship;
import com.canddella.service.PromotionServiceImpl;
import com.canddella.service.SponsorshipServiceImpl;

public class SponsorshipUtility {

	public static void main(String[] args) {
		SponsorshipMenu();

	}

	public static void SponsorshipMenu() {
		 Scanner scanner = new Scanner(System.in);
		 char option;
	        int ch;
	        do {
	            System.out.println("1.Save Sponsorship         2.View Sponsorshipn       3.Delete Sponsorship         4.View All Sponsorship");
	            System.out.println("Enter Your Choice");
	            ch = scanner.nextInt();
	            switch (ch) {
	                case 1:
	                    saveSponsorship();
	                    break;
	                case 2:
	                    viewSponsorship();
	                    break;
	                case 3:
	                    deleteSponsorship();
	                case 4:
	                    viewAllSponsorship();
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

	private static void viewAllSponsorship() {
		SponsorshipServiceImpl sponsorshipServiceImpl = new SponsorshipServiceImpl();
	    List<Sponsorship> sponsorshipList = sponsorshipServiceImpl.ListAllSponsorship();

	    System.out.println("+----------------+-------------------+---------------------+---------------------+");
	    System.out.printf("| %-14s | %-17s | %-19s | %-19s |\n",
	            "Sponsorship Id","Event id","Sponsor Name", "Sponsorship Amount");
	    System.out.println("+----------------+-------------------+---------------------+---------------------+");

	    for (Sponsorship sponsorship : sponsorshipList) {
	        if (sponsorship != null) {
	            System.out.printf("| %-14s | %-17s | %-19s | %-19s |\n", sponsorship.getSponsorshipId(), sponsorship.getEvent().getEventId(),sponsorship.getSponsorName(), sponsorship.getSponsorshipAmount());
	            System.out.println("+----------------+-------------------+---------------------+---------------------+");
	        }
	    }
	}
	

	private static void deleteSponsorship() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Sponsorship Id");
		String sponsorshipId = scanner.nextLine();
		SponsorshipServiceImpl sponsorshipServiceImpl = new SponsorshipServiceImpl();
		sponsorshipServiceImpl.deleteSponsorship(sponsorshipId);
		
	}

	private static void viewSponsorship() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Sponsorship Id");
		String sponsorshipId = scanner.nextLine();
		SponsorshipServiceImpl sponsorshipServiceImpl = new SponsorshipServiceImpl();
		sponsorshipServiceImpl.viewSponsorship(sponsorshipId);
	}

	private static void saveSponsorship() {
		Sponsorship sponsorship = null;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Sponsorship Id");		
		String sponsorshiId = scanner.nextLine();
		EventUtility.viewAllEvent();
		System.out.println("Enter the Event Id");
		String eventId = scanner.nextLine();
		System.out.println("Enter the Sponsor Name");	
		String sponsorName = scanner.nextLine();
		
		System.out.print("Enter the Sponsorship Amount\n");		
		double sponsorshipDate = scanner.nextDouble();		
		
		Event event = new Event();
		event.setEventId(eventId);

		
		sponsorship = new Sponsorship (sponsorshiId, event,sponsorName,sponsorshipDate);
		SponsorshipServiceImpl sponsorshipServiceImpl = new SponsorshipServiceImpl();
		sponsorshipServiceImpl.saveSponsorship(sponsorship);
	}

		
	}

