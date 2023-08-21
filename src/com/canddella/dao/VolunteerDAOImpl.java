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

import com.canddella.entity.Volunteer;

public class VolunteerDAOImpl implements VolunteerDAO {

	@Override
	public void saveVolunteer(Volunteer volunteer) {
	
		DataSource ds=DBConnectionPool.getDataSource();
		try
			{			
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("insert into volunteer(Volunteer_id, Event_id,  Volunteer_name,  Volunteer_Email, Volunteer_Phone_No, Volunteer_Address,  Volunteer_City, Volunteer_state,"
						+ "Volunteer_country, Volunteer_Zipcode,Volunteer_Registration_Date ) values(?,?,?,?,?,?,?,?,?,?,?)");
				statement.setString(1, volunteer.getVolunteerId());
				statement.setString(2, volunteer.getEvent().getEventId());
				statement.setString(3,volunteer.getVolunteerName());
				statement.setString(4,volunteer.getVolunteerEmail());
				statement.setDouble(5,volunteer.getVolunteerPhoneNo());
				statement.setString(6,volunteer.getVolunteerAddress());
				statement.setString(7, volunteer.getVolunteerCity());
				statement.setString(8,volunteer.getVolunteerState());
				statement.setString(9,volunteer.getVolunteerCountry());
				statement.setInt(10,volunteer.getVolunteerZipcode());
				statement.setDate(11,Date.valueOf(volunteer.getVolunteerRegistrationDate()));
				
				
			
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
	public Volunteer viewVolunteer(String volunteerId) {
		DataSource ds=DBConnectionPool.getDataSource();
		Volunteer volunteer = null;
		try 
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement=connection.prepareStatement("select * from volunteer where Volunteer_id=?");
				statement.setString(1, volunteerId);
				ResultSet resultSet=statement.executeQuery();
					while(resultSet.next())
					{
						System.out.println("***********************************************************************");	
						System.out.println("Volunteer Id                  : -  " + resultSet.getString("Volunteer_id") + "\n"
						                  +"Venue Name                    : -  " + resultSet.getString("Event_id")+ "\n"
						                  +"Volunteer Name                : -  " +resultSet.getString("Volunteer_name") +"\n"
					                      +"Volunteer Email               : -  " +resultSet.getString("Volunteer_Email")+ "\n"
					                      +"Volunteer Phone Number        : -  " +resultSet.getDouble("Volunteer_Phone_No")+ "\n"
					                      +"Volunteer Address             : -  " +resultSet.getString("Volunteer_Address")+ "\n"
					                      +"Volunteer City                : -  " +resultSet.getString("Volunteer_City")+ "\n"
					                      +"Volunteer State               : -  " +resultSet.getString("Volunteer_state")+ "\n"
					                      +"Volunteer Country             : -  " +resultSet.getString("Volunteer_country")+ "\n"
					                	  +"Volunteer Zipcode             : -  " +resultSet.getInt("Volunteer_Zipcode")+ "\n"									  
						                  +"Volunteer Registration Date   : -  " + resultSet.getDate("Volunteer_Registration_Date"));
						System.out.println("***********************************************************************");
							
					}
					connection.close();
		 
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		return volunteer;
	}
	

	@Override
	public Volunteer deleteVolunteer(String volunteerId) {
		
		 DataSource ds=DBConnectionPool.getDataSource();
			Volunteer volunteer = null;
			
				try
					{
						Connection connection = ds.getConnection();
						PreparedStatement statement =connection.prepareStatement("delete from volunteer where Volunteer_id=?");
						statement.setString(1, volunteerId);
						statement.executeUpdate();
						System.out.println(" Venue deleted successfully");
						
					}
				
				catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
		
			return volunteer;
			
			
		}
	

	@Override
	public List<Volunteer> listAllVolunteer() {
		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList <Volunteer> volunteerList = new ArrayList<>();
		
		try
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from volunteer");
				
				ResultSet resultSet=statement.executeQuery();
					 while (resultSet.next()) {
				            String volunteerId = resultSet.getString("Volunteer_id");
				            String eventId = resultSet.getString("Event_id");
				            String volunteerName = resultSet.getString("Volunteer_name");

			                String volunteerEmail = resultSet.getString("Volunteer_Email");
				            Double volunteerPhoneNo = resultSet.getDouble("Volunteer_Phone_No");
			                String volunteerAddress = resultSet.getString("Volunteer_Address");
				            String volunteerCity = resultSet.getString("Volunteer_City");
			                String volunteerState = resultSet.getString("Volunteer_state");
			                
				            String volunteerCountry = resultSet.getString("Volunteer_country");
				            int volunteerZipcode = resultSet.getInt("Volunteer_Zipcode");
				           
				            Date registrationDate = resultSet.getDate("Volunteer_Registration_Date");
				            LocalDate volunteerRegistrationDate = registrationDate.toLocalDate();
				             
				            
				            Event event = new Event();
				            event.setEventId(eventId);
							
				            Volunteer volunteer = new Volunteer(volunteerId ,event ,volunteerName,volunteerEmail ,volunteerPhoneNo, volunteerAddress,volunteerCity,volunteerState,volunteerCountry, volunteerZipcode,volunteerRegistrationDate);
				            volunteerList.add(volunteer);
				   
					 }					
			}
		catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
		return  volunteerList;
	}
	@Override
	public int totalVolunteers(String eventId) {
				    int totalVolunteers=1;
				    DataSource ds = DBConnectionPool.getDataSource();
			
				    try (Connection connection = ds.getConnection();
				    	
				         PreparedStatement statement = connection.prepareStatement("select count(*) from volunteer where Event_id = ?;")) {
			
				        statement.setString(1, eventId);
				        ResultSet resultSet = statement.executeQuery();
				
						        while (resultSet.next()) {
						            totalVolunteers = resultSet.getInt(1);
						      //      connection.close(); 
						        }
		
					    } catch (Exception e) {
					        System.out.println(e.getMessage());
					    }
		
		    return totalVolunteers;
		}

	@Override
			public int TotalVolunteerCapacity(String eventId) {
			    int totalVolunteerCapacity = 0; 
			    Connection connection = null;
			    try {
			        DataSource ds = DBConnectionPool.getDataSource();
			        connection = ds.getConnection(); 
			        System.out.println(eventId);
			        PreparedStatement statement = connection.prepareStatement("SELECT distinct event.Event_id, event.Total_Volunteers as Total_Capacity FROM event  JOIN volunteer ON event.Event_id = volunteer.Event_id WHERE event.Event_id = ?");
			        statement.setString(1, eventId);
			        
			        ResultSet resultSet = statement.executeQuery();
			        
					        if (resultSet.next()) {
					            totalVolunteerCapacity = resultSet.getInt("Total_Capacity");
					        }
			    } catch (Exception e) {
			        e.printStackTrace();
			    } finally {
			        
			    }
	    
	    return totalVolunteerCapacity;
	}
	}


