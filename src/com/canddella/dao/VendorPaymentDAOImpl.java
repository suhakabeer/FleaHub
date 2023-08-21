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
import com.canddella.entity.EventVendorRegistration;
import com.canddella.entity.VendorPayment;


public class VendorPaymentDAOImpl implements VendorPaymentDAO {

	@Override
	public void saveVendorPayment(VendorPayment vendorPayment) {
		DataSource ds=DBConnectionPool.getDataSource();
		try
			{			
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("insert into vendor_payment(Vendor_Payment_Id, event_vendor_registration_id,  Vendor_Payment_Amount, Vendor_Payment_Date, Vendor_Payment_Mode, Vendor_Payment_Status) values(?,?,?,?,?,?)");
				statement.setString(1, vendorPayment.getVendorPaymentId());
				statement.setString(2, vendorPayment.getEventVendorRegistration().getEventVendorRegistrationId());
				statement.setDouble(3, vendorPayment.getVendorPaymentAmount());
				statement.setDate(4, Date.valueOf(vendorPayment.getVendorPaymentDate()));
				statement.setString(5, vendorPayment.getVendorPaymentMode());
				statement.setString(6, vendorPayment.getVendorPaymentStatus());
				
			
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
	public VendorPayment viewVendorPayment(String vendorPaymentId) {
		
		DataSource ds=DBConnectionPool.getDataSource();
		VendorPayment vendorPayment = null;
		try 
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement=connection.prepareStatement("select * from  vendor_payment where Vendor_Payment_Id=?");
				statement.setString(1, vendorPaymentId);
				ResultSet resultSet=statement.executeQuery();
					while(resultSet.next())
					{
						System.out.println("***********************************************************************");	
						System.out.println("Vendor Payment Id             : -  " + resultSet.getString("Vendor_Payment_Id") + "\n"
						                  +"Event Vendor Reservation Id   : -  " + resultSet.getString("event_vendor_registration_id")+ "\n"
						                  +"Vendor Payment Amount         : -  " +resultSet.getDouble("Vendor_Payment_Amount") +"\n"
					                      +"Vendor Payment Date           : -  " +resultSet.getDate("Vendor_Payment_Date")+ "\n"
						                  +"Vendor Payment Mode           : -  " + resultSet.getString("Vendor_Payment_Mode")+ "\n"
						                  +"Vendor Payment Status         : -  " + resultSet.getString("Vendor_Payment_Status"));
						System.out.println("***********************************************************************");
							
					}
					connection.close();
		 
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		return vendorPayment;
	}


	@Override
	public VendorPayment deleteVendorPayment(String vendorPaymentId) {
		
		DataSource ds=DBConnectionPool.getDataSource();
		VendorPayment vendorPayment = null;
		
			try
				{
					Connection connection = ds.getConnection();
					PreparedStatement statement =connection.prepareStatement("delete from vendor_payment where Vendor_Payment_Id=?");
					statement.setString(1, vendorPaymentId);
					statement.executeUpdate();
					System.out.println(" Venue Payment deleted successfully");
					
				}
			
			catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
	
		return vendorPayment;
}

	

	@Override
	public List<VendorPayment> listAllVendorPayment() {
		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList <VendorPayment> vendorPaymentList = new ArrayList<>();
		
		try
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from vendor_payment");
				
				ResultSet resultSet=statement.executeQuery();
					 while (resultSet.next()) {
				            String vendorPaymentId = resultSet.getString("Vendor_Payment_Id");
				            String eventVenueRegistrationId = resultSet.getString("event_vendor_registration_id");
				            Double vendorPaymentAmount = resultSet.getDouble("Vendor_Payment_Amount");
				           
				            Date vendorPaymentDate = resultSet.getDate("Vendor_Payment_Date");
				            LocalDate paymentDate = vendorPaymentDate.toLocalDate();
				            
			                String vendorPaymentMode = resultSet.getString("Vendor_Payment_Mode");
				            String vendorPaymentStatus = resultSet.getString("Vendor_Payment_Status"); 
				            
				            EventVendorRegistration eventVendorRegistration = new EventVendorRegistration();
				    	    eventVendorRegistration.setEventVendorRegistrationId(eventVenueRegistrationId);
							
				            VendorPayment vendorPayment = new VendorPayment(vendorPaymentId, eventVendorRegistration, vendorPaymentAmount, paymentDate,vendorPaymentMode, vendorPaymentStatus);
				            vendorPaymentList.add(vendorPayment);
				   
					 }					
			}
		catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
		return  vendorPaymentList;
	}


	
}
