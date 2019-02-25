package cn.newyork.dms.service.impl;

import cn.newyork.common.domain.Department;
import cn.newyork.common.query.DepartmentQuery;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.DepartmentMapper;
import cn.newyork.dms.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements IDepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void add(Department t) {
        Department parent = departmentMapper.selectByPrimaryKey(t.getParent().getId());
        if (parent == null) {
            t.setUrl(t.getSn());
        }
        t.setUrl(parent.getSn() + "/" + t.getSn());
        departmentMapper.insert(t);
    }

    @Override
    public void update(Department t) {
        Department parent = departmentMapper.selectByPrimaryKey(t.getParent().getId());
        if (parent == null) {
            t.setUrl(t.getSn());
        }
        t.setUrl(parent.getSn() + "/" + t.getSn());
        departmentMapper.updateByPrimaryKey(t);
    }

    @Override
    protected BaseMapper<Department> getMapper() {
        return departmentMapper;
    }

    //    返回到前台的数据
    @Override
    public List<Department> findGroup() {
//        List<Department> list = departmentMapper.selectParent();
//        for (Department department : list) {
//            if (department.getParent() != null) {
//                department.getParent().getChildren().add(department);
//            }
//        }
        List<Department> departments = departmentMapper.selectParent();
        if (departments.size() != 0) {
            getGroup(departments);
        }
        return departments;
    }

    @Override
    public List<Department> findGroup(DepartmentQuery departmentQuery) {
//        List<Department> parents = new ArrayList<>();
//        List<Department> departments = departmentMapper.queryLike(departmentQuery);
//        for (Department department : departments) {
//            Department parent = department.getParent();
//            if(parent==null&&!parents.contains(department)){
//                parents.add(department);
//            }
//        }

        return null;
    }

    //    迭代产生多级分组
    private List<Department> getGroup(List<Department> list) {
        for (Department department : list) {
            List<Department> childByID = departmentMapper.findChildByID(department.getId());
            department.getChildren().addAll(childByID);
            if (childByID.size() != 0) {
                getGroup(childByID);
            }
        }
        return list;
    }

}
   

//  事务测试
// @Transactional
//    @Override
//    public void add(Department department) {
//        System.out.println("come on");
//        departmentMapper.save(department);
//        int i=1/0;
//    }

