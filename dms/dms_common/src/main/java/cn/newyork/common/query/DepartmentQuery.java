package cn.newyork.common.query;

import cn.newyork.core.query.BaseQuery;

public class DepartmentQuery extends BaseQuery {




    //准备模糊查询需要的数据
    private String name;
//    描述
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SysresourceQuery{" +
                "name='" + name + '\'' +
                ", url='" + desc + '\'' +
                '}';
    }

}
