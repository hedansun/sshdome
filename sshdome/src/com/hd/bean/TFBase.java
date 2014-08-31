package com.hd.bean;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;

/**
 * @author hed
 * Jun 7, 2013
 */
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true,dynamicInsert=true)
@Table(name="t_f_base")
public class TFBase {
	
	@GenericGenerator(
			name ="generator", 
			strategy ="sequence",
			parameters = {@Parameter(name ="sequence",value ="seq_t_f_base")})
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name="typeId")
	private int typeId;
	
	@Column(name="range")
	private String range;
	
	@Column(name="typeValue")
	private String typeValue;
	
	public TFBase() {
		super();
	}
	
	public TFBase(int typeId,String range,String typeValue){
		this.typeId = typeId;
		this.range =range;
		this.typeValue = typeValue;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTypeId() {
		return typeId;
	}
	
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public String getRange() {
		return range;
	}
	
	public void setRange(String range) {
		this.range = range;
	}
	
	public String getTypeValue() {
		return typeValue;
	}
	
	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
}
