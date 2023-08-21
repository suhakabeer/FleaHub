package com.canddella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;

import com.canddella.entity.Venue;

public class VenueDAOImpl implements VenueDAO {
	

@Override
			public void saveVenue(Venue venue) {
				DataSource ds=DBConnectionPool.getDataSource();
				try
					{			
						Connection connection = ds.getConnection();
						PreparedStatement statement = connection.prepareStatement("insert into venue( Venue_id, Venue_name,  Venue_location,  Venue_capacity, Venue_contact_no ) values(?,?,?,?,?)");
						statement.setString(1, venue.getVenueId());
						statement.setString(2, venue.getVenueName());
						statement.setString(3,venue.getVenueLocation());
						statement.setInt(4, venue.getVenueCapacity());
						statement.setDouble(5,venue.getVenueContactNo());
						
					
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
			public Venue viewVenue(String venueId) {
				DataSource ds=DBConnectionPool.getDataSource();
				Venue venue = null;
				try 
					{
						Connection connection = ds.getConnection();
						PreparedStatement statement=connection.prepareStatement("select * from venue where Venue_id=?");
						statement.setString(1, venueId);
						ResultSet resultSet=statement.executeQuery();
							while(resultSet.next())
							{
								System.out.println("***********************************************************************");	
								System.out.println("Venue Id              : -  " + resultSet.getString("Venue_id") + "\n"
								                  +"Venue Name            : -  " + resultSet.getString("Venue_name")+ "\n"
								                  +"Venue Location        : -  " +resultSet.getString("Venue_location") +"\n"
							                      +"Venue Capacity        : -  " +resultSet.getInt("Venue_capacity")+ "\n"
								                  +"Venue Contact Number  : -  " + resultSet.getDouble("Venue_contact_no"));
								System.out.println("***********************************************************************");
									
							}
							connection.close();
				 
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
				return venue;
			}



@Override
			public Venue deleteVenue(String venueId) {
			    DataSource ds=DBConnectionPool.getDataSource();
				Venue venue = null;
				
					try
						{
							Connection connection = ds.getConnection();
							PreparedStatement statement =connection.prepareStatement("delete from venue where Venue_id=?");
							statement.setString(1, venueId);
							statement.executeUpdate();
							System.out.println(" Venue deleted successfully");
							
						}
					
					catch(Exception e)
						{
							System.out.println(e.getMessage());
						}
			
				return venue;
				
				
			}



@Override
		public List<Venue> listAllVenue() {
			DataSource ds=DBConnectionPool.getDataSource();
			ArrayList <Venue> venueList = new ArrayList<>();
			
			try
				{
					Connection connection = ds.getConnection();
					PreparedStatement statement = connection.prepareStatement("select * from venue");
					
					ResultSet resultSet=statement.executeQuery();
						 while (resultSet.next()) {
					            String venueId = resultSet.getString("Venue_id");
					            String venueName = resultSet.getString("Venue_name");
					            String venueLocation = resultSet.getString("Venue_location"); 
					            int venueCapacity = resultSet.getInt("Venue_capacity");
					            double venueContactNo = resultSet.getDouble("Venue_contact_no");
					            Venue venue = new Venue(venueId, venueName, venueLocation, venueCapacity, venueContactNo);
					            venueList.add(venue);
					          
					        }
						     
						
				}
			catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			
			return venueList;
			}



@Override
			public Venue getVenue(String VenueId) {
				Venue venue1 = null;
				DataSource ds=DBConnectionPool.getDataSource();
				
					   try
							{
								Connection connection = ds.getConnection();
								PreparedStatement statement = connection.prepareStatement("select * from venue where Venue_id = ?");
								statement.setString(1, VenueId);
								ResultSet resultSet=statement.executeQuery();
									 while (resultSet.next()) {
								            String venueId = resultSet.getString("Venue_id");
								            String venueName = resultSet.getString("Venue_name");
								            String venueLocation = resultSet.getString("Venue_location"); 
								            int venueCapacity = resultSet.getInt("Venue_capacity");
								            double venueContactNo = resultSet.getDouble("Venue_contact_no");
								           venue1 = new Venue(venueId, venueName, venueLocation, venueCapacity, venueContactNo);
								            			          
								        }								     
									
							}
						catch(Exception e)
							{
								System.out.println(e.getMessage());
							}
				return venue1;
			}



@Override
public void updateVenue(String VenueId, String venueStore, String venueName) {
	
	//Venue venue = null;
	DataSource ds=DBConnectionPool.getDataSource();
	
		   try
				{
					Connection connection = ds.getConnection();
					PreparedStatement statement = connection.prepareStatement("update venue set " + venueStore + " = ? where Venue_id = ? ");
					statement.setString(1, venueName);
					statement.setString(2, VenueId);
					statement.executeUpdate();
														     
						
				}
			catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
}

 
}

