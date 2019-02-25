package cn.newyork.dms.mapper;

import cn.newyork.common.domain.Department;
import cn.newyork.common.domain.Sysresource;
import cn.newyork.common.query.DepartmentQuery;
import cn.newyork.common.query.SysresourceQuery;
import cn.newyork.core.mapper.BaseMapper;

import java.util.List;

public interface DepartmentMapper extends BaseMapper<Department> {
    List<Department> findAllChild();
    List<Department> findChildByID(Long id);
    List<Department> selectParent();
//    List<Department> queryLike(DepartmentQuery departmentQuery);

}