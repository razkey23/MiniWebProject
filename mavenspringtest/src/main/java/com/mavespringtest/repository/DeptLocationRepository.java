package com.mavespringtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mavespringtest.model.DeptLocation;

@Repository
public interface DeptLocationRepository extends JpaRepository<DeptLocation,Long> {

}
