package com.mavespringtest.controller;


import com.mavespringtest.model.Employees;
import com.mavespringtest.service.EmployeeService;
import com.mavespringtest.service.EmployeesService;

import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeesService employeesService;
	
	@GetMapping("/employee")
	//@RequestMapping("/employee")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees",employeesService.getAllEmployees());
		return "NewFile";
	}
	
	
	@PostMapping("/employee")
	  public String testFunction(@RequestParam("identity") Long identity,Model model) {
		//HttpSession session = request.getSession();
		//session.setAttribute("username",identity);
		model.addAttribute("test",employeesService.getEmployeeById(identity));
		return "test";	
	  }

	
}