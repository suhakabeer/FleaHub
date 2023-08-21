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
import com.canddella.entity.Venue;
import com.canddella.entity.VenuePayment;

public class VenuePaymentDAOImpl implements VenuePaymentDAO {

	@Override
	public void saveVenuePayment(VenuePayment venuePayment) {
		
		DataSource ds=DBConnectionPool.getDataSource();
		try
			{			
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("insert into Venue_Payment(Venue_Payment_id, Venue_id,  Venue_Payment_Amount,   Venue_Payment_date, Venue_payment_mode, Vendor_Payement_status) values(?,?,?,?,?,?)");
				statement.setString(1, venuePayment.getVenuePaymentId());
				statement.setString(2,venuePayment.getVenue().getVenueId());
				statement.setDouble(3, venuePayment.getVenuePaymentAmount());
				statement.setDate(4, Date.valueOf(venuePayment.getVenuePaymentDate()));
				statement.setString(5, venuePayment.getVenuePaymentMode());
				statement.setString(6, venuePayment.getVenuePaymentStatus());
				
			
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
	public VenuePayment viewVenuePayment(String venuePaymentId) {
		
		DataSource ds=DBConnectionPool.getDataSource();
		VenuePayment venuePayment = null;
		try 
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement=connection.prepareStatement("select * from  Venue_Payment where Venue_Payment_id=?");
				statement.setString(1, venuePaymentId);
				ResultSet resultSet=statement.executeQuery();
					while(resultSet.next())
					{
						System.out.println("***********************************************************************");	
						System.out.println("Venue Payment Id          : -  " + resultSet.getString("Venue_Payment_id") + "\n"
						                  +"Venue Id                  : -  " + resultSet.getString("Venue_id")+ "\n"
						                  +"Venue Payment Amount      : -  " +resultSet.getDouble("Venue_Payment_Amount") +"\n"
					                      +"Venue Payment Date        : -  " +resultSet.getDate("Venue_Payment_date")+ "\n"
						                  +"Venue Payment Mode        : -  " + resultSet.getString("Venue_payment_mode")+ "\n"
						                  +"Venue Payment Status      : -  " + resultSet.getString("Vendor_Payement_status"));
						System.out.println("***********************************************************************");
							
					}
					connection.close();
		 
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		return venuePayment;
	}

	@Override
	public VenuePayment deleteVenuePaymen(String venuePaymentId) {
		
		 DataSource ds=DBConnectionPool.getDataSource();
			VenuePayment venuePayment = null;
			
				try
					{
						Connection connection = ds.getConnection();
						PreparedStatement statement =connection.prepareStatement("delete from Venue_Payment where Venue_Payment_id=?");
						statement.setString(1, venuePaymentId);
						statement.executeUpdate();
						System.out.println(" Venue Payment deleted successfully");
						
					}
				
				catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
		
			return venuePayment;
	}

	
	@Override
	public List<VenuePayment> listAllVenuePayment() {
		
		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList <VenuePayment> venuePaymentList = new ArrayList<>();
		
		try
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from Venue_Payment");
				
				ResultSet resultSet=statement.executeQuery();
					 while (resultSet.next()) {
				            String venuePaymentId = resultSet.getString("Venue_Payment_id");
				            String venueId = resultSet.getString("Venue_id");
				            Double venuePaymentAmount = resultSet.getDouble("Venue_Payment_Amount");
				           
				            Date venuePaymentDate = resultSet.getDate("Venue_Payment_date");
				            LocalDate paymentDate = venuePaymentDate.toLocalDate();
				            
			                String venuePaymentMode = resultSet.getString("Venue_payment_mode");
				            String venuePaymentStatus = resultSet.getString("Vendor_Payement_status"); 
				            
				            Venue venue = new Venue();
							venue.setVenueId(venueId);
							
				            VenuePayment venuePayment = new VenuePayment(venuePaymentId ,venue ,venuePaymentAmount,paymentDate ,venuePaymentMode, venuePaymentStatus);
				            venuePaymentList.add(venuePayment);
				   
					 }					
			}
		catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
		return  venuePaymentList;
	}

}
