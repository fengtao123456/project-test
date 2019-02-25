package cn.newyork.dms.service.impl;

import cn.newyork.cxf.phone.MobileCodeWSSoap;
import cn.newyork.dms.service.ICxfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CxfServiceImpl implements ICxfService {

    @Autowired
    private MobileCodeWSSoap mobileCodeWSSoap;

    @Override
    public String queryPhone(String phoneNumber) {
        return mobileCodeWSSoap.getMobileCodeInfo(phoneNumber, "");
    }
}
