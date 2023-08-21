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
import com.canddella.entity.Venue;


public class EventDAOImpl implements EventDAO {

	@Override
	public void saveEvent(Event event) {
		DataSource ds=DBConnectionPool.getDataSource();
		try
			{			
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("insert into event( Event_id, Event_name,  Event_describtion,  Event_Start_Date, Event_End_Date,Total_Volunteers) values(?,?,?,?,?,?)");
				statement.setString(1, event.getEventId());
				statement.setString(2, event.getEventName());
				statement.setString(3,event.getEventDescribtion());
				statement.setDate(4,Date.valueOf(event.getEventStartDate()));
				statement.setDate(5,Date.valueOf(event.getEventEndDate()));
				statement.setInt(6, event.getTotalVolunteer());
				
							
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
	public Event viewEvent(String eventId) {
		DataSource ds=DBConnectionPool.getDataSource();
		Event event = null;
		try 
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement=connection.prepareStatement("select * from event where Event_id=?");
				statement.setString(1, eventId);
				ResultSet resultSet=statement.executeQuery();
					while(resultSet.next())
					{
						System.out.println("***********************************************************************");	
						System.out.println("Event Id           : - " + resultSet.getString("Event_id") + "\n"
						                 + "Event Name         : - " + resultSet.getString("Event_name")+ "\n"
						                 + "Event Description  : - " +resultSet.getString("Event_describtion") +"\n"
					                     + "Event Start Date   : - " + resultSet.getDate("Event_Start_Date") + "\n"
						                 + "Event End Date     : - " + resultSet.getDate("Event_End_Date") + "\n"
						                 + "Total Volunteers   :-  " + resultSet.getInt("Total_Volunteers"));
						System.out.println("***********************************************************************");
							
					}
					connection.close();
		 
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		return event;
	}

	@Override
	public Event deleteEvent(String eventId) {
		
		 DataSource ds=DBConnectionPool.getDataSource();
			Event event = null;
			
				try
					{
						Connection connection = ds.getConnection();
						PreparedStatement statement =connection.prepareStatement("delete from event where Event_id=?");
						statement.setString(1, eventId);
						statement.executeUpdate();
						System.out.println(" Event deleted successfully");
						
					}
				
				catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
		
			return event;
			
			
		}

	@Override
	public List<Event> listAllEvent() {
		
		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList <Event> eventList = new ArrayList<>();
		
		try
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from event");
				
				ResultSet resultSet=statement.executeQuery();
					 while (resultSet.next()) {
				            String eventId = resultSet.getString("Event_id");
				            String eventName = resultSet.getString("Event_name");
				            String eventDescription = resultSet.getString("Event_describtion"); 
				            
				           
				            Date startDate = resultSet.getDate("Event_Start_Date");
				            LocalDate eventStartDate = startDate.toLocalDate();

				            Date endDate = resultSet.getDate("Event_End_Date");
				            LocalDate eventEndDate = endDate.toLocalDate();
				            
				            int totalVolunteers = resultSet.getInt("Total_Volunteers"); 
				            Event event = new Event(eventId, eventName,eventDescription,eventStartDate,eventEndDate,totalVolunteers);
				            eventList.add(event);
				          
				        }
					     
					
			}
		catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
		return eventList;
		}



	@Override
	public Event getEvent(String EventId) {
		
		Event event1 = null;
		DataSource ds=DBConnectionPool.getDataSource();
		
			   try
					{
						Connection connection = ds.getConnection();
						PreparedStatement statement = connection.prepareStatement("select * from event where Event_id = ?");
						statement.setString(1, EventId);
						ResultSet resultSet=statement.executeQuery();
							 while (resultSet.next()) {
						            String eventId = resultSet.getString("Event_id");
						            String eventName = resultSet.getString("Event_name");
						            String eventDescription = resultSet.getString("Event_describtion"); 
						            Date startDate = resultSet.getDate("Event_Start_Date");
						            LocalDate eventStartDate = startDate.toLocalDate();

						            Date endDate = resultSet.getDate("Event_End_Date");
						            LocalDate eventEndDate = endDate.toLocalDate();
						            int totalVolunteers = resultSet.getInt("Total_Volunteers");
						            event1 = new Event(eventId, eventName,eventDescription,eventStartDate,eventEndDate,totalVolunteers);
						            			          
						        }								     
							
					}
				catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
		return event1;
	}


	@Override
	public void updateEvent(String EventId, String eventStore, String eventName) {
		DataSource ds=DBConnectionPool.getDataSource();
		
		   try
				{
					Connection connection = ds.getConnection();
					PreparedStatement statement = connection.prepareStatement("update event set " + eventStore + " = ? where Event_id = ? ");
					statement.setString(1, eventName);
					statement.setString(2, EventId);
					statement.executeUpdate();
														     
						
				}
			catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
}


	

	

}
