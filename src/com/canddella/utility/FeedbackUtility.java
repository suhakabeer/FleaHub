package com.canddella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.entity.Event;
import com.canddella.entity.Feedback;

import com.canddella.service.FeedbackServiceImpl;


public class FeedbackUtility {

	public static void main(String[] args) {
		FeedbackMenu();

	}

	public static void FeedbackMenu() {
		
		 Scanner scanner = new Scanner(System.in);
		 char option;
	        int ch;
	        do {
	            System.out.println("1.Save Feedback         2.View Feedback       3.Delete Feedback         4.View All Feedbacks");
	            System.out.println("Enter Your Choice");
	            ch = scanner.nextInt();
	            switch (ch) {
	                case 1:
	                    saveFeedback ();
	                    break;
	                case 2:
	                    viewFeedback ();
	                    break;
	                case 3:
	                    deleteFeedback ();
	                    break;
	                case 4:
	                    viewAllFeedback ();
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

	private static void saveFeedback() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Feedback Id");
		String feedbackId = scanner.nextLine();
		CustomerUtility.viewAllCustomer();
		System.out.println("Enter the Customer Id");
		String customerId = scanner.nextLine();
		EventUtility.viewAllEvent();
		System.out.println("Enter the Event Id");
		String eventId = scanner.nextLine();
		
		System.out.println("Enter the Rating");
		double rating = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter the Comment");
		String comment = scanner.nextLine();
		
		System.out.println("Enter the Review Date");
		String reviewDate = scanner.nextLine();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate reviewdate = LocalDate.parse(reviewDate, formatter1);
		
		 Event event = new Event();
		 event.setEventId(eventId);
		 
		 Customer customer = new Customer();
		 customer.setCustomerId(customerId);

		
		Feedback feedback = new Feedback (feedbackId,customer,event,rating,comment,reviewdate);
		FeedbackServiceImpl feedbackServiceImpl = new FeedbackServiceImpl();
		feedbackServiceImpl.saveFeedback(feedback);
		
	}

	private static void viewFeedback() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Feedback Id");
		String feedbackId = scanner.nextLine();
		FeedbackServiceImpl feedbackServiceImpl = new FeedbackServiceImpl();
		feedbackServiceImpl.viewFeedback(feedbackId);

		
	}

	private static void deleteFeedback() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Feedback Id");
		String feedbackId = scanner.nextLine();
		FeedbackServiceImpl feedbackServiceImpl = new FeedbackServiceImpl();
		feedbackServiceImpl.deleteFeedback(feedbackId);
		
	}

	private static void viewAllFeedback() {
		
		FeedbackServiceImpl feedbackServiceImpl = new FeedbackServiceImpl();
	    List<Feedback> feedbackList = feedbackServiceImpl.ListAllFeedback();

	    System.out.println("+----------------+-------------------+---------------------+---------------------+-------------------------------------+------------------+");
	    System.out.printf("| %-14s | %-17s | %-19s | %-19s | %-35s |%-17s |\n",
	            "Feedback Id", "Customer Id", "Event Id", "Rating", "Comment", "Review Date");
	    System.out.println("+----------------+-------------------+---------------------+---------------------+-------------------------------------+------------------+");

	    for (Feedback feedback : feedbackList) {
	        if (feedback != null) {
	            System.out.printf("| %-14s | %-17s | %-19s | %-19s | %-35s |%-17s |\n",
	                   feedback.getFeedbackId(), feedback.getCustomer().getCustomerId(), feedback.getEvent().getEventId(),feedback.getRating(),
	                   feedback.getComment(), feedback.getReviewDate());
	            System.out.println("+----------------+-------------------+---------------------+---------------------+-------------------------------------+------------------+");
	        }
	    }
	}
	}

