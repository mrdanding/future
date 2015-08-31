package com.future.dao.impl;

import com.future.dao.TaskDao;
import com.future.entity.TaskEntity;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shuaiqi.xsq, 15/8/29
 */
public class TaskDaoImpl extends SuperDao implements TaskDao {
    private final static Logger logger = LoggerFactory.getLogger(TaskDaoImpl.class);


    @Override
    public void saveTask(TaskEntity taskEntity) {
        logger.info("save task:" + taskEntity.toString());

        Configuration cfg = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        sessionFactory = cfg.buildSessionFactory(serviceRegistry);

        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(taskEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error(e.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}