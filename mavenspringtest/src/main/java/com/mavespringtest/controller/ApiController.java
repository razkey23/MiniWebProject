package com.mavespringtest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mavespringtest.service.DepartmentService;
import com.mavespringtest.service.DeptLocationService;
import com.mavespringtest.service.EmployeesService;
import com.mavespringtest.model.Department;
import com.mavespringtest.model.DeptLocation;
import com.mavespringtest.model.Employees;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private DeptLocationService deptLocationService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private EmployeesService employeesService;
	
	@GetMapping(value= {"location"},produces= "application/xml")
	//@RequestMapping("/employee")
	public List<DeptLocation> getAllDepartmentLocations(Model model) {
		//model.addAttribute("listLocations",deptLocationService.getAllDeptLocations());
		List<DeptLocation> deptLocation=deptLocationService.getAllDeptLocations();
		return deptLocation;
	}
	
	@GetMapping(value= {"departments"},produces= "application/xml")
	//@RequestMapping("/employee")
	public List<Department> getAllDepartments(Model model) {
		//model.addAttribute("listLocations",deptLocationService.getAllDeptLocations());
		return departmentService.getAllDepartments();
	}
	
	@GetMapping(value="departments/{loc}",produces= "application/xml")
	//@RequestMapping("/employee")
	public List<Department> getDepartmentsByLocation(@Valid@PathVariable("loc") Long locId,Model model) {
		return departmentService.getDepartmentsByLocId(locId);
	}
	
	@GetMapping(value="employees/{deptid}",produces="application/xml")
	public List<Employees> getEmployeesByDepartmentId(@Valid@PathVariable("deptid") Long deptid,Model model){
		return employeesService.getEmployeesByDeptId(deptid);
	}
	
	@GetMapping(value="employeesSearch",produces="application/xml")
	public List<Employees> getEmployeesByNames(@Valid@RequestParam("fname") String fname,@Valid@RequestParam("lname") String lname,Model model){
		return employeesService.getEmployeesByName(fname,lname);
	}
	
	@GetMapping(value="employeeById",produces="application/xml")
	public Employees getEmployeesByNames(@RequestParam("id") Long identity,Model model){
		return employeesService.getEmployeeById(identity);
	}

}
