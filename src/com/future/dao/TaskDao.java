package com.future.dao;

import com.future.entity.TaskEntity;

import java.util.List;

/**
 * @author shuaiqi.xsq, 15/8/29
 */
public interface TaskDao {
    public boolean saveTask(TaskEntity taskEntity);
    public List<TaskEntity> getPublishedTask(String userName);
    public List<TaskEntity> getAllTask();
}