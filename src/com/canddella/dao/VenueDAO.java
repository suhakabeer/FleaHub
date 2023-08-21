package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Venue;

public interface VenueDAO {

	public void saveVenue(Venue venue);
	public Venue viewVenue(String venueId);
	public Venue deleteVenue(String venueId);
	public List<Venue> listAllVenue();
	public Venue getVenue(String VenueId);
	public void updateVenue(String VenueId, String venueStore, String venueName);
	
}
