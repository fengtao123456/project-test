package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FileExpirationManagement {
    @EasyuiColumn(title = "编号")
    private Long id;
    @EasyuiColumn(title = "档案")
    private Archive archive;
    @EasyuiColumn(title = "用户")
    private Employee employee;
    @EasyuiColumn(title = "销毁日期")
    private Date destorydate;
    @EasyuiColumn(title = "销毁原因")
    private SystemDictionaryDetail destory;
    @EasyuiColumn(title = "备注")
    private String descs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getDestorydate() {
        return destorydate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setDestorydate(Date destorydate) {
        this.destorydate = destorydate;
    }

    public SystemDictionaryDetail getDestory() {
        return destory;
    }

    public void setDestory(SystemDictionaryDetail destory) {
        this.destory = destory;
    }
}