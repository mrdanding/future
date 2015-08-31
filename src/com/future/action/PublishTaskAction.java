package com.future.action;


import com.future.entity.TaskEntity;
import com.future.service.PublishTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

/**
 * @author shuaiqi.xsq, 15/8/29
 */
public class PublishTaskAction extends BaseAction {
    private static final Logger logger = LoggerFactory.getLogger(PublishTaskAction.class);
    private PublishTaskService publishTaskService;

    public String execute() {
        try {
            request.setCharacterEncoding("utf-8");

            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setTaskId(0);
            // TODO
            taskEntity.setSourceUserName("xia");
            taskEntity.setExecutorUserName("");
            taskEntity.setTaskName("no name");
            taskEntity.setTaskPublishTime(new Timestamp(System.currentTimeMillis()));
            taskEntity.setTaskDispatchTime(null);
            taskEntity.setTaskTotalCount(Integer.valueOf(request.getParameter("totalCount")));
            taskEntity.setTaskFinishCount(0);
            taskEntity.setKeyword(request.getParameter("keyword"));
            taskEntity.setTaskUrl(request.getParameter("url"));
            taskEntity.setShipSource(request.getParameter("shipSource"));
            taskEntity.setPriceMin(request.getParameter("priceMin"));
            taskEntity.setPriceMax(request.getParameter("priceMax"));
            taskEntity.setStatus("undo");
            taskEntity.setIsSuceess(0);// 0 = false;
            taskEntity.setBrowseTime("2");

            publishTaskService.saveTask(taskEntity);
            logger.info("save entity success:" + taskEntity);
            return SUCCESS;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return ERROR;
        } catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return ERROR;
        }
    }

    // getter and setter
    public PublishTaskService getPublishTaskService() {
        return publishTaskService;
    }

    public void setPublishTaskService(PublishTaskService publishTaskService) {
        this.publishTaskService = publishTaskService;
    }

}
