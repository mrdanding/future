package com.future.service.impl;

import com.future.dao.TaskDao;
import com.future.entity.TaskEntity;
import com.future.service.TaskService;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author shuaiqi.xsq, 15/8/29
 */
public class TaskServiceImpl implements TaskService {
    private TaskDao taskDao;
    private static ConcurrentLinkedQueue<TaskEntity> taskList = new ConcurrentLinkedQueue<>();
    private static ConcurrentHashMap<Integer, TaskEntity> taskMap = new ConcurrentHashMap<>();

	@Override
    public boolean saveTask(TaskEntity taskEntity) {
    	if(taskDao.saveTask(taskEntity))
        //if (true)
		{
        	taskList.add(taskEntity);
        	taskMap.put(taskEntity.getTaskId(), taskEntity);
        	return true;
        }
    	
        return false;
    }

    @Override
    public List<TaskEntity> getPublishedTask(String userName) {
    	return taskDao.getPublishedTask(userName);
    }
    @Override
    public TaskEntity getNextTask(String userName)
    {
    	TaskEntity taskEntity = taskList.poll();
    	if(taskEntity == null)
    	{
    		return taskEntity;
    	}
    	taskEntity.setExecutorUserName(userName);
    	return taskEntity;
    }
    @Override
    public boolean finishTask(String username, int taskId, int isFinish)
    {
    	TaskEntity taskEntity = taskMap.get(taskId);
    	if(isFinish > 0){
    		taskEntity.setIsSuceess(isFinish);
    	}else{
    		taskList.add(taskEntity);
    	}
    	return true;
    }

    // getter and setter
    public TaskDao getTaskDao() {
        return taskDao;
    }

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }
    public ConcurrentLinkedQueue<TaskEntity> getTaskList() {
		return taskList;
	}

	public void setTaskList(ConcurrentLinkedQueue<TaskEntity> taskList) {
		TaskServiceImpl.taskList = taskList;
	}

	public ConcurrentHashMap<Integer, TaskEntity> getTaskMap() {
		return taskMap;
	}

	public void setTaskMap(ConcurrentHashMap<Integer, TaskEntity> taskMap) {
		TaskServiceImpl.taskMap = taskMap;
	}

}
