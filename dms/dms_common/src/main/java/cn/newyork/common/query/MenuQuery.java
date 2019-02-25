package cn.newyork.common.query;

import cn.newyork.core.query.BaseQuery;

public class MenuQuery extends BaseQuery {
    private String name;//菜单名字
    private String parent;//父菜单

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
