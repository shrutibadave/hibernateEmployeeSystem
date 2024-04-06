package com.company.attendance.dao.hib;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.company.attendenceDao.EmployeeDao;
import com.company.employeModel.Attendance;
import com.company.employeModel.Employe;


public class EmployeeDaoHib implements EmployeeDao {
	private final int totalWorkingDay = 20;

	@Override
	public int insertEmployee(Session s) {
		// TODO Auto-generated method stub
		Transaction t = s.beginTransaction();
		Date d = new Date();
		Employe emp = new Employe();
		emp.setDepartment("It");
		emp.setEmployeeName("Abc");

		Attendance at = new Attendance();
		at.setLogin("10:00AM");
		at.setLogout("6:00PM");
		at.setDate(d);
		at.setLeave(12);
		at.setEmp(emp);

		emp.setAtt(at);
		int result = (int) s.save(emp);
		t.commit();

		return result;
	}

	@Override
	public void update(Session s) {
		Transaction t = s.beginTransaction();
		Date d = new Date();
		Employe e = s.get(Employe.class, 9);
		e.setDepartment("QA");
		e.setEmployeeName("Aop");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);

		calendar.add(Calendar.DAY_OF_MONTH, 2);

		Date twoDaysLater = calendar.getTime();
		Attendance at = new Attendance();
		at.setLogin("11:00AM");
		at.setLogout("7:00PM");
		at.setDate(twoDaysLater);
		at.setLeave(12);
		at.setEmp(e);
		e.setAtt(at);

		s.update(e);
		t.commit();

	}

	@Override
	public void delete(Session s) {
		Transaction t = s.beginTransaction();

		Employe e = s.get(Employe.class, 9);

		s.delete(e);
		t.commit();

	}

	@Override
	public List<Object[]> getEmployeeDetail(Session s) {
		Transaction t = s.beginTransaction();
		String query = "select e.employeeName,e.department ,a.login,a.logout from employe e,attendance a where e.empId=a.empId and e.empId=:e";
		// String query ="select * from employe";
		Query<Object[]> query2 = s.createSQLQuery(query);
		query2.setParameter("e", 11);
		List<Object[]> resultList = query2.getResultList();
		
		return resultList;
	}

}
