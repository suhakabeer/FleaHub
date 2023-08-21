package com.canddella.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Event;

public class EventCalendar {

    public List<Event> getUpcomingEvents() {
        DataSource ds = DBConnectionPool.getDataSource();
        List<Event> events = new ArrayList<>();
        java.util.Date currentDate = new java.util.Date();

        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM event WHERE Event_Start_Date >= NOW()");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Event event = new Event();
              //  event.setEventId(resultSet.getString("Event_id"));
                event.setEventName(resultSet.getString("Event_name"));

                java.sql.Date startDate = resultSet.getDate("Event_Start_Date");
                LocalDate eventStartDate = startDate.toLocalDate();
                event.setEventStartDate(eventStartDate);

                java.sql.Date endDate = resultSet.getDate("Event_End_Date");
                LocalDate eventEndDate = endDate.toLocalDate();
                event.setEventEndDate(eventEndDate);

         

                events.add(event);
            }

            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return events;
    }

    public static void main(String[] args) {
        EventCalendar calendar = new EventCalendar();
        List<Event> upcomingEvents = calendar.getUpcomingEvents();

        // Print or display upcoming events
        for (Event event : upcomingEvents) {
            System.out.println("Event Name: " + event.getEventName());
            System.out.println("Start Date: " + event.getEventStartDate());
            System.out.println("End Date  : " + event.getEventEndDate());
          
            System.out.println("--------------------------");
        }
    }
}
