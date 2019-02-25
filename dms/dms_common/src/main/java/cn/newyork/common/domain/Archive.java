package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;

import java.util.Date;

public class Archive {
    private Long id;//档案id
    @EasyuiColumn(title = "档案编号")
    private String sn;
    @EasyuiColumn(title = "档案类型")
    private Long doctypemanageId;
    @EasyuiColumn(title = "档案存档点")
    private Long docpositionsId;
    @EasyuiColumn(title = "档案标题")
    private String title;
    @EasyuiColumn(title = "建档用户")
    private Long employeeId;
    @EasyuiColumn(title = "建档日期")
    private Date inputtime;
    @EasyuiColumn(title = "修改用户")
    private String updateuser;
    @EasyuiColumn(title = "修改日期")
    private Date updatedate;
    @EasyuiColumn(title = "借阅状态")
    private Long statusId;
    @EasyuiColumn(title = "过期时间")
    private Date expirationdate;
    @EasyuiColumn(title = "过期是否提前通知")
    private Long expirationnotice;
    @EasyuiColumn(title = "提前通知的天数")
    private Long noticedays;
    @EasyuiColumn(title = "档案内容")
    private String content;
    @EasyuiColumn(title = "内容简介")
    private String intro;
    @EasyuiColumn(title = "是否常用")
    private Long manyuser;
    @EasyuiColumn(title = "文件编号")
    private String documentsn;
    @EasyuiColumn(title = "发文部门")
    private Long comefromdepartmentId;
    @EasyuiColumn(title = "发文单位")
    private Long comefromunitId;
    @EasyuiColumn(title = "发文人")
    private String postman;
    @EasyuiColumn(title = "批准时间")
    private Date approvaltime;
    @EasyuiColumn(title = "鉴定时间")
    private Date identificationtime;
    @EasyuiColumn(title = "产品批号")
    private String productid;
    @EasyuiColumn(title = "原料批号")
    private String materialid;
    @EasyuiColumn(title = "数量")
    private Long number;
    @EasyuiColumn(title = "页数")
    private Long page;
    @EasyuiColumn(title = "专利号")
    private String patentnumber;
    @EasyuiColumn(title = "年检负责人")
    private String inspector;
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

    public Long getDoctypemanageId() {
        return doctypemanageId;
    }

    public void setDoctypemanageId(Long doctypemanageId) {
        this.doctypemanageId = doctypemanageId;
    }

    public Long getDocpositionsId() {
        return docpositionsId;
    }

    public void setDocpositionsId(Long docpositionsId) {
        this.docpositionsId = docpositionsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Date getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(Date expirationdate) {
        this.expirationdate = expirationdate;
    }

    public Long getExpirationnotice() {
        return expirationnotice;
    }

    public void setExpirationnotice(Long expirationnotice) {
        this.expirationnotice = expirationnotice;
    }

    public Long getNoticedays() {
        return noticedays;
    }

    public void setNoticedays(Long noticedays) {
        this.noticedays = noticedays;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Long getManyuser() {
        return manyuser;
    }

    public void setManyuser(Long manyuser) {
        this.manyuser = manyuser;
    }

    public String getDocumentsn() {
        return documentsn;
    }

    public void setDocumentsn(String documentsn) {
        this.documentsn = documentsn == null ? null : documentsn.trim();
    }

    public Long getComefromdepartmentId() {
        return comefromdepartmentId;
    }

    public void setComefromdepartmentId(Long comefromdepartmentId) {
        this.comefromdepartmentId = comefromdepartmentId;
    }

    public Long getComefromunitId() {
        return comefromunitId;
    }

    public void setComefromunitId(Long comefromunitId) {
        this.comefromunitId = comefromunitId;
    }

    public String getPostman() {
        return postman;
    }

    public void setPostman(String postman) {
        this.postman = postman == null ? null : postman.trim();
    }

    public Date getApprovaltime() {
        return approvaltime;
    }

    public void setApprovaltime(Date approvaltime) {
        this.approvaltime = approvaltime;
    }

    public Date getIdentificationtime() {
        return identificationtime;
    }

    public void setIdentificationtime(Date identificationtime) {
        this.identificationtime = identificationtime;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    public String getMaterialid() {
        return materialid;
    }

    public void setMaterialid(String materialid) {
        this.materialid = materialid == null ? null : materialid.trim();
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public String getPatentnumber() {
        return patentnumber;
    }

    public void setPatentnumber(String patentnumber) {
        this.patentnumber = patentnumber == null ? null : patentnumber.trim();
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector == null ? null : inspector.trim();
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}