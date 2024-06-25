package com.demobreaker.circuit_breaker.entity;

//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "emp1")

public class Empolyee {
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	private  String  Salary;

	@Override
	public String toString() {

		return "Employee[name=" + name + ", Salary=" + Salary + "]";

		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String string ) {
		this.Salary = string;
	}

}
