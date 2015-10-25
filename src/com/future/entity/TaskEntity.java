package com.future.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shuaiqi.xsq, 15/8/30
 */
@Entity
@Table(name = "task", schema = "", catalog = "future")
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
    private String exactword;
    private String service;
    private String city;
    private String lowerlimit;
    private String upperlimit;
    private String taskUrl;
    private String status;
    private Integer isSuceess;
    private String browseTime;
    public TaskEntity() {
		// TODO Auto-generated constructor stub
    	taskTotalCount = 1;
    	taskFinishCount = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "taskTotalCount", nullable=false, columnDefinition="INT default 1")
    public Integer getTaskTotalCount() {
        return taskTotalCount;
    }

    public void setTaskTotalCount(Integer taskTotalCount) {
        this.taskTotalCount = taskTotalCount;
    }

    @Basic
    @Column(name = "taskFinishCount",nullable=false, columnDefinition="INT default 0")
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
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "lowerlimit")
    public String getLowerLimit() {
        return lowerlimit;
    }

    public void setLowerLimit(String lowerlimit) {
        this.lowerlimit = lowerlimit;
    }

    @Basic
    @Column(name = "upperlimit")
    public String getUpperLimit() {
        return upperlimit;
    }

    public void setUpperLimit(String upperlimit) {
        this.upperlimit = upperlimit;
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
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (lowerlimit != null ? !lowerlimit.equals(that.lowerlimit) : that.lowerlimit != null) return false;
        if (upperlimit != null ? !upperlimit.equals(that.upperlimit) : that.upperlimit != null) return false;
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
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (lowerlimit != null ? lowerlimit.hashCode() : 0);
        result = 31 * result + (upperlimit != null ? upperlimit.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (isSuceess != null ? isSuceess.hashCode() : 0);
        result = 31 * result + (browseTime != null ? browseTime.hashCode() : 0);
        return result;
    }
    @Basic
    @Column(name = "exactword")
	public String getExactword() {
		return exactword;
	}

	public void setExactword(String exactword) {
		this.exactword = exactword;
	}
    @Basic
    @Column(name = "service")
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
}
