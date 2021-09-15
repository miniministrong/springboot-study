package study.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import study.springboot.model.Department;
import study.springboot.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dhl
 * @datetime 2021/8/2  15:51
 */
@Repository
public class EmployeeDAO {
    // 模拟数据库
    private static Map<Integer, Employee> employees = null;
    // 员工所属的部门

    @Autowired
    private DepartmentDAO departmentDAO;
    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "aa", "aa@gmail.com", 1, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "bb", "bb@gmail.com", 0, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "cc", "cc@gmail.com", 1, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "dd", "dd@gmail.com", 0, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "ee", "ee@gmail.com", 1, new Department(105, "后勤部")));
    }
    // 主键自增
    private static Integer initId = 1006;

    /**
     * 添加员工
     */
    public void add(Employee employee){
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDAO.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    /**
     * 查询全部员工信息
     */
    public Collection<Employee> getEmployees() {
        return employees.values();
    }

    /**
     * 通过id查询员工
     */
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    /**
     * 通过id删除员工
     */
    public void deleteEmployeeById(Integer id){
        employees.remove(id);
    }
}