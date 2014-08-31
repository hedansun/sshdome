package com.hd.action;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.stereotype.Controller;
import com.hd.service.TFBaseService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hed
 * Jun 8, 2013
 */
@Controller
@ParentPackage("default")
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String email;
	
	@Resource(name="TFBaseServiceImpl") private TFBaseService tFBaseService;
	
	@Action(value = "/user/getUser",results = {
			@Result(name = "success", location = "/page/queryList.jsp")})
	public String getUser() throws Exception {
		return "success";
	}
	
	@Action(value = "/user/destroy")
	public void destroy() throws Exception {
		ServletActionContext.getRequest().getSession().removeAttribute("userEmail");
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
