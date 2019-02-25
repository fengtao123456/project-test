package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SystemDictionaryDetail {
    private Long id;
    @EasyuiColumn(title = "名称")
    private String name;
    @JsonIgnore
    @EasyuiColumn(title = "类别")
    private SystemDictionaryType types;
    @EasyuiColumn(title = "状态")
    private Long status;
    @EasyuiColumn(title = "序号")
    private Long serial;

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

    public SystemDictionaryType getTypes() {
        return types;
    }

    public void setTypes(SystemDictionaryType types) {
        this.types = types;
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
}