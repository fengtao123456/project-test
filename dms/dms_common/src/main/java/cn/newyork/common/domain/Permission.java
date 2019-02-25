package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;

public class Permission {
    private Long id;
    @EasyuiColumn(title = "标识")
    private String sn;
    @EasyuiColumn(title = "名称")
    private String name;

    private String url;

    @EasyuiColumn(title = "资源路径")
    private Sysresource sysresource;

    public Sysresource getSysresource() {
        return sysresource;
    }

    public void setSysresource(Sysresource sysresource) {
        this.sysresource = sysresource;
    }

    @EasyuiColumn(title = "描述")
    private String descs;
    @EasyuiColumn(title = "状态")
    private Long status;

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

//    public Sysresource getSysresource() {
//        return sysresource;
//    }

//    public void setSysresource(Sysresource sysresource) {
//        this.sysresource = sysresource;
//    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", sysresource=" + sysresource +
                ", descs='" + descs + '\'' +
                ", status=" + status +
                '}';
    }
}