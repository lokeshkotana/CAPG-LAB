package com.cg.eis.service;

import com.cg.eis.Dao.EmployeeDao;
import com.cg.eis.Dao.EmployeeDaoImpl;
import com.cg.eis.bean.Employee;
/**
 * 
 * @author LOKE$H
 *
 */
public class EmployeeServiceImpl implements EmployeeService{
	EmployeeDao ed= new EmployeeDaoImpl();
	@Override
	
	
	public String addEmployee(Employee e) {
		// TODO Auto-generated method stub
		if(e.getId()>0)
			return ed.addEmployee(e);
		return "Invalid Id";
	}

	@Override
	public String findIns(long salary, String designation) {
		// TODO Auto-generated method stub
		if(salary<0)
			return "Invalid salary";
		return ed.findIns(salary, designation);
	}

	@Override
	public Employee disp(long id) {
		// TODO Auto-generated method stub
		
		return ed.disp(id);
	}

	
}

