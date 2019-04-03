package com.igate.streamlab;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.igate.labs.*;
public class EmployeeService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("\n\n");
		System.out.println("Find out the sum of salary of all employees.");
		
		Stream<Employee> st = EmployeeRepository.getEmployees().stream();
		List<Double> li2 = st.map((e)->e.getSalary()).collect(Collectors.toList());
		Stream<Double> str = li2.stream();
		Optional<Double> opt = str.reduce((a,b)->a+b);
		System.out.println( opt.get());
		
		
		//List out department names and count of employees in each department
		System.out.println("\n\n");
		System.out.println("List out department names and count of employees in each department");
		
		List<Employee>li = EmployeeRepository.getEmployees();
 Map<Department,Long> m=li.stream().filter(e->e.getDepartment()!=null).collect(
		 Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		m.forEach((a,b)->{System.out.println(a.getDepartmentName()+" "+b);});
		
		
		System.out.println("\n\n");
		System.out.println("List employee name and duration of their service in months and days. ");
		
		Stream<Employee> st1=EmployeeRepository.getEmployees().stream();
		st1.forEach((e)->{
			System.out.println(e.getFirstName()+" - "+Period.between(e.getHireDate(), LocalDate.now()));
	});
	
	
		
		System.out.println("\n\n");
		System.out.println("Find out employees without department ");
		
		Stream<Employee> st2=EmployeeRepository.getEmployees().stream();
		st2.filter((e)->e.getDepartment()==null).forEach(e->System.out.println(e.getFirstName()+" "+e.getLastName()));
	
		System.out.println("\n\n");
		System.out.println("Find out department without employees");
		Stream<Employee> st3=EmployeeRepository.getEmployees().stream();
		Map<Department,List<Employee>> m1 = st3.filter(e->e.getDepartment()!=null).filter(e->e.getFirstName()!=null).collect(Collectors.groupingBy(e->e.getDepartment()));
		Set<Department> set =m1.keySet();
		set.forEach(e->System.out.println(e.getDepartmentName()));
		
	}}
		
		
	

