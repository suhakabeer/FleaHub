package com.canddella.service;

import java.util.List;

import com.canddella.entity.VenuePayment;

public interface VenuePaymentService {
	public void saveVenuePayment(VenuePayment venuePayment);
	public VenuePayment viewVenuePayment(String venueId);
	public VenuePayment deleteVenuePaymen(String venueId);
	public List<VenuePayment> listAllVenuePayment();
}
