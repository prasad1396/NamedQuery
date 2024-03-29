package com.nareshit.derivedmethod.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tbl_employee")

//Looking for Department and Max Salary
  //Admin ==> 35000
 //Sale==>30000
//IT==>40000
//HR ==> 80000

@NamedQueries(value = {
		@NamedQuery(name = "Employee.findMaxSalariesByDept",
				query = "SELECT e.dept, MAX(e.salary) FROM Employee e GROUP BY "
						+ "e.dept HAVING e.dept in ?1")


})
public class Employee {
	private @Id @GeneratedValue Long id;
	private String name;
	private String dept;
	private int salary;



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(String name, String dept, int salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}

	public static Employee create(String name, String dept, int salary) {
		Employee e = new Employee();
		e.setName(name);
		e.setDept(dept);
		e.setSalary(salary);
		return e;
	}


	public Employee() {}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}
}
