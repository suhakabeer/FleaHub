package com.canddella.dao;

import java.util.List;

import com.canddella.entity.VendorPayment;

public interface VendorPaymentDAO {
	public void saveVendorPayment(VendorPayment vendorPayment);
	public VendorPayment viewVendorPayment(String vendorId);
	public VendorPayment deleteVendorPayment(String vendorId);
	public List<VendorPayment> listAllVendorPayment();
}
