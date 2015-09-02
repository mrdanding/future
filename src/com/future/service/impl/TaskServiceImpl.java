package com.future.service.impl;

import com.future.dao.TaskDao;
import com.future.entity.TaskEntity;
import com.future.service.TaskService;

import java.util.List;

/**
 * @author shuaiqi.xsq, 15/8/29
 */
public class TaskServiceImpl implements TaskService {
    private TaskDao taskDao;

    @Override
    public void saveTask(TaskEntity taskEntity) {
        taskDao.saveTask(taskEntity);
    }

    @Override
    public List<TaskEntity> getPublishedTask(String userName) {
        return taskDao.getPublishedTask(userName);
    }

    // getter and setter
    public TaskDao getTaskDao() {
        return taskDao;
    }

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }
}
