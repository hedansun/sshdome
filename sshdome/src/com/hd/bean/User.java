package com.hd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author hed
 * Jun 18, 2013
 */
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true,dynamicInsert=true)
@Table(name="t_user")
public class User {
	
	@GenericGenerator(
			name="generator",strategy="sequence",parameters={@Parameter(name="sequence",value="t_user_seq")}
			)
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	@Column(name="email")
	private String email;
	@Column(name="userName")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="age")
	private int age;
	@Column(name="sex")
	private String sex;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
