package com.caridadja.relationships.repositories;

import org.springframework.data.repository.CrudRepository;

import com.caridadja.relationships.models.License;

public interface LicenseRepository extends CrudRepository <License, Long> {

	License getLicenseByPersonId(Long id);

}