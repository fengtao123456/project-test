package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;

import java.util.Date;

public class Upload {
    private Long id;
    @EasyuiColumn(title = "附件编号")
    private String attachment;
    @EasyuiColumn(title = "附件类型")
    private Long attachmenttypesId;
    @EasyuiColumn(title = "附件文件保存路径")
    private String attachmenturl;
    @EasyuiColumn(title = "备注信息")
    private String sn;
    @EasyuiColumn(title = "所属档案编号")
    private Long archivesId;
    @EasyuiColumn(title = "上传时间")
    private Date uploadtime;
    @EasyuiColumn(title = "文件大小")
    private Long filesize;
    @EasyuiColumn(title = "上传用户")
    private String uploademployeeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public Long getAttachmenttypesId() {
        return attachmenttypesId;
    }

    public void setAttachmenttypesId(Long attachmenttypesId) {
        this.attachmenttypesId = attachmenttypesId;
    }

    public String getAttachmenturl() {
        return attachmenturl;
    }

    public void setAttachmenturl(String attachmenturl) {
        this.attachmenturl = attachmenturl == null ? null : attachmenturl.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public Long getArchivesId() {
        return archivesId;
    }

    public void setArchivesId(Long archivesId) {
        this.archivesId = archivesId;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public Long getFilesize() {
        return filesize;
    }

    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    public String getUploademployeeId() {
        return uploademployeeId;
    }

    public void setUploademployeeId(String uploademployeeId) {
        this.uploademployeeId = uploademployeeId == null ? null : uploademployeeId.trim();
    }
}