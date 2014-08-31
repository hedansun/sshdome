package com.hd.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hed
 * Jul 2, 2013
 */
@Controller
@ParentPackage("default")
public class DownloadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String fileName;
	
	private String filePath;
	
	@Action(value="download",results={
			@Result(name="success",type="streamx",
					params={"contentType","application/octet-stream",
							"inputName","inputStream",
							"contentDisposition","attachment;filename=${fileName}",
							"bufferSize","4096"})})
	public String downloadFile(){
		return "success";
	}
	
	//获得下载文件的内容，可以直接读入一个物理文件或从数据库中获取内容       
    public InputStream getInputStream() throws Exception {       
        return ServletActionContext.getServletContext().getResourceAsStream(filePath); 
    } 

	public String getFileName() throws UnsupportedEncodingException {
		return new String(fileName.getBytes(), "ISO8859-1"); 
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
