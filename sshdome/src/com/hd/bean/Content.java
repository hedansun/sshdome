package com.hd.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true,dynamicInsert=true)
@Table(name="t_content")
public class Content {
	public Content(){}
	@GenericGenerator(
			name="generator",strategy="sequence",parameters={@Parameter(name="sequence",value="t_content_seq")}
			)
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name="menuid")
	private int menuId;
	
	@Column(name="contenttitle")
	private String contentTitle;
	
	@Column(name="contentbody")
	private String contentBody;
	
	@Column(name="userid")
	private int userId;
	
	@Column(name="hits")
	private int hits;
	
	@Column(name="commentnumber")
	private int commentNumber;
	
	@Column(name="datetime")
	private Date dateTime;
	
	@OneToMany(targetEntity=Comment.class,cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@OrderBy(value = "id desc")
	//updatable=false很关键，如果没有它，在级联删除的时候就会报错(反转的问题)
	@JoinColumn(name="contentid",updatable=false)
	private Set<Comment> comments = new HashSet<Comment>();
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getContentTitle() {
		return contentTitle;
	}
	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}
	public String getContentBody() {
		return contentBody;
	}
	public void setContentBody(String contentBody) {
		this.contentBody = contentBody;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
}
