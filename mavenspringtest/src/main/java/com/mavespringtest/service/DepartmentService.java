package com.mavespringtest.service;

import java.util.List;

import com.mavespringtest.model.Department;


public interface DepartmentService {
	
	List<Department> getAllDepartments();
	List<Department> getDepartmentsByLocId(Long locId);

}
