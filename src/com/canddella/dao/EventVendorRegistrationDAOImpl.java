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
import com.canddella.entity.EventRegistration;
import com.canddella.entity.EventVendorRegistration;
import com.canddella.entity.Vendor;

public class EventVendorRegistrationDAOImpl implements EventVendorRegistrationDAO {

	@Override
	public void saveEventVendorRegistration(EventVendorRegistration eventVendorRegistration) {
		DataSource ds=DBConnectionPool.getDataSource();
		try
			{			
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("insert into event_vendor_registration(event_vendor_registration_id, Vendor_id,  event_registration_id, event_vendor_registration_date, number_of_tables ) values(?,?,?,?,?)");
				statement.setString(1, eventVendorRegistration.getEventVendorRegistrationId() );				
				statement.setString(2,eventVendorRegistration.getVendor().getVendorId());
				statement.setString(3,eventVendorRegistration.getEventRegistration().getEventRegistrationId());
				statement.setDate(4,Date.valueOf(eventVendorRegistration.getEventVendorRegistrationDate()));
				statement.setInt(5, eventVendorRegistration.getNumberOfTables());
				
				
							
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
	public EventVendorRegistration viewEventVendorRegistration(String eventVendorRegistrationId) {
		EventVendorRegistration eventVendorRegistration = null;
		DataSource ds=DBConnectionPool.getDataSource();
		
		try 
		{
			Connection connection = ds.getConnection();			
			PreparedStatement statement = connection.prepareStatement("select * from event_vendor_registration where event_vendor_registration_id = ?");
            statement.setString(1, eventVendorRegistrationId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
            	System.out.println("*********************************************************************************");	
            	System.out.println("  Event Vendor Registration Id    :- "  + resultSet.getString("event_vendor_registration_id") +"\n" +           	                  
            			           "                     Vendor Id    :- "  + resultSet.getString("Vendor_id")             +"\n" + 
            			           "         Event Registration Id    :- "  + resultSet.getString("event_registration_id")              +"\n" +
            	                   "Event Vendor Registration_date    :- "  + resultSet.getDate("event_vendor_registration_date") +"\n" +
            			           "              Number of tables    :- "  + resultSet.getInt("number_of_tables"));            	                
            	System.out.println("*********************************************************************************");	
            
            
            }
		connection.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return eventVendorRegistration;
	}

	@Override
			public EventVendorRegistration deleteEventVendorRegistration(String eventVendorRegistrationId) {
				
				EventVendorRegistration eventVendorRegistration1 = null;
				DataSource ds=DBConnectionPool.getDataSource();
				try {
				Connection connection = ds.getConnection();	
				PreparedStatement statement = connection.prepareStatement("delete from event_vendor_registration where event_vendor_registration_id = ?");
				statement.setString(1, eventVendorRegistrationId);
				statement.executeUpdate();
				System.out.println("Deleted Successfully");
				
				
				}
				
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				return eventVendorRegistration1;
	}


	@Override
		public List<EventVendorRegistration> viewAllEventVendorRegistration() {
			
			DataSource ds=DBConnectionPool.getDataSource();
			ArrayList<EventVendorRegistration> eventVendorRegistrationList = new ArrayList();	
			try
				{
					Connection connection = ds.getConnection();	
					PreparedStatement statement = connection.prepareStatement("select * from event_vendor_registration");
					ResultSet resultSet = statement.executeQuery();
					while(resultSet.next())
								{
							
							String eventVendorRegistrationId = resultSet.getString("event_vendor_registration_id");
							
										
							String vendorId = resultSet.getString("Vendor_id");				
							String eventRegistrationId = resultSet.getString("Event_Registration_id");	
							Date eventRegistrationDate = resultSet.getDate("event_vendor_registration_date");
							LocalDate registrationDate = eventRegistrationDate.toLocalDate();
							int numberOfTables = resultSet.getInt("number_of_tables");
							
							EventRegistration eventRegistration = new EventRegistration();
							eventRegistration.setEventRegistrationId(eventRegistrationId);
							
							Vendor vendor = new Vendor();
							vendor.setVendorId(vendorId);
							
							EventVendorRegistration eventVendorRegistration = new EventVendorRegistration(eventVendorRegistrationId,vendor,eventRegistration,registrationDate,numberOfTables);
							eventVendorRegistrationList.add(eventVendorRegistration);
								}
				   }
				catch (Exception e)
					{
						System.out.println(e.getMessage());
					}
			
			return eventVendorRegistrationList;
		}
	@Override
	public int totalNumberOfTables(String eventRegistrationId) {
				    int totalTables=0;
				    DataSource ds = DBConnectionPool.getDataSource();
			
				    try (Connection connection = ds.getConnection();
				    	
				         PreparedStatement statement = connection.prepareStatement("select sum(number_of_tables) as total_tables from event_vendor_registration where event_registration_id = ?;")) {
			
				        statement.setString(1, eventRegistrationId);
				        ResultSet resultSet = statement.executeQuery();
				
						        while (resultSet.next()) {
						            totalTables = resultSet.getInt("total_tables");
						      //      connection.close(); 
						        }
		
					    } catch (Exception e) {
					        System.out.println(e.getMessage());
					    }
		
		    return totalTables;
		}

	@Override
			public int TotalCapacity(String eventRegistrationId) {
			    int totalCapacity = 0; 
			    Connection connection = null;
			    try {
			        DataSource ds = DBConnectionPool.getDataSource();
			        connection = ds.getConnection(); 
			        //System.out.println(eventRegistrationId);
			        PreparedStatement statement = connection.prepareStatement("SELECT venue.Venue_capacity FROM event_regitsration event_regitsration JOIN venue ON event_regitsration.Venue_id = venue.Venue_id WHERE event_regitsration.Event_Registration_id = ?");
			        statement.setString(1, eventRegistrationId);
			        
			        ResultSet resultSet = statement.executeQuery();
			        
					        if (resultSet.next()) {
					            totalCapacity = resultSet.getInt("Venue_capacity");
					        }
			    } catch (Exception e) {
			        e.printStackTrace();
			    } finally {
			        
			    }
	    
	    return totalCapacity;
	}
		
//
//	@Override
//	public int TotalCapacity(String eventRegistrationId) {
//	    int totalCapacity = 0; 
//	    Connection connection = null;
//	    try {
//	        DataSource ds = DBConnectionPool.getDataSource();
//	        connection = ds.getConnection(); 
//	        System.out.println(eventRegistrationId);
//	    	PreparedStatement statement = connection.prepareStatement("SELECT  event_regitsration.Event_Registration_id, venue.Venue_capacity  FROM event_regitsration  event_regitsration JOIN venue  ON  event_regitsration.Venue_id = venue.Venue_id WHERE  event_regitsration.Event_Registration_id = ?;");
//	    //    PreparedStatement statement = connection.prepareStatement("select distinct Venue_capacity as total_capacity from  event_vendor_registration join event_regitsration on event_vendor_registration.event_registration_id=event_regitsration.Event_Registration_id  join venue on event_regitsration.Venue_id=venue.Venue_id where event_vendor_registration.event_registration_id=?"); 
//	      
//	        statement.setString(1, eventRegistrationId);
//	        
//	        
//	        ResultSet resultSet = statement.executeQuery();
//	        
//			        while (resultSet.next()) {
//			         
//			        	totalCapacity = resultSet.getInt(1);
//			        
//			        	
//			        }
//			        
//			        
//	    }
//	     catch (Exception e) {
//	        System.out.println(e.getMessage());
//	    }
//	    finally
//	    {
//	    	// connection.close(); 
//	    }
//	     
//		return totalCapacity;
//	}

}
