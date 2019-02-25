package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Upload;
import cn.newyork.common.query.UploadQuery;
import cn.newyork.dms.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private IUploadService uploadService;

    @RequestMapping("/index")
    public String index() {


        return "upload/upload";
    }

    @RequestMapping("/list")
    @ResponseBody//json
    public PageResult<Upload> list(UploadQuery uploadQuery) {

        return uploadService.queryPage(uploadQuery);
    }

    // upload/delete?id
    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            uploadService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // upload/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(Upload upload) {
        if (upload != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (upload.getId() != null) {
                    //修改
                    uploadService.update(upload);
                } else {
                    //添加
                    uploadService.add(upload);
                }
                return new AjaxResult();
            } catch (Exception e) {
                e.printStackTrace();
                return new AjaxResult("操作失败:"+e.getMessage());
            }
        }
        return null;
    }
}
