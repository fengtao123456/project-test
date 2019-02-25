package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.dms.service.ICxfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cxf")
public class CxfController {
    @Autowired
    private ICxfService cxfService;

    @RequestMapping("/index")
    public String index() {
        return "cxf/cxf";
    }

    @RequestMapping("/phone")
    @ResponseBody
    private AjaxResult queryPhoneLocation(String phoneNumber){

        AjaxResult queryResult = null;
        try {
            String s = cxfService.queryPhone(phoneNumber);
            queryResult = new AjaxResult();
            queryResult.setMsg(s);
        } catch (Exception e) {
            e.printStackTrace();
            queryResult = new AjaxResult();
            queryResult.setMsg(e.getMessage());
        }
        return  queryResult;
    }

}
