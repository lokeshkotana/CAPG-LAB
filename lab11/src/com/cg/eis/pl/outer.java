package com.cg.eis.pl;
/**
 * 
 * @author LOKE$H
 *
 */
import com.cg.eis.bean.*;
/**
 * 
 * @author LOKE$H
 *
 */
import com.cg.eis.service.EmployeeService;
import com.cg.eis.service.EmployeeServiceImpl;

public class outer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EmployeeService es=new EmployeeServiceImpl();
		
		
		Employee e1=new Employee("lokesh","Programmer","Scheme B",73224,521521);
		Employee e2=new Employee("lok","Manager","Scheme C",32244,52521);
		Employee e3=new Employee("esh","Clerk","Scheme A",32124,5211);
		es.addEmployee(e1);
		es.addEmployee(e3);
		es.addEmployee(e2);
		System.out.println(es.disp(32124));
		System.out.println(es.findIns(6000,"Clerk"));
		
		
		
	}

}
