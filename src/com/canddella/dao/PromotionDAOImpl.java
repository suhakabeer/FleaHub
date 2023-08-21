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
import com.canddella.entity.Promotion;

public class PromotionDAOImpl implements PromotionDAO {

	@Override
	public void savePromotion(Promotion promotion) {
		
		DataSource ds=DBConnectionPool.getDataSource();
		try
			{			
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("insert into promotion(Promotion_Id, Event_id,  Promotion_name, Promotion_Start_Date, Promotion_End_Date,Discount,Special_Offer) values(?,?,?,?,?,?,?)");
				statement.setString(1, promotion.getPromotionId());
				statement.setString(2, promotion.getEvent().getEventId());
				statement.setString(3, promotion.getPromotionName());
				statement.setDate(4, Date.valueOf(promotion.getPromotionStratDate()));
				statement.setDate(5, Date.valueOf(promotion.getPromotionEndDate()));
				statement.setString(6, promotion.getDiscount());
				statement.setString(7, promotion.getSpecialOffer());
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
	public Promotion viewPromotion(String promotionId) {
		DataSource ds=DBConnectionPool.getDataSource();
		Promotion promotion = null;
		try 
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement=connection.prepareStatement("select * from promotion where Promotion_Id=?");
				statement.setString(1, promotionId);
				ResultSet resultSet=statement.executeQuery();
					while(resultSet.next())
					{
						System.out.println("***********************************************************************");	
						System.out.println("Promotion Id           : - " + resultSet.getString("Promotion_Id") + "\n"
						                 + "Event Id               : - " + resultSet.getString("Event_id")+ "\n"
						                 + "Promotion Name         : - " +resultSet.getString("Promotion_name") +"\n"
						                 + "Promotion Start Date   : - " + resultSet.getDate("Promotion_Start_Date")+"\n"
						                 + "Promotion End Date     : - " + resultSet.getDate("Promotion_End_Date")+"\n"
						                 + "Discount               : - " + resultSet.getString("Discount")+"\n"
						                 + "Special Offer          : - " + resultSet.getString("Special_Offer")						                 );
						System.out.println("***********************************************************************");
							
					}
					connection.close();
		 
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		return promotion;
	}
	

	@Override
	public Promotion deletePromotion(String promotionId) {
		 DataSource ds=DBConnectionPool.getDataSource();
			Promotion promotion = null;
			
				try
					{
						Connection connection = ds.getConnection();
						PreparedStatement statement =connection.prepareStatement("delete from event where Event_id=?");
						statement.setString(1, promotionId);
						statement.executeUpdate();
						System.out.println(" Event deleted successfully");
						
					}
				
				catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
		
			return promotion;
			
			
	}

	@Override
	public List<Promotion> ListAllPromotion() {
		DataSource ds=DBConnectionPool.getDataSource();
		ArrayList <Promotion> promotionList = new ArrayList<>();
		
		try
			{
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from promotion");
				
				ResultSet resultSet=statement.executeQuery();
					 while (resultSet.next()) {
				            String promotionId = resultSet.getString("Promotion_Id");
				            String eventId = resultSet.getString("Event_id");
				            String promotionName = resultSet.getString("Promotion_name"); 
				          
				            Date startDate = resultSet.getDate("Promotion_Start_Date");
				            LocalDate promotionStartDate = startDate.toLocalDate();
				            
				            Date endDate = resultSet.getDate("Promotion_End_Date");
				            LocalDate promotionEndDate = endDate.toLocalDate();
				            
				            String discount = resultSet.getString("Discount");
				            String specialOffer = resultSet.getString("Special_Offer"); 
				            
				            Event event = new Event();
				            event.setEventId(eventId);
				            Promotion promotion = new Promotion(promotionId, event,promotionName,promotionStartDate,promotionEndDate,discount,specialOffer);
				            promotionList.add(promotion);
				          
				        }
					     
					
			}
		catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
		return promotionList;
		}

	}


