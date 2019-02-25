package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;

public class Sysresource {
    private Long id;
    @EasyuiColumn(title = "资源名称")
    private String name;
    @EasyuiColumn(title = "资源路径")
    private String url;
    @EasyuiColumn(title = "描述")
    private String descs;
    @EasyuiColumn(title = "资源使用状态")
    private Long status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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

    @Override
    public String toString() {
        return "Sysresource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", descs='" + descs + '\'' +
                ", status=" + status +
                '}';
    }
}