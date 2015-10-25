package com.future.service.impl;

import com.future.dao.TaskDao;
import com.future.entity.TaskEntity;
import com.future.service.TaskService;

import sun.misc.Unsafe;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author shuaiqi.xsq, 15/8/29
 */
public class TaskServiceImpl implements TaskService, InitializingBean{
    private TaskDao taskDao;    
    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
    private static ConcurrentLinkedQueue<TaskEntity> taskList = new ConcurrentLinkedQueue<>();
    private static ConcurrentHashMap<Integer, TaskEntity> taskMap = new ConcurrentHashMap<>();
    private static AtomicBoolean isInited = new AtomicBoolean(false);
    private static ConcurrentSkipListSet<TaskEntity> finishSet = new ConcurrentSkipListSet<>();
    private static ConcurrentHashMap<Integer, AtomicInteger> dispatchMap = new ConcurrentHashMap<>();
    @Override
    public boolean loadData(){
    	if (isInited.get()){
    		return true;
    	}
    	isInited.set(true);
    	logger.debug("load task data");
    	List<TaskEntity> tasks = taskDao.getAllTask();
    	taskList.addAll(tasks);
    	for (TaskEntity taskEntity : tasks){
    		taskMap.put(taskEntity.getTaskId(), taskEntity);
    		dispatchMap.put(taskEntity.getTaskId(), new AtomicInteger(taskEntity.getTaskFinishCount()));
    	}
    	return true;
    }
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
    	if(!dispatchMap.containsKey(taskEntity.getTaskId())){
    		dispatchMap.put(taskEntity.getTaskId(), new AtomicInteger(0));
    	}
    	AtomicInteger dispachTimes = dispatchMap.get(taskEntity.getTaskId());
    	if (dispachTimes.incrementAndGet() < taskEntity.getTaskTotalCount()){
    		taskList.offer(taskEntity);
    	}
    	taskEntity.setExecutorUserName(userName);
    	return taskEntity;
    }
    @Override
    public boolean finishTask(String username, int taskId, int isFinish)
    {
    	TaskEntity taskEntity = taskMap.get(taskId);
    	if(isFinish > 0){
    		synchronized (taskEntity) {
    			taskEntity.setTaskFinishCount(taskEntity.getTaskFinishCount()+1);
    			//taskEntity.setIsSuceess(isFinish);
        		if(!taskDao.saveTask(taskEntity))
        		{
        			return false; 
        		}
			}
    	}else{
    		AtomicInteger dispatchTimes = dispatchMap.get(taskId);
    		if(dispatchTimes.decrementAndGet() == taskEntity.getTaskTotalCount() -1){
    			taskList.offer(taskEntity);
    		}
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
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		loadData();
	}

}
