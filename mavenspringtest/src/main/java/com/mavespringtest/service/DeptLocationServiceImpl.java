package com.mavespringtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mavespringtest.model.DeptLocation;

import com.mavespringtest.repository.DeptLocationRepository;

@Service
public class DeptLocationServiceImpl implements DeptLocationService{
	@Autowired
	private DeptLocationRepository deptLocationRepository;
	
	
	public List<DeptLocation> getAllDeptLocations() {
		return deptLocationRepository.findAll();
	}

}
