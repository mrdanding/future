package com.future.service.impl;

import com.future.dao.TaskDao;
import com.future.entity.TaskEntity;
import com.future.service.PublishTaskService;

/**
 * @author shuaiqi.xsq, 15/8/29
 */
public class PublishTaskServiceImpl implements PublishTaskService {
    private TaskDao taskDao;

    @Override
    public void saveTask(TaskEntity taskEntity) {
        
    }

    public TaskDao getTaskDao() {
        return taskDao;
    }

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }
}
