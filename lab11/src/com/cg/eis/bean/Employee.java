package com.cg.eis.bean;
/**
 * 
 * @author LOKE$H
 *
 */
public class Employee {

	private String name,designation, insuranceScheme;
private long id,salary;
public Employee() {}
public Employee(String name, String designation, String insuranceScheme, long id, long salary) {
	super();
	this.name = name;
	this.designation = designation;
	this.insuranceScheme = insuranceScheme;
	this.id = id;
	this.salary = salary;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getInsuranceScheme() {
	return insuranceScheme;
}
public void setInsuranceScheme(String insuranceScheme) {
	this.insuranceScheme = insuranceScheme;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getSalary() {
	return salary;
}
public void setSalary(long salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "Employee [name=" + name + ", designation=" + designation + ", insuranceScheme=" + insuranceScheme + ", id="
			+ id + ", salary=" + salary + "]";
}







}
