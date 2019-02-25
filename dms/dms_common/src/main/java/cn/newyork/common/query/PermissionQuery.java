package cn.newyork.common.query;

import cn.newyork.core.query.BaseQuery;

public class PermissionQuery extends BaseQuery {
    private String name;//权限名称
    private String status;//权限状态

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
