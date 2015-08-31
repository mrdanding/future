package com.future.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author shuaiqi.xsq, 15/8/30
 */
@Entity
@Table(name = "task", schema = "", catalog = "Future")
public class TaskEntity {
    private int taskId;
    private String sourceUserName;
    private String executorUserName;
    private String taskName;
    private Timestamp taskPublishTime;
    private Timestamp taskDispatchTime;
    private Integer taskTotalCount;
    private Integer taskFinishCount;
    private String keyword;
    private String taskUrl;
    private String shipSource;
    private String priceMin;
    private String priceMax;
    private String status;
    private Integer isSuceess;
    private String browseTime;

    @Id
    @Column(name = "taskId")
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "sourceUserName")
    public String getSourceUserName() {
        return sourceUserName;
    }

    public void setSourceUserName(String sourceUserName) {
        this.sourceUserName = sourceUserName;
    }

    @Basic
    @Column(name = "executorUserName")
    public String getExecutorUserName() {
        return executorUserName;
    }

    public void setExecutorUserName(String executorUserName) {
        this.executorUserName = executorUserName;
    }

    @Basic
    @Column(name = "taskName")
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Basic
    @Column(name = "taskPublishTime")
    public Timestamp getTaskPublishTime() {
        return taskPublishTime;
    }

    public void setTaskPublishTime(Timestamp taskPublishTime) {
        this.taskPublishTime = taskPublishTime;
    }

    @Basic
    @Column(name = "taskDispatchTime")
    public Timestamp getTaskDispatchTime() {
        return taskDispatchTime;
    }

    public void setTaskDispatchTime(Timestamp taskDispatchTime) {
        this.taskDispatchTime = taskDispatchTime;
    }

    @Basic
    @Column(name = "taskTotalCount")
    public Integer getTaskTotalCount() {
        return taskTotalCount;
    }

    public void setTaskTotalCount(Integer taskTotalCount) {
        this.taskTotalCount = taskTotalCount;
    }

    @Basic
    @Column(name = "taskFinishCount")
    public Integer getTaskFinishCount() {
        return taskFinishCount;
    }

    public void setTaskFinishCount(Integer taskFinishCount) {
        this.taskFinishCount = taskFinishCount;
    }

    @Basic
    @Column(name = "keyword")
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Basic
    @Column(name = "taskUrl")
    public String getTaskUrl() {
        return taskUrl;
    }

    public void setTaskUrl(String taskUrl) {
        this.taskUrl = taskUrl;
    }

    @Basic
    @Column(name = "shipSource")
    public String getShipSource() {
        return shipSource;
    }

    public void setShipSource(String shipSource) {
        this.shipSource = shipSource;
    }

    @Basic
    @Column(name = "priceMin")
    public String getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(String priceMin) {
        this.priceMin = priceMin;
    }

    @Basic
    @Column(name = "priceMax")
    public String getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(String priceMax) {
        this.priceMax = priceMax;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "isSuceess")
    public Integer getIsSuceess() {
        return isSuceess;
    }

    public void setIsSuceess(Integer isSuceess) {
        this.isSuceess = isSuceess;
    }

    @Basic
    @Column(name = "browseTime")
    public String getBrowseTime() {
        return browseTime;
    }

    public void setBrowseTime(String browseTime) {
        this.browseTime = browseTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskEntity that = (TaskEntity) o;

        if (taskId != that.taskId) return false;
        if (sourceUserName != null ? !sourceUserName.equals(that.sourceUserName) : that.sourceUserName != null)
            return false;
        if (executorUserName != null ? !executorUserName.equals(that.executorUserName) : that.executorUserName != null)
            return false;
        if (taskName != null ? !taskName.equals(that.taskName) : that.taskName != null) return false;
        if (taskPublishTime != null ? !taskPublishTime.equals(that.taskPublishTime) : that.taskPublishTime != null)
            return false;
        if (taskDispatchTime != null ? !taskDispatchTime.equals(that.taskDispatchTime) : that.taskDispatchTime != null)
            return false;
        if (taskTotalCount != null ? !taskTotalCount.equals(that.taskTotalCount) : that.taskTotalCount != null)
            return false;
        if (taskFinishCount != null ? !taskFinishCount.equals(that.taskFinishCount) : that.taskFinishCount != null)
            return false;
        if (keyword != null ? !keyword.equals(that.keyword) : that.keyword != null) return false;
        if (taskUrl != null ? !taskUrl.equals(that.taskUrl) : that.taskUrl != null) return false;
        if (shipSource != null ? !shipSource.equals(that.shipSource) : that.shipSource != null) return false;
        if (priceMin != null ? !priceMin.equals(that.priceMin) : that.priceMin != null) return false;
        if (priceMax != null ? !priceMax.equals(that.priceMax) : that.priceMax != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (isSuceess != null ? !isSuceess.equals(that.isSuceess) : that.isSuceess != null) return false;
        if (browseTime != null ? !browseTime.equals(that.browseTime) : that.browseTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskId;
        result = 31 * result + (sourceUserName != null ? sourceUserName.hashCode() : 0);
        result = 31 * result + (executorUserName != null ? executorUserName.hashCode() : 0);
        result = 31 * result + (taskName != null ? taskName.hashCode() : 0);
        result = 31 * result + (taskPublishTime != null ? taskPublishTime.hashCode() : 0);
        result = 31 * result + (taskDispatchTime != null ? taskDispatchTime.hashCode() : 0);
        result = 31 * result + (taskTotalCount != null ? taskTotalCount.hashCode() : 0);
        result = 31 * result + (taskFinishCount != null ? taskFinishCount.hashCode() : 0);
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + (taskUrl != null ? taskUrl.hashCode() : 0);
        result = 31 * result + (shipSource != null ? shipSource.hashCode() : 0);
        result = 31 * result + (priceMin != null ? priceMin.hashCode() : 0);
        result = 31 * result + (priceMax != null ? priceMax.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (isSuceess != null ? isSuceess.hashCode() : 0);
        result = 31 * result + (browseTime != null ? browseTime.hashCode() : 0);
        return result;
    }
}
