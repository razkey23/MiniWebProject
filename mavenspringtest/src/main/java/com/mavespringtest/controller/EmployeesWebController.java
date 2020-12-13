package com.mavespringtest.controller;




import com.mavespringtest.service.EmployeesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeesWebController {
	
	@Autowired
	private EmployeesService employeesService;
	
	@GetMapping("/employees")
	//@RequestMapping("/employee")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees",employeesService.getAllEmployees());
		return "NewFile";
	}
}