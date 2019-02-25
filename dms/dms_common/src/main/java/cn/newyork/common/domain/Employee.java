package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Employee {
    private Long id;
    @EasyuiColumn(title = "用户名")
    private String username;
    @EasyuiColumn(title = "部门标识")
    private String password;
    @EasyuiColumn(title = "真实姓名")
    private String realname;
    @EasyuiColumn(title = "身份证")
    private String identcard;
    @EasyuiColumn(title = "录入日期")
    private Date inputdate=new Date();
    @EasyuiColumn(title = "电话")
    private String phone;
    @EasyuiColumn(title = "学历")
    private Long educdetailId;
    @EasyuiColumn(title = "地址")
    private String address;
    @EasyuiColumn(title = "性别")
    private Long sexdetailId;
    @EasyuiColumn(title = "生日")
    private Date birthday;
    @EasyuiColumn(title = "描述")
    private String descs;
    @EasyuiColumn(title = "状态")
    private Long status;
    @EasyuiColumn(title = "部门")
    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getIdentcard() {
        return identcard;
    }

    public void setIdentcard(String identcard) {
        this.identcard = identcard == null ? null : identcard.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getInputdate() {
        return inputdate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getEducdetailId() {
        return educdetailId;
    }

    public void setEducdetailId(Long educdetailId) {
        this.educdetailId = educdetailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getSexdetailId() {
        return sexdetailId;
    }

    public void setSexdetailId(Long sexdetailId) {
        this.sexdetailId = sexdetailId;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getBirthday() {
        return birthday;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs == null ? null : descs.trim();
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", identcard='" + identcard + '\'' +
                ", inputdate=" + inputdate +
                ", phone='" + phone + '\'' +
                ", educdetailId=" + educdetailId +
                ", address='" + address + '\'' +
                ", sexdetailId=" + sexdetailId +
                ", birthday=" + birthday +
                ", descs='" + descs + '\'' +
                ", status=" + status +
                ", department=" + department +
                '}';
    }
}