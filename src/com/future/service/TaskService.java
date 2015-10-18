package com.future.service;

import com.future.entity.TaskEntity;

import java.util.List;

/**
 * @author shuaiqi.xsq, 15/8/29
 */
public interface TaskService {
    public boolean saveTask(TaskEntity taskEntity);
    public List<TaskEntity> getPublishedTask(String userName);
    public TaskEntity getNextTask(String userName);
    public boolean finishTask(String username, int taskId, int isFinish);
}
