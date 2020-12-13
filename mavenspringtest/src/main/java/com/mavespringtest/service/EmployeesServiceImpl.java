

package com.mavespringtest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavespringtest.model.Department;
import com.mavespringtest.model.Employee;
import com.mavespringtest.model.Employees;
import com.mavespringtest.repository.EmployeesRepository;

@Service
public class EmployeesServiceImpl implements EmployeesService{
	@Autowired
	private EmployeesRepository employeesRepository;
	
	public List<Employees> getAllEmployees() {
		return employeesRepository.findAll();
	}
	
	public Employees getEmployeeById(Long id) {
		return employeesRepository.findById(id).get();
	}
	 
	public List<Employees> getEmployeesByDeptId(Long deptid) {
		List<Employees> allEmployees = employeesRepository.findAll();
		ArrayList<Employees> result = new ArrayList<Employees>();
		for (int i=0;i<allEmployees.size();i++) {
			Long departmentId = allEmployees.get(i). getDeptidd();
			//System.out.println(identity);
			//if (result.length() > 0 && ret.length() !=cart.size()-1) ret.append(",");
			if(departmentId == deptid) {
				result.add(allEmployees.get(i));
			}
			//System.out.println(id);
			
		}
		return result;
	}
	
	public List<Employees> getEmployeesByName(String fname,String lname) {
		List<Employees> allEmployees = employeesRepository.findAll();
		ArrayList<Employees> result = new ArrayList<Employees>();
		for (int i=0;i<allEmployees.size();i++) {
			String firstname = allEmployees.get(i).getFirstName();
			String lastname = allEmployees.get(i).getLastName();
			//System.out.println(identity);
			//if (result.length() > 0 && ret.length() !=cart.size()-1) ret.append(",");
			if(fname.equals(firstname) && lname.equals(lastname)) {
				result.add(allEmployees.get(i));
			}
			//System.out.println(id);
			
		}
		return result;
	}
	
}