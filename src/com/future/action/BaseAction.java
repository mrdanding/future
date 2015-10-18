package com.future.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.serialize.Printer;


public class BaseAction extends ActionSupport implements SessionAware,  
        ServletRequestAware, ServletResponseAware {  
  
    private static final long serialVersionUID = 1L;
    public static String SUCCESS = "success";
    public static String ERROR = "error";
 
    public HttpServletRequest   request;  
    public HttpServletResponse  response;  
    @SuppressWarnings("unchecked")  
    public Map session;  
  
    public void setSession(Map session) {  
        this.session = session;  
    }  
  
    public void setServletRequest(HttpServletRequest request) {  
       this.request = request;  
    }  
  
    public void setServletResponse(HttpServletResponse response) {  
       this.response = response;  
    }
    public void sendJsonData(ResponseData responseData) throws IOException{
        response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	String jsonString = JSON.toJSONString(responseData);
        out.println(jsonString);
        out.flush();
        out.close();
    }
}

