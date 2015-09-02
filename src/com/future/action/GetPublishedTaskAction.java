package com.future.action;

import com.future.entity.TaskEntity;
import com.future.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author shuaiqi.xsq, 15/9/1
 */
public class GetPublishedTaskAction extends BaseAction {
    private static final Logger logger = LoggerFactory.getLogger(GetPublishedTaskAction.class);
    private TaskService taskService;
    private List<TaskEntity> taskEntityList;

    public String execute(){
        String userName = (String) request.getSession().getAttribute("userName");
        logger.info("get userName's task:" + userName);

        if (userName == null || userName.equals("")){
            taskEntityList = null;
        } else {
            taskEntityList = taskService.getPublishedTask(userName);
        }

        return SUCCESS;
    }

    // getter and setter
    public List<TaskEntity> getTaskEntityList() {
        return taskEntityList;
    }

    public void setTaskEntityList(List<TaskEntity> taskEntityList) {
        this.taskEntityList = taskEntityList;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
}
