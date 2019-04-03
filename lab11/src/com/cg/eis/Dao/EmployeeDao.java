package com.cg.eis.Dao;
/**
 * 
 * @author LOKE$H
 *
 */
import com.cg.eis.bean.Employee;

public interface EmployeeDao {
public String addEmployee(Employee e);
public String findIns(long salary,String designation);
public Employee disp(long id);
	
}
