package com.canddella.service;

import java.util.List;

import com.canddella.dao.VolunteerDAOImpl;
import com.canddella.entity.Volunteer;

public class VolunteerServiceImpl implements VolunteerService {
	
    VolunteerDAOImpl volunteerDAOImpl = new VolunteerDAOImpl();
    @Override
	public void saveVolunteer(Volunteer volunteer) {
		
	volunteerDAOImpl.saveVolunteer(volunteer);
	}

	@Override
	public Volunteer viewVolunteer(String volunteerId) {
		
		return volunteerDAOImpl.viewVolunteer(volunteerId);
	}

	@Override
	public Volunteer deleteVolunteer(String volunteerId) {
		
		return volunteerDAOImpl.deleteVolunteer(volunteerId);
	}

	@Override
	public List<Volunteer> listAllVolunteer() {
		
		return volunteerDAOImpl.listAllVolunteer();
	}
	@Override
	public int totalVolunteers(String eventId) {
		
		return volunteerDAOImpl.totalVolunteers(eventId);
	}

	@Override
	public int TotalVolunteerCapacity(String eventId) {
		
		return volunteerDAOImpl.TotalVolunteerCapacity(eventId);
	}
}
