package com.company.employeModel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int aId;
	String login;
	String logout;
	@Column(name = "leave_taken")
	int leave;

	@Transient
	int daysAttended;

	@Temporal(value = TemporalType.DATE)
	Date date;
	@OneToOne
	@JoinColumn(name="empId")
	Employe emp;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogout() {
		return logout;
	}

	public void setLogout(String logout) {
		this.logout = logout;
	}



	public int getLeave() {
		return leave;
	}

	public void setLeave(int leave) {
		this.leave = leave;
	}

	public int getDaysAttended() {
		return daysAttended;
	}

	public void setDaysAttended(int daysAttended) {
		this.daysAttended = daysAttended;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Employe getEmp() {
		return emp;
	}

	public void setEmp(Employe emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Attendance [aId=" + aId + ", login=" + login + ", logout=" + logout + ", leave=" + leave
				+ ", daysAttended=" + daysAttended + ", date=" + date + ", emp=" + emp + "]";
	}

}
