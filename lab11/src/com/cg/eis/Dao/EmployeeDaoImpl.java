package com.cg.eis.Dao;
/**
 * 
 * @author LOKE$H
 *
 */
import com.cg.eis.bean.Employee;
import java.util.*;
public class EmployeeDaoImpl implements EmployeeDao {
List<Employee> li=new ArrayList();

	@Override
	public String addEmployee(Employee e) {
		// TODO Auto-generated method stub
		li.add(e);
		return "Details added";
	}

	@Override
	public String findIns(long salary, String designation) {
		// TODO Auto-generated method stub
		if(salary>5000 && salary<20000 ||designation.equalsIgnoreCase("System Associate")  )
		return "Scheme C";
		
		if(salary<40000 && salary>=20000 ||designation.equalsIgnoreCase("Programmer")  )
			return "Scheme B";
		
		if(salary>=40000 ||designation.equalsIgnoreCase("Manager")  )
			return "Scheme A";
		if(salary<5000 ||designation.equalsIgnoreCase("Clerk")  )
			return "No Scheme";
		
		return "Invalid";
		
	}

	@Override
	public Employee disp(long id) {
		// TODO Auto-generated method stub
		for(Employee i:li)
		{
			if(i.getId()==id)
				return i;
		}
		return null;
	}

}
