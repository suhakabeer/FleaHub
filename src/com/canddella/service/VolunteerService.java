package com.canddella.service;

import java.util.List;

import com.canddella.entity.Volunteer;

public interface VolunteerService {
	public void saveVolunteer(Volunteer volunteer);
	public Volunteer viewVolunteer(String volunteerId);
	public Volunteer deleteVolunteer(String volunteerId);
	public List<Volunteer> listAllVolunteer();
	int totalVolunteers(String eventId);
	int TotalVolunteerCapacity(String eventId);
	
}
