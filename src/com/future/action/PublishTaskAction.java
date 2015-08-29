package com.future.action;


import com.future.service.PublishTaskService;

/**
 * @author shuaiqi.xsq, 15/8/29
 */
public class PublishTaskAction extends BaseAction {
    public PublishTaskService getPublishTaskService() {
        return publishTaskService;
    }

    public void setPublishTaskService(PublishTaskService publishTaskService) {
        this.publishTaskService = publishTaskService;
    }

    private PublishTaskService publishTaskService;

    

}
