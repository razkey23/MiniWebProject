package com.mavespringtest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Deptid;
	
	@Column(name="DeptName")
	private String Dname;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "deptlocation_LocId")
	private DeptLocation location;

	public Long getDeptid() {
		return Deptid;
	}

	public void setDeptid(Long deptid) {
		Deptid = deptid;
	}

	public String getDname() {
		return Dname;
	}

	public void setDname(String dname) {
		Dname = dname;
	}
	
	public Long getLocId() {
		return location.getLocId();
	}
	
	public void setLocId(DeptLocation loc) {
		this.location=loc;
	}
	

}
