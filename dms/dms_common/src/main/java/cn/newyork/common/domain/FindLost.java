package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FindLost {
    @EasyuiColumn(title = "编号")
    private Long id;
    @EasyuiColumn(title = "档案")
    private Archive archive;
    @EasyuiColumn(title = "用户")
    private Employee employee;
    @EasyuiColumn(title = "找回日期")
    private Date finddate;
    @EasyuiColumn(title = "备注")
    private String descs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getFinddate() {
        return finddate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setFinddate(Date finddate) {
        this.finddate = finddate;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs == null ? null : descs.trim();
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}