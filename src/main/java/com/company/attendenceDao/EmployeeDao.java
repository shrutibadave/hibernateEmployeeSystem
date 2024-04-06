package com.company.attendenceDao;

import java.util.List;

import org.hibernate.Session;



public interface EmployeeDao {
	public int insertEmployee(Session s);

	public void update( Session s);

	public void delete( Session s);

	public List<Object[]> getEmployeeDetail(Session s);
		

}
