package study.springboot.service;

import study.springboot.model.Employee;

import java.util.Collection;

/**
 * @author dhl
 * @datetime 2021/8/2  17:54
 */
public interface EmployeeService {
    /**
     * 添加员工信息
     * @param employee
     */
    void add(Employee employee);

    /**
     * 查询全部员工信息
     * @return 员工信息的收集类
     */
    Collection<Employee> getEmployees();

    /**
     * 通过id查询员工
     * @param id 员工编号
     * @return 员工
     */
    Employee getEmployeeById(Integer id);

    /**
     * 通过id删除员工
     * @param id 员工编号
     */
    void deleteEmployeeById(Integer id);

}
