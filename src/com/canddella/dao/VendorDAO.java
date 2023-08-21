package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Vendor;


public interface VendorDAO {
	public void saveVendor(Vendor vendor);
	public Vendor viewVendor(String vendorId);
	public Vendor deleteVendor(String vendorId);
	public List<Vendor> listAllVendor();
	public Vendor getVendor(String VendorId);
	public void updateVendor(String VendorId, String vendorStore, String vendorName);
}
