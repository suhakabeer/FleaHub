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

import com.canddella.entity.Sponsorship;

public class SponsorshipDAOImpl implements SponsorshipDAO {

	@Override
	public void saveSponsorship(Sponsorship sponsorship) {
		
		DataSource ds=DBConnectionPool.getDataSource();
		try
			{			
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("insert into sponsorship(Sponsorship_id, Event_id,  Sponsor_Name, Sponsorship_Amount) values(?,?,?,?)");
				statement.setString(1, sponsorship.getSponsorshipId());
				statement.setString(2, sponsorship.getEvent().getEventId());
				statement.setString(3, sponsorship.getSponsorName());
				statement.setDouble(4, sponsorship.getSponsorshipAmount());	
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
	public Sponsorship viewSponsorship(String sponsorshipId) {
		DataSource ds=DBConnectionPool.getDataSource();
		Sponsorship sponsorship = null;
		try 
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement=connection.prepareStatement("select * from sponsorship where Sponsorship_id=?");
				statement.setString(1, sponsorshipId);
				ResultSet resultSet=statement.executeQuery();
					while(resultSet.next())
					{
						System.out.println("***********************************************************************");	
						System.out.println("Sponsorship Id         : - " + resultSet.getString("Sponsorship_id") + "\n"
						                 + "Event Id               : - " + resultSet.getString("Event_id")+ "\n"
						                 + "Sponsor Name           : - " +resultSet.getString("Sponsor_Name") +"\n"
						                 + "Sponsorship Amount     : - " + resultSet.getDouble("Sponsorship_Amount"));
						System.out.println("***********************************************************************");
							
					}
					connection.close();
		 
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		return sponsorship;
	}

	@Override
	public Sponsorship deleteSponsorship(String sponsorshipId) {
		DataSource ds=DBConnectionPool.getDataSource();
		Sponsorship sponsorship = null;
		
			try
				{
					Connection connection = ds.getConnection();
					PreparedStatement statement =connection.prepareStatement("delete from sponsorship where Sponsorship_id=?");
					statement.setString(1, sponsorshipId);
					statement.executeUpdate();
					System.out.println("Sponsorship details deleted successfully");
					
				}
			
			catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
	
		return sponsorship;
	}

	@Override
	public List<Sponsorship> ListAllSponsorship() {
		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList <Sponsorship> sponsorshipList = new ArrayList<>();
		
		try
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from sponsorship");
				
				ResultSet resultSet=statement.executeQuery();
					 while (resultSet.next()) {
				            String sponsorshipId = resultSet.getString("Sponsorship_id");
				            String eventId = resultSet.getString("Event_id");
				            String sponsorName = resultSet.getString("Sponsor_Name");
				            double sponsorshipAmount = resultSet.getDouble("Sponsorship_Amount");
				          			            
				            Event event = new Event();
				            event.setEventId(eventId);
				            Sponsorship sponsorship = new Sponsorship(sponsorshipId, event,sponsorName,sponsorshipAmount);
				            sponsorshipList.add(sponsorship);
				          
				        }
					     
					
			}
		catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
		return sponsorshipList;
		}

	}

