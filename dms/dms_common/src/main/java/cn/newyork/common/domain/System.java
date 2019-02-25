package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;

public class System {
    @EasyuiColumn(title = "编号")
    private Long id;
    @EasyuiColumn(title = "系统名称")
    private String name;
    @EasyuiColumn(title = "公司名称")
    private String compname;
    @EasyuiColumn(title = "公司电话")
    private String phone;
    @EasyuiColumn(title = "公司传真")
    private String fax;
    @EasyuiColumn(title = "公司地址")
    private String address;
    @EasyuiColumn(title = "公司网址")
    private String url;

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

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname == null ? null : compname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}