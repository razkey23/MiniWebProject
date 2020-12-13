package com.mavespringtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="deptlocation")
public class DeptLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long LocId;
	
	@Column(name="Locname")
	private String Locname;

	public Long getLocId() {
		return LocId;
	}

	public void setLocId(Long locId) {
		LocId = locId;
	}

	public String getLocname() {
		return Locname;
	}

	public void setLocname(String locname) {
		Locname = locname;
	}
}
