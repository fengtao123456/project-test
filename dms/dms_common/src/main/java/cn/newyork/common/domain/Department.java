package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private Long id;
    @EasyuiColumn(title = "部门标识")
    private String sn;
    @EasyuiColumn(title = "部门名称")
    private String name;
    @EasyuiColumn(title = "联系电话")
    private String phone;
    @EasyuiColumn(title = "传真")
    private String fax;
  /*  自动生成
/上级部门sn/子部门sn/…*/
    @EasyuiColumn(title = "部门路径")
    private String url;
    @JsonIgnore
    @EasyuiColumn(title = "上级部门")
    private Department parent;
    @EasyuiColumn(title = "部门主管")
    private Employee employee;
    @EasyuiColumn(title = "备注")
    private String descs;
    @EasyuiColumn(title = "状态")
    private Long status;
    @EasyuiColumn(title = "子菜单")
    private List<Department> children = new ArrayList<>();

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
}