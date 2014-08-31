package com.hd.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true,dynamicInsert=true)
@Table(name="t_comment")
public class Comment {
	public Comment(){};
	@GenericGenerator(
			name="generator",strategy="sequence",parameters={@Parameter(name="sequence",value="t_comment_seq")}
			)
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	@Column(name="userid")
	private int userId;
	@Column(name="contentid")
	private int contentId;
	@Column(name="commentcontent")
	private String commentContent;
	@Column(name="datetime")
	private Date dateTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dataTime) {
		this.dateTime = dataTime;
	}
}
