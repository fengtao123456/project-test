package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private Long id;
    @EasyuiColumn(title = "标识")
    private String sn;
    @EasyuiColumn(title = "名称")
    private String name;
    @EasyuiColumn(title = "描述")
    private String descs;
    @EasyuiColumn(title = "状态")
    private Long status;
    //关联的权限
    private List<Permission> permissionList =new ArrayList<>();

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

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", descs='" + descs + '\'' +
                ", status=" + status +
                ", permissionList=" + permissionList +
                '}';
    }
}