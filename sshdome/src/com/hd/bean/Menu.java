package com.hd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.*;

@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true,dynamicInsert=true)
@Table(name="t_menu")
public class Menu {
	
	@GenericGenerator(
			name="generator",strategy="sequence",parameters={@Parameter(name="sequence",value="t_menu_seq")}
			)
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name="pid")
	private int pid;//父id
	
	@Column(name="menuname")
	private String menuName;//菜单名字
	
	@Column(name="orderof")
	private int orderof;//排序
	
	@Column(name="show")
	private int show;//是否显示
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getOrderof() {
		return orderof;
	}
	public void setOrderof(int orderof) {
		this.orderof = orderof;
	}
	public int getShow() {
		return show;
	}
	public void setShow(int show) {
		this.show = show;
	}
}
