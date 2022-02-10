package com.techm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeT")
public class Employee {
	
	@Id
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String password;
	
	@Column
	private String confirmpsw;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpsw() {
		return confirmpsw;
	}

	public void setConfirmpsw(String confirmpsw) {
		this.confirmpsw = confirmpsw;
	}

	public Employee(long id, String name, String password, String confirmpsw) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.confirmpsw = confirmpsw;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", password=" + password + ", confirmpsw=" + confirmpsw + "]";
	}
}
