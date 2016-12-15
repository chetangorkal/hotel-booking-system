package com.hname.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@Column
	private Integer age;
	@Column
	private String name;
	@Column
	private Integer id;

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}