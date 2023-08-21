package com.canddella.service;

import java.util.List;

import com.canddella.entity.VendorPayment;

public interface VendorPaymentService {
	public void saveVendorPayment(VendorPayment vendorPayment);
	public VendorPayment viewVendorPayment(String vendorId);
	public VendorPayment deleteVendorPayment(String vendorId);
	public List<VendorPayment> listAllVendorPayment();
}
