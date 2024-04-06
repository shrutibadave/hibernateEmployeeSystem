package com.company.employeModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int empId;

	String employeeName;
	String department;

	@OneToOne(mappedBy = "emp", cascade = CascadeType.ALL)
	Attendance att;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Attendance getAtt() {
		return att;
	}

	public void setAtt(Attendance att) {
		this.att = att;
	}

	@Override
	public String toString() {
		return "Employe [empId=" + empId + ", employeeName=" + employeeName + ", department=" + department + ", att="
				+ att + "]";
	}

}
