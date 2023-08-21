package com.canddella.service;

import java.util.List;

import com.canddella.dao.VenueDAOImpl;
import com.canddella.entity.Venue;

public class VenueServiceImpl implements VenueService {

	VenueDAOImpl venueDAOImpl = new VenueDAOImpl();
	@Override
	public void saveVenue(Venue venue) {
		
		venueDAOImpl.saveVenue(venue);
	}

	@Override
	public Venue viewVenue(String venueId) {
		
	return  venueDAOImpl.viewVenue(venueId);
	}

	@Override
	public Venue deleteVenue(String venueId) {
		
		return venueDAOImpl.deleteVenue(venueId);
	}

	@Override
	public List<Venue> listAllVenue() {
	
		return venueDAOImpl.listAllVenue();
	}

	@Override
	public Venue getVenue(String VenueId) {
		
		return venueDAOImpl.getVenue(VenueId);
	}

	@Override
	public void updateVenue(String VenueId, String venueStore, String venueName) {
		
		venueDAOImpl.updateVenue(VenueId, venueStore, venueName);
	}

	

}
