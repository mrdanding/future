package com.future.dao.impl;

import com.future.dao.TaskDao;
import com.future.entity.TaskEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author shuaiqi.xsq, 15/8/29
 */
public class TaskDaoImpl implements TaskDao {
    private final static Logger logger = LoggerFactory.getLogger(TaskDaoImpl.class);


    @Override
    public boolean saveTask(TaskEntity taskEntity) {
        logger.info("save task:" + taskEntity.toString());

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        boolean is_suc = false;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(taskEntity);
            session.getTransaction().commit();
            is_suc = true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            if (session != null) {
                session.getTransaction().rollback();
            }
            is_suc = false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return is_suc;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<TaskEntity> getPublishedTask(String userName) {
        logger.info("get task and the userName is :" + userName);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.openSession();

            String hql = "from TaskEntity where sourceUserName ='" + userName + "'";
            Query query = session.createQuery(hql);

            if (query.list() != null){
                logger.info(userName + "'s task size: " + query.list().size());
                return ((List<TaskEntity>) query.list());
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        logger.info(userName + " does not have published tasks");
        return null;
    }

//    @Override
//    public List<TaskEntity> getPublishedTask(String userName) {
//        logger.info("get task and the userName is :" + userName);
//
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//
//        Session session = null;
//        try {
//            session = sessionFactory.openSession();
//
//            int pageNo = 1; // 当前页数
//            int pageSize = 10; // 每页显示条数
//
//            String hql = "from TaskEntity where sourceUserName =" + userName;
//            Query query = session.createQuery(hql);
//            query.setFirstResult((pageNo - 1) * pageSize);
//            query.setMaxResults(pageSize);
//            query.setCacheable(true); // 设置缓存
//
//            if (query.list() != null){
//                return ((List<TaskEntity>) query.list());
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//
//        return null;
//    }
}