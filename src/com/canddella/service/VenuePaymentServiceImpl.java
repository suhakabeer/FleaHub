package com.canddella.service;

import java.util.List;

import com.canddella.dao.VenuePaymentDAOImpl;
import com.canddella.entity.VenuePayment;

public class VenuePaymentServiceImpl implements VenuePaymentService {
	VenuePaymentDAOImpl venuePaymentDAOImpl = new VenuePaymentDAOImpl();
	@Override
	public void saveVenuePayment(VenuePayment venuePayment) {
		
		venuePaymentDAOImpl.saveVenuePayment(venuePayment);
	}

	@Override
	public VenuePayment viewVenuePayment(String venueId) {
		
		return venuePaymentDAOImpl.viewVenuePayment(venueId);
	}

	@Override
	public VenuePayment deleteVenuePaymen(String venueId) {
		
		return venuePaymentDAOImpl.deleteVenuePaymen(venueId);
	}

	@Override
	public List<VenuePayment> listAllVenuePayment() {
		
		return venuePaymentDAOImpl.listAllVenuePayment();
	}

}
