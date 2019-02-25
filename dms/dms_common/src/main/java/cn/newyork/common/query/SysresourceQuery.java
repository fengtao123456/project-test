package cn.newyork.common.query;

import cn.newyork.core.query.BaseQuery;

public class SysresourceQuery extends BaseQuery {
    //准备模糊查询需要的数据
    private String name;//资源名称
    private String url;//资源路径

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SysresourceQuery{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


}
