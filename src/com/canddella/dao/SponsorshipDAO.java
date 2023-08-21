package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Sponsorship;


public interface SponsorshipDAO {
	public void  saveSponsorship(Sponsorship  sponsorship);
	public  Sponsorship viewSponsorship(String sponsorshipId);
	public  Sponsorship deleteSponsorship(String sponsorshipId);
	public List<Sponsorship> ListAllSponsorship();
}
