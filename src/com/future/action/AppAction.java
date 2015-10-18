package com.future.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class AppAction extends BaseAction{
	public void requestJson() throws IOException{
		ResponseData data = new ResponseData();
		data.setStatus(1);
		data.setType("json");
		HashMap<String, String> obj = new HashMap<>();
		obj.put("keyword", "���� ���п�");
		obj.put("exactword", "����꺫��a��������a�ֶ̿�");
		obj.put("lowerlimit", "120");
		obj.put("upperlimit", "150");
		obj.put("service", "���˷�");
		obj.put("city", "����");
		data.setObj(obj);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String jsonString = JSON.toJSONString(data);
        out.println(jsonString);
        out.flush();
        out.close();
	}
	public void addTask() throws IOException{
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        
        
	}
}
