package cn.newyork.common.query;

import cn.newyork.core.query.BaseQuery;

public class SystemDictionaryDetailQuery extends BaseQuery {
    //封装模糊查询需要的字段【字典标识与类型】
    private String name;//字典标识
    private String types;//字典类型

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }
}
