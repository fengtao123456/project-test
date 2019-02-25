package cn.newyork.dms.service.impl;import cn.newyork.base.utils.LuceneUtil;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Employee;
import cn.newyork.common.domain.Systemlog;
import cn.newyork.common.query.SystemlogQuery;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.query.BaseQuery;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.SystemlogMapper;
import cn.newyork.dms.service.ISystemlogService;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class SystemlogServiceImpl extends BaseServiceImpl<Systemlog> implements ISystemlogService {
    private final String ID = "id";
    private final String DATE = "date";
    private final String EMPLOYEE = "employee";
    private final String FUNCTION = "function";
    private final String PARAMS = "params";
    @Autowired
    private SystemlogMapper systemlogMapper;

    @Override
    protected BaseMapper<Systemlog> getMapper() {
        return systemlogMapper;
    }

    @Override
    public void updateIndex() {
        //查询数据库的日志
        List<Systemlog> logList = systemlogMapper.selectAll();
        //写索引:数据库的每一行数据就是一个document
        for (Systemlog systemlog : logList) {
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Document document = new Document();
            //给document添加字段:就是数据库的列
            document.add(new TextField(ID,String.valueOf(systemlog.getId()), Field.Store.YES));
            document.add(new TextField(DATE,String.valueOf(systemlog.getDate()), Field.Store.YES));
            document.add(new TextField(EMPLOYEE,String.valueOf(systemlog.getEmployee()), Field.Store.YES));
            document.add(new TextField(FUNCTION,String.valueOf(systemlog.getFunction()), Field.Store.YES));
            document.add(new TextField(PARAMS,String.valueOf(systemlog.getParams()), Field.Store.YES));
            LuceneUtil.addIndex(document);
        }
        //关闭资源
        LuceneUtil.closeAll();

    }

    //复写默认的方法,改到查询索引
    public PageResult<Systemlog> queryLog(SystemlogQuery query) {
        //返回对象
        PageResult<Systemlog> pageList= new PageResult<>();
        //从索引中查询查询分页的数据和条数,设置到pageList
        // String[] field,String queryStr
        String[] fields = {"function"};//查询索引中的哪些字段
        String q = query.getQ();//前台的查询条件
        //设置条数
        pageList.setTotal(LuceneUtil.totalHits(fields, q));

        //命中的document
        List<Document> hitDocuments = LuceneUtil.getHitDocuments(fields, q, query.getPage(), query.getRows());
        List<Systemlog> logList = new ArrayList<>();
        for (Document hitDocument : hitDocuments) {
            // 每一个Document对象要转换成一个Systemlog
            Systemlog log=new Systemlog();
            String id = hitDocument.get(ID);
            log.setId(Long.valueOf(id));

            log.setFunction(hitDocument.get(FUNCTION));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
            try {
                log.setDate(simpleDateFormat.parse(hitDocument.get(DATE)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            log.setEmployee(hitDocument.get(EMPLOYEE));
            log.setParams(hitDocument.get(PARAMS));
            logList.add(log);
        }
        //封装查询结果
        pageList.setRows(logList);
        return pageList;
    }
//  事务测试
// @Transactional
//    @Override
//    public void add(Systemlog systemlog) {
//        System.out.println("come on");
//        systemlogMapper.save(systemlog);
//        int i=1/0;
//    }
}
