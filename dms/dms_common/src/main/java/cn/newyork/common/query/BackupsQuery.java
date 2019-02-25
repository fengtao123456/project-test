package cn.newyork.common.query;

import cn.newyork.core.query.BaseQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BackupsQuery extends BaseQuery {
    private String filename;
    private Date beginTime;
    private Date endTime;
    private Long employee;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getBeginTime() {
        return beginTime;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getEndTime() {
        return endTime;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getEmployee() {
        return employee;
    }

    public void setEmployee(Long employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "BackupsQuery{" +
                "filename='" + filename + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", employee='" + employee + '\'' +
                '}';
    }
}
