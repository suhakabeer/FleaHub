package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Vendor;


public class VendorDAOImpl implements VendorDAO {

	@Override
	public void saveVendor(Vendor vendor) {
		
		DataSource ds=DBConnectionPool.getDataSource();
		try
			{			
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("insert into vendor( Vendor_id, Vendor_name, Vendor_firm_name, Vendor_address, Vendor_city, Vendor_state, Vendor_zipcode, Vendor_phone_no, Vendor_license_no, Vendor_product_category) values(?,?,?,?,?,?,?,?,?,?)");
				statement.setString(1,vendor.getVendorId() );
				statement.setString(2, vendor.getVendorName());
				statement.setString(3,vendor.getVendorFirmName());
				statement.setString(4,vendor.getVendorAddress() );
				statement.setString(5, vendor.getVendorCity());
				statement.setString(6,vendor.getVendorState());
				statement.setInt(7, vendor.getVendorZipcode());
				statement.setDouble(8,vendor.getVendorPhoneNo());
				statement.setString(9, vendor.getVendorLicenseNo());
				statement.setString(10,vendor.getVendorProductCategory());
			
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
	public Vendor viewVendor(String vendorId) {
		
		DataSource ds=DBConnectionPool.getDataSource();
		Vendor vendor = null;
		try 
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement=connection.prepareStatement("select * from vendor where Vendor_id=?");
				statement.setString(1, vendorId);
				ResultSet resultSet=statement.executeQuery();
					while(resultSet.next())
					{
					   System.out.println("***********************************************************************");	
					   System.out.println("Vendor Id                    : -   " + resultSet.getString("Vendor_id") + "\n"
						                 +"Vendor Name                  : -   " + resultSet.getString("Vendor_name")+ "\n"
						                 +"Vendor firm name             : -   " +resultSet.getString("Vendor_firm_name") +"\n"
					                     +"Vendor Address               : -   " +resultSet.getString("Vendor_address")+ "\n"
						                 +"Vendor City                  : -   " + resultSet.getString("Vendor_city")+ "\n"
						                 +"Vendor State                 : -   " + resultSet.getString("Vendor_state")+ "\n"
						                 +"Vendor zipcode               : -   " +resultSet.getInt("Vendor_zipcode") +"\n"
					                     +"Vendor Phone Number          : -   " +resultSet.getDouble("Vendor_phone_no")+ "\n"
						                 +"Vendor License Number        : -   " + resultSet.getString("Vendor_license_no")+ "\n"
						                 +"Vendor Product Category      : -   " +resultSet.getString("Vendor_product_category")+ "\n");						               
					  System.out.println("***********************************************************************");
							
					}
					connection.close();
		 
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		return vendor;
	}

	@Override
	public Vendor deleteVendor(String vendorId) {
		
		 DataSource ds=DBConnectionPool.getDataSource();
			Vendor vendor = null;
			
				try
					{
						Connection connection = ds.getConnection();
						PreparedStatement statement =connection.prepareStatement("delete from vendor where Vendor_id=?");
						statement.setString(1, vendorId);
						statement.executeUpdate();
						System.out.println(" Vendor deleted successfully");
						
					}
				
				catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
		
			return vendor;
			
	}

	@Override
	public List<Vendor> listAllVendor() {
		
		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList <Vendor> vendorList = new ArrayList<>();
		
		try
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from vendor");
				
				ResultSet resultSet=statement.executeQuery();
					 while (resultSet.next()) {
				            
				            
				             String vendorId = resultSet.getString("Vendor_id");
							 String vendorName =  resultSet.getString("Vendor_name");
							 String vendorFirmName = resultSet.getString("Vendor_firm_name");
							 String vendorAddress = resultSet.getString("Vendor_address");
							 String vendorCity = resultSet.getString("Vendor_city");
							 String vendorState =resultSet.getString("Vendor_state") ;
							 int vendorZipcode = resultSet.getInt("Vendor_zipcode");
							 double vendorPhoneNo = resultSet.getDouble("Vendor_phone_no");
							 String vendorLicenseNo = resultSet.getString("Vendor_license_no");
							 String vendorProductCategory = resultSet.getString("Vendor_product_category");
				            
							 
				            Vendor vendor = new Vendor(vendorId ,vendorName,vendorFirmName,vendorAddress,vendorCity,vendorState,vendorZipcode,vendorPhoneNo,vendorLicenseNo,vendorProductCategory);
				            vendorList.add(vendor);
				          
				        }
					     
					
			}
		catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
		return vendorList;
	}

	@Override
	public Vendor getVendor(String VendorId) {
		
		Vendor vendor1 = null;
		DataSource ds=DBConnectionPool.getDataSource();
		
			   try
					{
						Connection connection = ds.getConnection();
						PreparedStatement statement = connection.prepareStatement("select * from vendor where Vendor_id = ?");
						statement.setString(1, VendorId);
						ResultSet resultSet=statement.executeQuery();
							 while (resultSet.next()) {
								 
					             String vendorId = resultSet.getString("Vendor_id");
								 String vendorName =  resultSet.getString("Vendor_name");
								 String vendorFirmName = resultSet.getString("Vendor_firm_name");
								 String vendorAddress = resultSet.getString("Vendor_address");
								 String vendorCity = resultSet.getString("Vendor_city");
								 String vendorState =resultSet.getString("Vendor_state") ;
								 int vendorZipcode = resultSet.getInt("Vendor_zipcode");
								 double vendorPhoneNo = resultSet.getDouble("Vendor_phone_no");
								 String vendorLicenseNo = resultSet.getString("Vendor_license_no");
								 String vendorProductCategory = resultSet.getString("Vendor_product_category");
						           vendor1 = new Vendor(vendorId ,vendorName,vendorFirmName,vendorAddress,vendorCity,vendorState,vendorZipcode,vendorPhoneNo,vendorLicenseNo,vendorProductCategory);
						            			          
						        }								     
							
					}
				catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
		return vendor1;
	}


	@Override
	public void updateVendor(String VendorId, String vendorStore, String vendorName) {
		
		DataSource ds=DBConnectionPool.getDataSource();
		
		   try
				{
					Connection connection = ds.getConnection();
					PreparedStatement statement = connection.prepareStatement("update vendor set " + vendorStore + " = ? where Vendor_id = ? ");
					statement.setString(1, vendorName);
					statement.setString(2, VendorId);
					statement.executeUpdate();
						
				}
			catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
	}

}
