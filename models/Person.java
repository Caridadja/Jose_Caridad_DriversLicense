package com.caridadja.relationships.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//...
@Entity
@Table(name="persons")
public class Person {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String firstName;
 private String lastName;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval = true)
 private License license;
 
 public Person() {
     
 }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public Date getCreatedAt() {
	return createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public License getLicense() {
	return license;
}

public void setLicense(License license) {
	this.license = license;
}
 
}

