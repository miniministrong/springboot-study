package study.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.springboot.dao.EmployeeDAO;
import study.springboot.model.Employee;
import study.springboot.service.EmployeeService;

import java.util.Collection;

/**
 * @author dhl
 * @datetime 2021/8/2  17:57
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Override
    public void add(Employee employee) {
        employeeDAO.add(employee);
    }

    @Override
    public Collection<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeDAO.deleteEmployeeById(id);
    }
}