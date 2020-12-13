

package com.mavespringtest.service;

import java.util.List;


import com.mavespringtest.model.Employees;

public interface EmployeesService {
	List<Employees> getAllEmployees();
	Employees getEmployeeById(Long id);
	List<Employees> getEmployeesByDeptId(Long deptid);
	List<Employees> getEmployeesByName(String fName,String lname);
}