package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Systemlog {
    @EasyuiColumn(title = "编号")
    private Long id;
    @EasyuiColumn(title = "日期")
    private Date date;
    @EasyuiColumn(title = "用户")
    private String employee;
    @EasyuiColumn(title = "方法")
    private String function;
    @EasyuiColumn(title = "参数")
    private String params;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getDate() {
        return date;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee == null ? null : employee.trim();
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    @Override
    public String toString() {
        return "Systemlog{" +
                "id=" + id +
                ", date=" + date +
                ", employee='" + employee + '\'' +
                ", function='" + function + '\'' +
                ", params='" + params + '\'' +
                '}';
    }
}