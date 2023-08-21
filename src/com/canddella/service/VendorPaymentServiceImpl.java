package com.canddella.service;

import java.util.List;

import com.canddella.dao.VendorPaymentDAOImpl;
import com.canddella.entity.VendorPayment;


public class VendorPaymentServiceImpl implements VendorPaymentService {
	VendorPaymentDAOImpl vendorPaymentDAOImpl = new VendorPaymentDAOImpl();
	@Override
	public void saveVendorPayment(VendorPayment vendorPayment) {
		vendorPaymentDAOImpl.saveVendorPayment(vendorPayment);
	}

	@Override
	public VendorPayment viewVendorPayment(String vendorPaymentId) {
		
		return vendorPaymentDAOImpl.viewVendorPayment(vendorPaymentId);
	}

	@Override
	public VendorPayment deleteVendorPayment(String vendorPaymentId) {
		
		return vendorPaymentDAOImpl.deleteVendorPayment(vendorPaymentId);
	}

	@Override
	public List<VendorPayment> listAllVendorPayment() {
		
		return vendorPaymentDAOImpl.listAllVendorPayment();
	}

}
