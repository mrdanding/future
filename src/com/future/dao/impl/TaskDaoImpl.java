package com.future.dao.impl;

import com.future.dao.TaskDao;
import com.future.entity.TaskEntity;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shuaiqi.xsq, 15/8/29
 */
public class TaskDaoImpl extends SuperDao implements TaskDao{
    private final static Logger logger = LoggerFactory.getLogger(TaskDaoImpl.class);


    @Override
    public void saveTask(TaskEntity taskEntity) {
        Session session = sessionFactory.openSession();
        session.save(taskEntity);
    }
}