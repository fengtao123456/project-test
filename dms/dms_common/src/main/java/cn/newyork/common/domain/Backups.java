package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Backups {
    @EasyuiColumn(title = "编号")
    private Long id;
    @EasyuiColumn(title = "文件名")
    private String filename;

    @EasyuiColumn(title = "路径")
    private String url;

    @EasyuiColumn(title = "用户")
    private Employee employee;

    @EasyuiColumn(title = "日期")
    private Date date;

    @EasyuiColumn(title = "大小")
    private Long filesize;

    @EasyuiColumn(title = "备注")
    private String sn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getDate() {

        return date;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setDate(Date date) {
        this.date = date;
    }

    public Long getFilesize() {
        return filesize;
    }

    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    @Override
    public String toString() {
        return "Backups{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", url='" + url + '\'' +
                ", employee=" + employee +
                ", date=" + date +
                ", filesize=" + filesize +
                ", sn='" + sn + '\'' +
                '}';
    }
}