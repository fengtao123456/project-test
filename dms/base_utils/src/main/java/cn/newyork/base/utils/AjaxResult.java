package cn.newyork.base.utils;
//前台ajax返回数据的类
public class AjaxResult {
    private Boolean success=true;
    private String msg="操作成功";

    public AjaxResult() {
    }

    public AjaxResult(String msg) {
        this.msg = msg;
       this.success=false;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
