import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Sysresource;
import cn.newyork.common.query.SysresourceQuery;
import cn.newyork.dms.service.ISysresourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class test {
    @Autowired
    private ISysresourceService sysresourceService;
    @Test
    public void testLiseQuery() throws Exception{
        SysresourceQuery sysresourceQuery = new SysresourceQuery();
        PageResult<Sysresource> sysresourcePageResult = sysresourceService.likeQuery1(sysresourceQuery);
        List<Sysresource> rows = sysresourcePageResult.getRows();
        for (Sysresource row : rows) {
            System.out.println(row);
        }


    }
}
