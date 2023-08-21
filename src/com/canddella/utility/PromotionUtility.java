package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Event;
import com.canddella.entity.Promotion;

import com.canddella.service.PromotionServiceImpl;


public class PromotionUtility {

	public static void main(String[] args) {
		PromotionMenu();


	}

	public static void PromotionMenu() {
		 Scanner scanner = new Scanner(System.in);
		 char option;
	        int ch;
	        do {
	            System.out.println("1.Save Promotion         2.View Promotion       3.Delete Promotion         4.View All Promotion");
	            System.out.println("Enter Your Choice");
	            ch = scanner.nextInt();
	            switch (ch) {
	                case 1:
	                    savePromotion();
	                    break;
	                case 2:
	                    viewPromotion();
	                    break;
	                case 3:
	                    deletePromotion();
	                    break;
	                case 4:
	                    viewAllPromotion();
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

	private static void viewAllPromotion() {
		
		PromotionServiceImpl promotionServiceImpl = new PromotionServiceImpl();
		    List<Promotion> promotionList = promotionServiceImpl.ListAllPromotion();

		    System.out.println("+----------------+-------------------+------------------------+------------------------+------------------------+------------------------+------------------------------+");
		    System.out.printf("| %-14s | %-17s | %-22s | %-22s | %-22s | %-22s | %-28s |\n",
		            "Promotion id","Event id","Promotion Name", "Promotion Start Date", "Promotion End Date", "Discount", "Special Offer");
		    System.out.println("+----------------+-------------------+------------------------+------------------------+------------------------+------------------------+------------------------------+");

		    for (Promotion promotion : promotionList) {
		        if (promotion != null) {
		            System.out.printf("| %-14s | %-17s | %-22s | %-22s | %-22s | %-22s | %-28s |\n",
		                    promotion.getPromotionId(), promotion.getEvent().getEventId(), promotion.getPromotionName() , promotion.getPromotionStratDate(),
		                    promotion.getPromotionEndDate(), promotion.getDiscount(), promotion.getSpecialOffer());
		            System.out.println("+----------------+-------------------+------------------------+------------------------+------------------------+------------------------+------------------------------+");
		        }
		    }
		}
		
	

	private static void deletePromotion() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Promotion Id");
		String promotionId = scanner.nextLine();
		PromotionServiceImpl promotionServiceImpl = new PromotionServiceImpl();
		promotionServiceImpl.deletePromotion(promotionId);
	}

	private static void viewPromotion() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Promotion Id");
		String promotionId = scanner.nextLine();
		PromotionServiceImpl promotionServiceImpl = new PromotionServiceImpl();
		promotionServiceImpl.viewPromotion(promotionId);
	}

	private static void savePromotion() {
    Promotion promotion = null;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Promotion Id");		
		String promotionId = scanner.nextLine();
		//scanner.nextLine();
		EventUtility.viewAllEvent();
		System.out.println("Enter the Event Id");
		String eventId = scanner.nextLine();
		System.out.println("Enter the Promotion Name");	
		String promotionName = scanner.nextLine();
		
		System.out.print("Enter the Promotion Start Date\n");		
		String promotionStartDate = scanner.nextLine();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");		
		LocalDate promotionStartdate = LocalDate.parse(promotionStartDate, formatter);
		
		System.out.print("Enter the Promotion End Date\n");		
		String promotionEndDate = scanner.nextLine();		
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");		
		LocalDate promotionEnddate = LocalDate.parse(promotionEndDate, formatter1);
		
		System.out.println("Enter the Discount Details");
		String discount = scanner.nextLine();
		System.out.println("Enter the Special Offers");	
		String specialOffer = scanner.nextLine();
		
		Event event = new Event();
		event.setEventId(eventId);

		
		promotion = new Promotion (promotionId, event, promotionName, promotionStartdate,promotionEnddate,discount,specialOffer);
		PromotionServiceImpl promotionServiceImpl = new PromotionServiceImpl();
		promotionServiceImpl.savePromotion(promotion);
	}
		
	}
		
	


