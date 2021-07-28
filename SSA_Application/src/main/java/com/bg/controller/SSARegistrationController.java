package com.bg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bg.model.PersonDetailsModel;
import com.bg.service.SSARegistrationService;

@Controller
public class SSARegistrationController {

	@Autowired
	private SSARegistrationService ssaService;

	@RequestMapping(value = {"/","/addDetails"}, method = RequestMethod.GET)
	public String handleForm(Model model) {
		
		PersonDetailsModel personModel = new PersonDetailsModel();
		model.addAttribute("personDetails", personModel);
		
		List<String> stateList = ssaService.getAllStates();
		model.addAttribute("stateList", stateList);
		return "person_details";
	}

	@RequestMapping(value = "/saveDetails", method = RequestMethod.POST)
	public String handleSubmitButton(@ModelAttribute("personDetails") PersonDetailsModel personModel,
			RedirectAttributes attributes) {

		String ssaNumber = ssaService.savePersonDetails(personModel);
		if (ssaNumber != null) {
			attributes.addFlashAttribute("result", "Registration Successfull Your SSA Number Is " + ssaNumber);
			return "redirect:/addDetails";
		}
		attributes.addFlashAttribute("result", "Your Registration Failed");
		return "redirect:/addDetails";
	}

}
