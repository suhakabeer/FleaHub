package com.canddella.service;

import java.util.List;

import com.canddella.dao.SponsorshipDAOImpl;
import com.canddella.entity.Sponsorship;

public class SponsorshipServiceImpl implements SponsorshipService {
 SponsorshipDAOImpl sponsorshipDAOImpl = new SponsorshipDAOImpl();
	@Override
	public void saveSponsorship(Sponsorship sponsorship) {
		sponsorshipDAOImpl.saveSponsorship(sponsorship);
		
	}

	@Override
	public Sponsorship viewSponsorship(String sponsorshipId) {
		
		return sponsorshipDAOImpl.viewSponsorship(sponsorshipId);
	}

	@Override
	public Sponsorship deleteSponsorship(String sponsorshipId) {
		
		return sponsorshipDAOImpl.deleteSponsorship(sponsorshipId);
	}

	@Override
	public List<Sponsorship> ListAllSponsorship() {
		
		return sponsorshipDAOImpl.ListAllSponsorship();
	}

}
