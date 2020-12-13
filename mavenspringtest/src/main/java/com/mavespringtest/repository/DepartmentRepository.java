package com.mavespringtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mavespringtest.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{

}
