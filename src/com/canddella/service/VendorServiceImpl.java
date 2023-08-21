package com.canddella.service;

import java.util.List;

import com.canddella.dao.VendorDAOImpl;
import com.canddella.entity.Vendor;

public class VendorServiceImpl implements VendorService {
	
	VendorDAOImpl vendorDAOImpl = new VendorDAOImpl();
	
	@Override	
	public void saveVendor(Vendor vendor) {
		
		vendorDAOImpl.saveVendor(vendor);
	}

	@Override
	public Vendor viewVendor(String vendorId) {
		
		return  vendorDAOImpl.viewVendor(vendorId);
	}

	@Override
	public Vendor deleteVendor(String vendorId) {
	
		return vendorDAOImpl.deleteVendor(vendorId);
	}

	@Override
	public List<Vendor> listAllVendor() {
		
		return vendorDAOImpl.listAllVendor();
	}

	@Override
	public Vendor getVendor(String VendorId) {
		
		return vendorDAOImpl.getVendor(VendorId);
	}

	@Override
	public void updateVendor(String VendorId, String vendorStore, String vendorName) {
		
		vendorDAOImpl.updateVendor(VendorId, vendorStore, vendorName);
	}

}
