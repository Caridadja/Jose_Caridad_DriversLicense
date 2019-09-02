package com.caridadja.relationships.services;

import org.springframework.stereotype.Service;

import com.caridadja.relationships.models.License;
import com.caridadja.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private static String number = "000000";
	private LicenseRepository licenseRepository;
	
	private LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	public void addLicense(License license) {
		number = String.format("%06d", Integer.parseInt(number)+1);
		license.setNumber(number);
		licenseRepository.save(license);
	}
	public License getLicenseById(Long id) {
		return licenseRepository.getLicenseByPersonId(id);
	}
	public void deleteLicense(Long id) {
		licenseRepository.deleteById(id);
	}
}
