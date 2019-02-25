package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;

public class Password {
    @EasyuiColumn(title = "用户编号")
    private Long id;
    @EasyuiColumn(title = "用户名称")
    private String name;
    @EasyuiColumn(title = "用户密码")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}