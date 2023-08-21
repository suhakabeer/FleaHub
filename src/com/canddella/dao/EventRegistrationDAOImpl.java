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
import com.canddella.entity.Event;
import com.canddella.entity.EventRegistration;
import com.canddella.entity.Venue;

public class EventRegistrationDAOImpl implements EventRegistrationDAO {

	@Override
	public void saveEventRegistration(EventRegistration eventRegistration) {
		DataSource ds=DBConnectionPool.getDataSource();
		try
			{			
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("insert into  event_regitsration(Event_Registration_id, Venue_id,  Event_id, Event_Registration_date) values(?,?,?,?)");
				statement.setString(1, eventRegistration.getEventRegistrationId() );
				statement.setString(2,eventRegistration.getVenue().getVenueId());
				statement.setString(3,eventRegistration.getEvent().getEventId());
				statement.setDate(4,Date.valueOf(eventRegistration.getEventRegistrationDate()));
				
							
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
	public EventRegistration viewEventRegistration(String eventRegistrationId) {
		
		EventRegistration eventRegistration = null;
		DataSource ds=DBConnectionPool.getDataSource();
		
		try 
		{
			Connection connection = ds.getConnection();			
			PreparedStatement statement = connection.prepareStatement("select * from event_regitsration where Event_Registration_id = ?");
            statement.setString(1, eventRegistrationId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
            	System.out.println("*********************************************************************************");	
            	System.out.println("  Event Registration Id    :- "  + resultSet.getString("Event_Registration_id") +"\n" +
            	                   "               Venue Id    :- "  + resultSet.getString("Venue_id")              +"\n" +
            			           "               Event Id    :- "  + resultSet.getString("Event_id")             +"\n" +  
            	                   "Event_Registration_date    :- "  + resultSet.getDate("Event_Registration_date"));	
            	System.out.println("*********************************************************************************");	
            
            
            }
		connection.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return eventRegistration;
	}

	@Override
	public EventRegistration deleteEventRegistration(String eventRegistrationId) {
		EventRegistration eventRegistration1 = null;
		DataSource ds=DBConnectionPool.getDataSource();
		try {
		Connection connection = ds.getConnection();	
		PreparedStatement statement = connection.prepareStatement("delete from event_regitsration where  Event_Registration_id = ?");
		statement.setString(1, eventRegistrationId);
		statement.executeUpdate();
		System.out.println("Deleted Successfully");
		
		connection.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return eventRegistration1;
	}

	@Override
	public List<EventRegistration> viewAllEventRegistration() {
		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList<EventRegistration> eventRegistrationList = new ArrayList();	
		try
		{
			Connection connection = ds.getConnection();	
			PreparedStatement statement = connection.prepareStatement("select * from event_regitsration");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
					{
				
				String eventRegistrationId = resultSet.getString("Event_Registration_id");
				String venueId = resultSet.getString("Venue_id");		
				String eventId = resultSet.getString("Event_id");				
					
		
				Date eventRegistrationDate = resultSet.getDate("Event_Registration_date");
				LocalDate registrationDate = eventRegistrationDate.toLocalDate();
				
				Venue venue = new Venue();
				venue.setVenueId(venueId);
				
				Event event = new Event();
				event.setEventId(eventId);
				
				
				
				EventRegistration eventRegistration = new EventRegistration(eventRegistrationId,venue,event,registrationDate);
				eventRegistrationList.add(eventRegistration);
					}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return eventRegistrationList;
	}



	
	
}
