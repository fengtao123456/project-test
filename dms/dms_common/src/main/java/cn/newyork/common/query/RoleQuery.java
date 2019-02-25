package cn.newyork.common.query;

import cn.newyork.core.query.BaseQuery;

public class RoleQuery extends BaseQuery {
    //封装模糊查询的数据
    private String name;//角色名称

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
