package com.future.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author shuaiqi.xsq, 15/8/27
 */
@Entity
@Table(name = "user", schema = "", catalog = "Future")
public class UserEntity {
    private String userName;
    private String mobileNumber;
    private String email;
    private Integer currentCredit;
    private Integer totalBoughtCredit;
    private Integer totalConsumedCredit;
    private Timestamp registerTime;
    private Integer todayWorkload;
    private Integer yesterdayWorkload;

    @Id
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "mobileNumber")
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "currentCredit")
    public Integer getCurrentCredit() {
        return currentCredit;
    }

    public void setCurrentCredit(Integer currentCredit) {
        this.currentCredit = currentCredit;
    }

    @Basic
    @Column(name = "totalBoughtCredit")
    public Integer getTotalBoughtCredit() {
        return totalBoughtCredit;
    }

    public void setTotalBoughtCredit(Integer totalBoughtCredit) {
        this.totalBoughtCredit = totalBoughtCredit;
    }

    @Basic
    @Column(name = "totalConsumedCredit")
    public Integer getTotalConsumedCredit() {
        return totalConsumedCredit;
    }

    public void setTotalConsumedCredit(Integer totalConsumedCredit) {
        this.totalConsumedCredit = totalConsumedCredit;
    }

    @Basic
    @Column(name = "registerTime")
    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    @Basic
    @Column(name = "todayWorkload")
    public Integer getTodayWorkload() {
        return todayWorkload;
    }

    public void setTodayWorkload(Integer todayWorkload) {
        this.todayWorkload = todayWorkload;
    }

    @Basic
    @Column(name = "yesterdayWorkload")
    public Integer getYesterdayWorkload() {
        return yesterdayWorkload;
    }

    public void setYesterdayWorkload(Integer yesterdayWorkload) {
        this.yesterdayWorkload = yesterdayWorkload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (mobileNumber != null ? !mobileNumber.equals(that.mobileNumber) : that.mobileNumber != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (currentCredit != null ? !currentCredit.equals(that.currentCredit) : that.currentCredit != null)
            return false;
        if (totalBoughtCredit != null ? !totalBoughtCredit.equals(that.totalBoughtCredit) : that.totalBoughtCredit != null)
            return false;
        if (totalConsumedCredit != null ? !totalConsumedCredit.equals(that.totalConsumedCredit) : that.totalConsumedCredit != null)
            return false;
        if (registerTime != null ? !registerTime.equals(that.registerTime) : that.registerTime != null) return false;
        if (todayWorkload != null ? !todayWorkload.equals(that.todayWorkload) : that.todayWorkload != null)
            return false;
        if (yesterdayWorkload != null ? !yesterdayWorkload.equals(that.yesterdayWorkload) : that.yesterdayWorkload != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (currentCredit != null ? currentCredit.hashCode() : 0);
        result = 31 * result + (totalBoughtCredit != null ? totalBoughtCredit.hashCode() : 0);
        result = 31 * result + (totalConsumedCredit != null ? totalConsumedCredit.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        result = 31 * result + (todayWorkload != null ? todayWorkload.hashCode() : 0);
        result = 31 * result + (yesterdayWorkload != null ? yesterdayWorkload.hashCode() : 0);
        return result;
    }
}
