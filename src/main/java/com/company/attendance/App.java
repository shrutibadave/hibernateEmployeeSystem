package com.company.attendance;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.company.attendance.dao.hib.EmployeeDaoHib;
import com.company.attendenceDao.EmployeeDao;

import com.mysql.fabric.xmlrpc.base.Array;

public class App {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("employee.config.hib.xml").buildSessionFactory();
		Session s = sf.openSession();
		System.out.println("Welcome to employee System");
		System.out.println("What you want to perform");
		System.out.println("1.Insert Record");
		System.out.println("2.Update Record");
		System.out.println("3.Delete Record");
		System.out.println("4.Show Employee record");
		Scanner sc = new Scanner(System.in);
		EmployeeDao empDao = new EmployeeDaoHib();
		int input = sc.nextInt();

		switch (input) {
		case 1:
			empDao.insertEmployee(s);
			break;
		case 2:
			empDao.update(s);
			break;
		case 3:
			empDao.delete(s);
			break;
		case 4:
			List<Object[]> list=empDao.getEmployeeDetail(s);
			
			for ( Object[] o : list) {
				System.out.println(Arrays.toString(o));
			}
			//System.out.println(list);
			break;

		}

		s.close();
		sf.close();

	}
}
