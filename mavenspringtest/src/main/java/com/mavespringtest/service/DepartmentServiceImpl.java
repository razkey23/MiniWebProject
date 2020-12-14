package com.mavespringtest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavespringtest.model.Department;

import com.mavespringtest.repository.DepartmentRepository;



@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
	
	public List<Department> getDepartmentsByLocId(Long locId) {
		List<Department> allDepts = departmentRepository.findAll();
		ArrayList<Department> result = new ArrayList<Department>();
		System.out.println(locId);
		System.out.println(allDepts.size());
		for (int i=0;i<allDepts.size();i++) {
			Long identity = allDepts.get(i).getLocId();
			System.out.println(identity);
			//if (result.length() > 0 && ret.length() !=cart.size()-1) ret.append(",");
			if(identity == locId) {
				result.add(allDepts.get(i));
				System.out.println(identity);
			}
			//System.out.println(id);
			
		}
		return result;
	}
	
	public Department getDepartmentByDeptid(Long Deptid) {
		return departmentRepository.findById(Deptid).get();
	}

}
