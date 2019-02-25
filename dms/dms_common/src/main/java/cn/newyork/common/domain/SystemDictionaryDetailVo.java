package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;

public class SystemDictionaryDetailVo {
    private Long id;
    @EasyuiColumn(title = "名称")
    private String name;
    @EasyuiColumn(title = "类别")
    private SystemDictionaryType type;
    @EasyuiColumn(title = "状态")
    private Long status;
    @EasyuiColumn(title = "序号")
    private Long serial;
    @EasyuiColumn(title = "字典标识")
    private String sn;

    private String groupBy;

    public SystemDictionaryDetailVo(SystemDictionaryDetail detail, SystemDictionaryType systemDictionaryType) {
        this.id = detail.getId();
        this.name = detail.getName();
        this.status = detail.getStatus();
        this.serial = detail.getSerial();
        this.sn = systemDictionaryType.getSn();
        this.type = systemDictionaryType;
        this.groupBy = systemDictionaryType.getName();
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

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
        this.name = name;
    }

    public SystemDictionaryType getType() {
        return type;
    }

    public void setType(SystemDictionaryType type) {
        this.type = type;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getSerial() {
        return serial;
    }

    public void setSerial(Long serial) {
        this.serial = serial;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}
