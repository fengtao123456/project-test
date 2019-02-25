package cn.newyork.common.domain;

import cn.newyork.base.utils.EasyuiColumn;

public class BorrowToReurn {
    @EasyuiColumn(title = "编号")
    private Long id;
    @EasyuiColumn(title = "档案编号")
    private Long archiveId;
    @EasyuiColumn(title = "借阅编号")
    private Long borrowId;
    @EasyuiColumn(title = "归还编号")
    private Long returnId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Long archiveId) {
        this.archiveId = archiveId;
    }

    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }
}