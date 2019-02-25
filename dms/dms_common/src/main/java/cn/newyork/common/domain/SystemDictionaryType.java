package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;

public class SystemDictionaryType {

    private Long id;
    @EasyuiColumn(title = "字典标识")
    private String sn;
    @EasyuiColumn(title = "类型名称")
    private String name;
    @EasyuiColumn(title = "是否启用")
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

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}