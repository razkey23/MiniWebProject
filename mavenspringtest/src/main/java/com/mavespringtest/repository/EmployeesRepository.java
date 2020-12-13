package com.mavespringtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mavespringtest.model.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Long>{

}