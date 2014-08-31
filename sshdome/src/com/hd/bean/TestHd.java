package com.hd.bean;

//import javax.persistence.*;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import org.hibernate.annotations.*;

/**
 * @author hed
 * Jun 7, 2013
 */
//@Entity
//@Table(name="testhd")
public class TestHd {
	
	private int id;
	private String name;
	private int age;
	
	public TestHd(){};
	
	public TestHd(String name,int age){
		this.name=name;
		this.age=age;
	}
	
//	@GenericGenerator(
//			name ="generator", 
//			strategy ="sequence",
//			parameters = {@Parameter(name ="sequence",value ="seq_testhd")})
//	@Id
//	@GeneratedValue(generator = "generator")
//	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@Column(name="age")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
