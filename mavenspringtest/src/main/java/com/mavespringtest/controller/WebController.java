package com.mavespringtest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mavespringtest.service.DeptLocationService;
import com.mavespringtest.service.EmployeesService;
import com.mavespringtest.service.DepartmentService;


@Controller
public class WebController {
	@Autowired
	private DeptLocationService deptLocationService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private EmployeesService employeesService;
	
	@GetMapping(value= {"/location", "/location/back"})
	public String viewHomePage(Model model) {
		model.addAttribute("listLocations",deptLocationService.getAllDeptLocations());
		return "locations";
	}
	
	@GetMapping("/location/{loc}")
	//@RequestMapping("/employee")
	public String viewHomePage1(@Valid@PathVariable("loc") Long locId,Model model) {
		model.addAttribute("listdepts",departmentService.getDepartmentsByLocId(locId));
		return "departments";
	}
	
	
	@GetMapping(value= {"location/{locid}/department/{deptid}","/department/{deptid}/back"})
	public String viewHomePage3(@Valid@PathVariable("deptid") Long deptid,@Valid@PathVariable("locid") Long locid,Model model) {
		model.addAttribute("locid",  locid);
		//System.out.println(employeesService.getEmployeesByDeptId(deptid).get(0));
		if(employeesService.getEmployeesByDeptId(deptid).size()!=0) {
			model.addAttribute("listEmployees",employeesService.getEmployeesByDeptId(deptid));
			return "employees";
		}
		else {
			return "error";
		}
		
	}
	
	
	
}
