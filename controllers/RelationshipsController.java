package com.caridadja.relationships.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.caridadja.relationships.models.*;
import com.caridadja.relationships.repositories.*;
import com.caridadja.relationships.services.*;

@Controller
@RequestMapping("/")
public class RelationshipsController {

	private final PersonService personService;
	private final LicenseService licenseService;
	
	public RelationshipsController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	@RequestMapping("")
	public String index(Model model) {
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("persons", persons);
		return "index.jsp";
	}
	@RequestMapping("/persons/new")
	public String redirectAddPerson(@ModelAttribute("person") Person person) {
		return "addPerson.jsp";
	}
	@PostMapping("/persons/new")
	public String addPerson(@ModelAttribute("person") Person person) {
		personService.addPerson(person);
		return "redirect:/";
	}
	@RequestMapping("/licenses/new")
	public String redirectAddLicense(Model model, @ModelAttribute("license") License license) {
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("persons", persons);
		return "addLicense.jsp";
	}
	@PostMapping("/licenses/new")
	public String addLicense(@ModelAttribute("license") License license) {
		licenseService.addLicense(license);
		return "redirect:/";
	}
	@RequestMapping("/persons/{id}")
	public String showLicense(Model model, @PathVariable("id") Long id) {
		Person person = personService.getPersonById(id);
		model.addAttribute("person", person);
		return "showLicense.jsp";
	}
	@RequestMapping("persons/{personId}/delete")
		public String delete(@PathVariable("personId") Long personId) {
			personService.deletePerson(personId);
			return "redirect:/";
	}
}
