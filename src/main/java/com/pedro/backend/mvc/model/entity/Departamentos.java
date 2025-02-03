package com.pedro.backend.mvc.model.entity;
// Generated 17 dic 2024, 13:12:32 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Departamentos generated by hbm2java
 */
@Entity
@Table(name = "departamentos", catalog = "personal")
public class Departamentos implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int deptNo;
	private String dnombre;
	private String loc;
	private Set<Empleados> empleadoses = new HashSet<Empleados>(0);

	public Departamentos() {
	}

	public Departamentos(int deptNo) {
		this.deptNo = deptNo;
	}

	public Departamentos(int deptNo, String dnombre, String loc, Set<Empleados> empleadoses) {
		this.deptNo = deptNo;
		this.dnombre = dnombre;
		this.loc = loc;
		this.empleadoses = empleadoses;
	}

	@Id

	@Column(name = "dept_NO", unique = true, nullable = false)
	public int getDeptNo() {
		return this.deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	@Column(name = "dnombre", length = 15)
	public String getDnombre() {
		return this.dnombre;
	}

	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}

	@Column(name = "loc", length = 15)
	public String getLoc() {
		return this.loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamentos")
	@JsonIgnore
	public Set<Empleados> getEmpleadoses() {
		return this.empleadoses;
	}

	public void setEmpleadoses(Set<Empleados> empleadoses) {
		this.empleadoses = empleadoses;
	}

}
