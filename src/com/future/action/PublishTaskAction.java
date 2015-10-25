package com.future.action;


import com.alibaba.fastjson.JSON;
import com.future.entity.TaskEntity;
import com.future.service.TaskService;
import com.sun.xml.internal.bind.v2.model.core.ID;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.HashMap;

/**
 * @author shuaiqi.xsq, 15/8/29
 */
public class PublishTaskAction extends BaseAction {
    private static final Logger logger = LoggerFactory.getLogger(PublishTaskAction.class);
    private TaskService taskService;
    
    public String getParam(ResponseData responseData, String param) throws IOException{
    	String reString = request.getParameter(param);
    	if (reString == null){
    		logger.warn("Failed to get " + param);
    		responseData.setErrorMes("no "+param);
    		sendJsonData(responseData);
    	}
    	return reString;
    }
    public int getParamInt(ResponseData responseData, String param) throws IOException{
    	String reString = request.getParameter(param);
    	int reInt = -1;
    	try{
    		reInt = Integer.parseInt(reString);
    	}catch (Exception e) {
    		logger.warn("Failed to get int param "+param);
    		responseData.setErrorMes("no int param "+param);
    		sendJsonData(responseData);
    		return -1;
			// TODO: handle exception
		}
    	return reInt;
    	
    }
	public void addTask() throws IOException{
		ResponseData responseData = new ResponseData();
		String sourceUserName = this.getParam(responseData, "username");
		if (sourceUserName == null){
			return;
		}
		String keyword = this.getParam(responseData, "keyword");
		if (keyword == null){
			return;
		}
		String exactword = this.getParam(responseData, "exactword");
		if (exactword == null){
			return;
		}
		String lowerlimit = this.getParam(responseData, "lowerlimit");
		if (lowerlimit == null){
			return;
		}
		String upperlimit = this.getParam(responseData, "upperlimit");
		if (upperlimit == null){
			return;
		}
		String service = this.getParam(responseData, "service");
		if (service == null){
			return;
		}
		String city = this.getParam(responseData, "city");
		if (city == null){
			return;
		}
		int taskTotalCount = this.getParamInt(responseData, "totalcount");
		if (taskTotalCount < 0)
		{
			return;
		}
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setSourceUserName(sourceUserName);
        taskEntity.setKeyword(keyword);
        taskEntity.setExactword(exactword);
        taskEntity.setLowerLimit(lowerlimit);
        taskEntity.setUpperLimit(upperlimit);
        taskEntity.setService(service);
        taskEntity.setCity(city);
        taskEntity.setTaskTotalCount(taskTotalCount);
        if(!taskService.saveTask(taskEntity))
        {
        	logger.warn("Failed to save task");
        	responseData.setErrorMes("Failed to save task");
        	sendJsonData(responseData);
        	return;
        }
        responseData.setStatus(1);
        responseData.setObj(taskEntity);
		logger.info("Add "+ sourceUserName + " "+ keyword +" "+exactword);
        sendJsonData(responseData);
	}
	public void getTask() throws IOException{ 
		ResponseData responseData = new ResponseData();
		String userName = request.getParameter("username");
		if (userName == null){
			return;
		}
		logger.debug("user name :" + userName);
        TaskEntity taskEntity = taskService.getNextTask(userName);
        if (taskEntity == null){
        	responseData.setErrorMes("no task");
        	sendJsonData(responseData);
        	return;
        }
        responseData.setObj(taskEntity);
        responseData.setStatus(1);
        sendJsonData(responseData);
        return;
	}
	public void finishTask() throws IOException{
		ResponseData responseData = new ResponseData();
		String userName = this.getParam(responseData, "username");
		if (userName == null){
			return;
		}
		int taskId = this.getParamInt(responseData, "taskid");
		if (taskId < 0){
			return;
		}
		int finish = this.getParamInt(responseData, "isfinish");
		if (finish < 0){
			return;
		}
		if (!taskService.finishTask(userName, taskId, finish)){
			logger.warn("Failed to finish task " + "username "+ " taskId "+taskId+" isfinish "+finish); 
			responseData.setErrorMes("Failed to finish");
			sendJsonData(responseData);
			return;
		}
		responseData.setStatus(1);
		sendJsonData(responseData);
		return;
		
	}
	
	
    public String execute() {
        try {
            request.setCharacterEncoding("utf-8");

            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setTaskId(0);
            // TODO
            taskEntity.setSourceUserName("xia");
            taskEntity.setExecutorUserName("");
            taskEntity.setTaskName("no name");
            taskEntity.setTaskPublishTime(new Timestamp(System.currentTimeMillis()));
            taskEntity.setTaskDispatchTime(null);
            taskEntity.setTaskTotalCount(Integer.valueOf(request.getParameter("totalCount")));
            taskEntity.setKeyword(request.getParameter("keyword"));
            taskEntity.setTaskUrl(request.getParameter("url"));
            taskEntity.setStatus("undo");
            taskEntity.setIsSuceess(0);// 0 = false;
            taskEntity.setBrowseTime("2");

            taskService.saveTask(taskEntity);
            logger.info("save entity success:" + taskEntity);
            return SUCCESS;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return ERROR;
        } catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return ERROR;
        }
    }

    // getter and setter
    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

}
