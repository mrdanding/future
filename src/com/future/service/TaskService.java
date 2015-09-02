package com.future.service;

import com.future.entity.TaskEntity;

import java.util.List;

/**
 * @author shuaiqi.xsq, 15/8/29
 */
public interface TaskService {
    public void saveTask(TaskEntity taskEntity);
    public List<TaskEntity> getPublishedTask(String userName);
}
