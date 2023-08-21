package com.canddella.dao;

import java.util.List;

import com.canddella.entity.VenuePayment;


public interface VenuePaymentDAO {
	public void saveVenuePayment(VenuePayment venuePayment);
	public VenuePayment viewVenuePayment(String venueId);
	public VenuePayment deleteVenuePaymen(String venueId);
	public List<VenuePayment> listAllVenuePayment();
}
