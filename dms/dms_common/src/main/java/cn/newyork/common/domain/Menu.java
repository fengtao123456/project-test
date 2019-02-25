package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Long id;
    @EasyuiColumn(title = "菜单名")
    private String name;
    @JsonIgnore
    @EasyuiColumn(title = "父菜单")
    private Menu parent;
    @EasyuiColumn(title = "子菜单")
    private List<Menu> children = new ArrayList<>();
    @EasyuiColumn(title = "资源路径")
    private Sysresource sysresource;
    @EasyuiColumn(title = "图片路径")
    private String iconUrl;
    @EasyuiColumn(title = "描述")
    private String descs;
    @EasyuiColumn(title = "状态")
    private Long status;

    /**
     *
     * @return easyui的tree需要的url
     */
    public String getUrl() {
        return sysresource==null?null:sysresource.getUrl();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return name;
    }

    public void setText(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Sysresource getSysresource() {
        return sysresource;
    }

    public void setSysresource(Sysresource sysresource) {
        this.sysresource = sysresource;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //分组
    public Long getParentID() {
        if(parent==null){
            return 0L;
        }
        return parent.getId();
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                ", sysresource=" + sysresource +
                '}';
    }
}