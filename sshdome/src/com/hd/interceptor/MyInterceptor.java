package com.hd.interceptor;

import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import com.hd.action.LoginAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author hed
 * Jun 25, 2013
 */
public class MyInterceptor implements Interceptor {

	public void destroy() {

	}

	public void init() {
	
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		Object action = arg0.getAction();  
        if (action instanceof LoginAction) {  
            return arg0.invoke();  
        }
        //验证 session  
        String userName=ServletActionContext.getRequest().getSession().getAttribute("name")+"";
        // 获取此请求的地址，请求地址包含application name，进行subString操作，去除application name
        if (!"null".equals(userName)) {  
            // 存在的情况下进行后续操作。  
            return arg0.invoke();  
        } else {  
            String nameSpace=arg0.getProxy().getNamespace();
            String actionName=arg0.getProxy().getActionName();
        	//String backUrl=actionName+"?";
            String backUrl=actionName;
        	//StringBuffer backUrl = ServletActionContext.getRequest().getRequestURL().append("?");  
            // 获得请求中的参数
            Map<String,String[]> map = ServletActionContext.getRequest().getParameterMap();  
//            if(map!=null){  
//    			for(String s:map.keySet()){  
//    				String[] value=map.get(s);  
//    				for(String val:value){  
//    						backUrl=backUrl+s+"="+val+"&";  
//    						//backUrl=backUrl.append(s).append("=").append(val);  
//    				}  
//    			}  
//            }
            ServletActionContext.getRequest().getSession().setAttribute("backUrl", backUrl);
            // 否则终止后续操作，返回LOGIN  
        	return "backLogin";
        }
	}

}
