package study.springboot.service;

import study.springboot.model.Department;

import java.util.Collection;

/**
 * @author dhl
 * @datetime 2021/8/2  17:59
 */
public interface DepartmentService {
    /**
     * 获得所有部门信息
     * @return 部门的收集类
     */
    Collection<Department> getDepartments();

    /**
     * 通过id查询部门
     * @param id 部门编号
     * @return 部门
     */
    Department getDepartmentById(Integer id);
}
