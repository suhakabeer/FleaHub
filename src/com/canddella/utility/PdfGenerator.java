package com.canddella.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGenerator {
	 
	public static void main(String[] args) {
	    	Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter Event ID: ");
	        String eventId = scanner.nextLine();
	        scanner.close();

	        generatePdf(eventId);
	    }
    public static void generatePdf(String eventId) {
        DataSource ds = DBConnectionPool.getDataSource();
        try {
            Document document = new Document();
            String file_name = "C:\\FleaFair\\FleaFair.pdf";
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(file_name));

            document.open();

            Connection connection = ds.getConnection();

           
            String eventQuery = "SELECT * FROM event WHERE Event_id = ?";
            PreparedStatement eventPreparedStatement = connection.prepareStatement(eventQuery);
            eventPreparedStatement.setString(1, eventId);
            ResultSet eventResultSet = eventPreparedStatement.executeQuery();
           // System.out.println("***************FLEA FAIR***************");
            if (eventResultSet.next()) {
            	
            	Paragraph header = new Paragraph("************************Welcome To Fleafair************************");
                Paragraph header1 = new Paragraph("************************EVENT************************");
                
                Paragraph eventInfo = new Paragraph
                		       ("Event ID :"+eventResultSet.getString("Event_id"));
                eventInfo.add("\nEvent Name :"+eventResultSet.getString("Event_name"));
                eventInfo.add("\nEvent Description:"+ eventResultSet.getString("Event_describtion"));
                eventInfo.add("\nEvent Start Date:"+ eventResultSet.getDate("Event_Start_Date"));
                eventInfo.add("\nEvent End Date:"+ eventResultSet.getDate("Event_End_Date"));
                eventInfo.add("\nTotal Volunteers:"+ eventResultSet.getInt("Total_Volunteers"));
             //   eventInfo.add("------------------------------------------------------------");
                document.add(header);
                document.add(header1);
                document.add(eventInfo); 
            }
            
            String venueQuery = "SELECT  v.Venue_id, v.Venue_name, v.Venue_location, v.Venue_capacity, v.Venue_contact_no, er.Event_Registration_date FROM event_regitsration er JOIN VENUE v ON er.Venue_id = v.Venue_id WHERE er.Event_id = ?";
            PreparedStatement venuePreparedStatement = connection.prepareStatement(venueQuery);
            venuePreparedStatement.setString(1, eventId);
            ResultSet venueResultSet = venuePreparedStatement.executeQuery();           

            Paragraph venueDetails = new Paragraph("\n*****************VENUE DETAILS*****************");
            while (venueResultSet.next()) {             
                venueDetails.add("\nVenue ID:"+venueResultSet.getString("Venue_id"));
                venueDetails.add("\nVenue Name:"+venueResultSet.getString("Venue_name"));
                venueDetails.add("\nVenue Location:"+venueResultSet.getString("Venue_location"));
                venueDetails.add("\nVenue Capacity:"+venueResultSet.getInt("Venue_capacity"));
                venueDetails.add("\nVenue Contact Number:"+venueResultSet.getString("Venue_contact_no"));
                venueDetails.add("\nEvent Registration Date:"+venueResultSet.getDate("Event_Registration_date"));
                venueDetails.add("\n------------------------------------------------------------");
            }
            document.add(venueDetails);

            
            String vendorQuery = "SELECT event.Event_id, vendor.Vendor_id, vendor.Vendor_name, vendor.Vendor_firm_name, vendor.Vendor_address, vendor.Vendor_city, vendor.Vendor_state, vendor.Vendor_zipcode, vendor.Vendor_phone_no, vendor.Vendor_license_no, vendor.Vendor_product_category FROM event INNER JOIN event_regitsration ON event.Event_id = event_regitsration.Event_id INNER JOIN event_vendor_registration ON event_regitsration.Event_Registration_id = event_vendor_registration.event_registration_id INNER JOIN vendor ON event_vendor_registration.Vendor_id = vendor.Vendor_id WHERE event.Event_id = ?";
            		        
            PreparedStatement vendorPreparedStatement = connection.prepareStatement(vendorQuery);
            vendorPreparedStatement.setString(1, eventId);
            ResultSet volunteerResultSet = vendorPreparedStatement.executeQuery();

            Paragraph vendorList = new Paragraph("\n*******************LIST OF VENDORS*******************");
         // ...

            while (volunteerResultSet.next()) {
                vendorList.add("\nVendor Id:"+volunteerResultSet.getString("Vendor_id"));
                vendorList.add("\nVendor Name:"+volunteerResultSet.getString("Vendor_name"));
                vendorList.add("\nVendor Firm Name:"+volunteerResultSet.getString("Vendor_firm_name"));
                vendorList.add("\nVendor Address:"+volunteerResultSet.getString("Vendor_address"));
                vendorList.add("\nVendor City:"+volunteerResultSet.getString("Vendor_city"));
                vendorList.add("\nVendor State:"+volunteerResultSet.getString("Vendor_state"));
                vendorList.add("\nVendor Zipcode:" + volunteerResultSet.getString("Vendor_zipcode"));
                vendorList.add("\nVendor Phone Number:"+volunteerResultSet.getString("Vendor_phone_no"));
                vendorList.add("\nVendor License Number:"+volunteerResultSet.getString("Vendor_license_no"));
                vendorList.add("\nVendor Product Category:"+volunteerResultSet.getString("Vendor_product_category"));
                vendorList.add("\n------------------------------------------------------------");
            }

          
            document.add(vendorList);
            
          
            String volunteerQuery = "SELECT * FROM volunteer WHERE Event_id = ?";
            PreparedStatement volunteerPreparedStatement = connection.prepareStatement(volunteerQuery);
            volunteerPreparedStatement.setString(1, eventId);
            ResultSet volunteerResultSet1 = volunteerPreparedStatement.executeQuery();

            Paragraph volunteerList = new Paragraph("\n*******************LIST OF VOLUNTEERS*******************\n");
            while (volunteerResultSet1.next()) {
                volunteerList.add("\nVolunteer ID :"+volunteerResultSet1.getString("Volunteer_id")+"\n");
                volunteerList.add("Volunteer Name :"+volunteerResultSet1.getString("Volunteer_name")+"\n");
                volunteerList.add("Volunteer Email :"+volunteerResultSet1.getString("Volunteer_Email")+"\n");
                volunteerList.add("Volunteer Phone No:"+volunteerResultSet1.getString("Volunteer_Phone_No")+"\n");
                volunteerList.add("Volunteer Address:"+volunteerResultSet1.getString("Volunteer_Address")+"\n");
                volunteerList.add("Volunteer City :"+volunteerResultSet1.getString("Volunteer_City")+"\n");
                volunteerList.add("Volunteer State:"+volunteerResultSet1.getString("Volunteer_state")+"\n");
                volunteerList.add("Volunteer Country:"+volunteerResultSet1.getString("Volunteer_country")+"\n");
                volunteerList.add("Volunteer Zipcode:"+volunteerResultSet1.getString("Volunteer_Zipcode")+"\n");
                volunteerList.add("Volunteer Registration Date:"+volunteerResultSet1.getDate("Volunteer_Registration_Date")+"\n");
                volunteerList.add("------------------------------------------------------------");
            }
            document.add(volunteerList);
            
            String sponsorQuery = "SELECT * FROM sponsorship WHERE Event_id = ?";
            PreparedStatement sponsorPreparedStatement = connection.prepareStatement(sponsorQuery);
            sponsorPreparedStatement.setString(1, eventId);
            ResultSet sponsorResultSet = sponsorPreparedStatement.executeQuery();

            Paragraph sponsorList = new Paragraph("\n*****************LIST OF SPONSORS*****************");
            while (sponsorResultSet.next()) {
                sponsorList.add("\nSponsorship ID:"+sponsorResultSet.getString("Sponsorship_id"));
                sponsorList.add("\nSponsor Name:"+sponsorResultSet.getString("Sponsor_Name"));
                sponsorList.add("\nSponsorship Amount:"+sponsorResultSet.getInt("Sponsorship_Amount"));
                sponsorList.add("\n------------------------------------------------------------");
            }
            document.add(sponsorList);
            String sponsorAmountQuery = "SELECT Event_id, SUM(Sponsorship_Amount) AS Total_Sponsorship_Amount FROM sponsorship WHERE Event_id = ?";
            PreparedStatement sponsorAmountPreparedStatement = connection.prepareStatement(sponsorAmountQuery);
            sponsorAmountPreparedStatement.setString(1, eventId);
            ResultSet sponsorAmountResultSet = sponsorAmountPreparedStatement.executeQuery();
            Paragraph sponsorAmountList = new Paragraph("                                                                 ");
            while (sponsorAmountResultSet.next()) {
                sponsorAmountList.add("\nTotal Sponsorship Amount:" + sponsorAmountResultSet.getInt("Total_Sponsorship_Amount"));
            }
            document.add(sponsorAmountList);

            
            
            String promotionQuery = "SELECT * FROM promotion WHERE Event_id = ?";
            PreparedStatement promotionPreparedStatement = connection.prepareStatement(promotionQuery);
            promotionPreparedStatement.setString(1, eventId);
            ResultSet promotionResultSet = promotionPreparedStatement.executeQuery();

            Paragraph promotionList = new Paragraph("\n*****************LIST OF PROMOTION*****************");
            while (promotionResultSet.next()) {
                promotionList.add("\nPromotion ID:"+promotionResultSet.getString("Promotion_Id"));
                promotionList.add("\nPromotion Name:"+promotionResultSet.getString("Promotion_name"));
                promotionList.add("\nPromotion Start Date:"+promotionResultSet.getDate("Promotion_Start_Date"));
                promotionList.add("\nPromotion End Date:"+promotionResultSet.getDate("Promotion_End_Date"));
                promotionList.add("\nDiscount:"+promotionResultSet.getString("Discount"));
                promotionList.add("\nSpecial Offer:"+promotionResultSet.getString("Special_Offer"));
                promotionList.add("\n------------------------------------------------------------");
            }
            document.add(promotionList);
            String feedbackQuery = "SELECT c.Customer_id, c.Customer_name, c.Customer_address, c.Customer_Zipcode, c.Customer_Phone_no, c.Customer_email, c.Customer_date, f.Feedback_id, f.Rating, f.Comment, f.Review_date FROM CUSTOMER c JOIN feedback f ON c.Customer_id = f.Customer_id WHERE f.Event_id = ?";
            PreparedStatement feedbackPreparedStatement = connection.prepareStatement(feedbackQuery);
            feedbackPreparedStatement.setString(1, eventId);
            ResultSet feedbackResultSet = feedbackPreparedStatement.executeQuery();

            Paragraph feedbackList = new Paragraph("\n*****************LIST OF CUSTOMER FEEDBACK*****************");
            while (feedbackResultSet.next()) {
                feedbackList.add("\nCustomer ID:" +feedbackResultSet.getString("Customer_id"));
                feedbackList.add("\nCustomer Name:" +feedbackResultSet.getString("Customer_name"));
                feedbackList.add("\nCustomer Address:" +feedbackResultSet.getString("Customer_address"));
                feedbackList.add("\nCustomer Zipcode:" + feedbackResultSet.getString("Customer_Zipcode"));
                feedbackList.add("\nCustomer Phone Number:" + feedbackResultSet.getString("Customer_Phone_no"));
                feedbackList.add("\nCustomer Email:" + feedbackResultSet.getString("Customer_email"));
                feedbackList.add("\nCustomer Date:" + feedbackResultSet.getDate("Customer_date"));
                feedbackList.add("\nFeedback ID:" + feedbackResultSet.getString("Feedback_id"));
                feedbackList.add("\nRating:" + feedbackResultSet.getInt("Rating"));
                feedbackList.add("\nComment:" + feedbackResultSet.getString("Comment"));
                feedbackList.add("\nReview Date:" + feedbackResultSet.getDate("Review_date"));
                feedbackList.add("\n------------------------------------------------------------");
            }
            document.add(feedbackList);         
            
            document.close();
            System.out.println("PDF generated successfully!");

            connection.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
}
