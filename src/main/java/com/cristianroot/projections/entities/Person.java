package com.cristianroot.projections.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private long id;

	@NotNull
	private String name;

	@NotNull
	private int age;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Car> carList;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

}
