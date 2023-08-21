package com.canddella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Customer;
import com.canddella.entity.Event;
import com.canddella.entity.Feedback;

public class FeedbackDAOImpl implements FeedbackDAO {

	@Override
	public void saveFeedback(Feedback feedback) {
		
		DataSource ds=DBConnectionPool.getDataSource();
		try
			{			
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("insert into feedback(Feedback_id,  Customer_id,  Event_id,  Rating, Comment, Review_date) values(?,?,?,?,?,?)");
				statement.setString(1, feedback.getFeedbackId());
				statement.setString(2, feedback.getCustomer().getCustomerId());
				statement.setString(3,feedback.getEvent().getEventId());
				statement.setDouble(4,feedback.getRating());
				statement.setString(5, feedback.getComment());
				statement.setDate(6, Date.valueOf(feedback.getReviewDate()));	
				int count=0;
				count=statement.executeUpdate();
				if(count>0)
					{
						System.out.println("Updated Successfully");
					}
				connection.close();
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}	
	}
	

	@Override
	public Feedback viewFeedback(String feedbackId) {
		DataSource ds=DBConnectionPool.getDataSource();
		Feedback feedback = null;
		try 
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement=connection.prepareStatement("select * from  feedback where Feedback_id=?");
				statement.setString(1, feedbackId);
				ResultSet resultSet=statement.executeQuery();
					while(resultSet.next())
					{
						System.out.println("***********************************************************************");	
					   System.out.println("Feedback Id     : - " + resultSet.getString("Feedback_id") + "\n"
						                 +"Customer Id     : - " + resultSet.getString("Customer_id")+ "\n"
						                 +"Event Id        : - " +resultSet.getString("Event_id") +"\n"
					                     +"Rating          :-  " + resultSet.getDouble("Rating") + "\n"
					                     +"Comment         :-  " + resultSet.getString("Comment") + "\n"
						                 +"Review Date     :-  " + resultSet.getDate("Review_date"));
						System.out.println("***********************************************************************");
							
					}
					connection.close();
		 
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		return feedback;
	}
	

	@Override
	public Feedback deleteFeedback(String feedbackId) {
		
		 DataSource ds=DBConnectionPool.getDataSource();
			Feedback feedback = null;
			
				try
					{
						Connection connection = ds.getConnection();
						PreparedStatement statement =connection.prepareStatement("delete from  feedback where Feedback_id=?");
						statement.setString(1, feedbackId);
						statement.executeUpdate();
						System.out.println(" Event deleted successfully");
						
					}
				
				catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
		
			return feedback;
			
			
		}
	

	@Override
	public List<Feedback> ListAllFeedback() {
		
		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList <Feedback> feedbackList = new ArrayList<>();
		
		try
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from  feedback");
				
				ResultSet resultSet=statement.executeQuery();
					 while (resultSet.next()) {
				            String feedbackId = resultSet.getString("Feedback_id");
				            String customerId = resultSet.getString("Customer_id");
				            String eventId = resultSet.getString("Event_id"); 
				            double rating = resultSet.getDouble("Rating");
				            String comment = resultSet.getString("Comment"); 
				           
				            Date reviewDate = resultSet.getDate("Review_date");
				            LocalDate reviewdate = reviewDate.toLocalDate();

				            Event event = new Event();
							event.setEventId(eventId);
							
							Customer customer = new Customer();
							customer.setCustomerId(customerId);
							
							Feedback feedback = new Feedback(feedbackId , customer, event, rating, comment, reviewdate);
				            feedbackList.add(feedback);
				          
				        }
					     
					
			}
		catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
		return feedbackList;
		}

	}


