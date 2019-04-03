package com.cg.eis.service;

import java.util.List;

import com.cg.eis.bean.Employee;

/**
 * 
 * @author LOKE$H
 *
 */
public interface EmployeeService {


		public String addEmployee(Employee e);
		public String findIns(long salary,String designation);
		public Employee disp(long id);
			
	

}