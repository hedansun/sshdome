package com.hd.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hed
 * Jul 3, 2013
 */
@Controller
@ParentPackage("default")
public class UploadAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private File uploadFile;
	
	private String uploadFileContentType;
	
	private String uploadFileFileName;
	
	@Action(value="upload",results={@Result(name="success",location="/page/home.jsp"),@Result(name="input",location="/page/home.jsp")})
	public String upload() throws IOException{
		String realPath = ServletActionContext.getServletContext().getRealPath("/uploads");
		File destFile=new File(new File(realPath),uploadFileFileName);
		if(!destFile.getParentFile().exists()){
			destFile.getParentFile().mkdirs(); 
		}
		FileUtils.copyFile(uploadFile, destFile);
		return "success";
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
}
