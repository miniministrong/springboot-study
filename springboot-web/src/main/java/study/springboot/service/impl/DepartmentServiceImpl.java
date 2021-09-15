package study.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.springboot.dao.DepartmentDAO;
import study.springboot.model.Department;
import study.springboot.service.DepartmentService;

import java.util.Collection;

/**
 * @author dhl
 * @datetime 2021/8/2  18:00
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDAO departmentDAO;
    @Override
    public Collection<Department> getDepartments() {
        return departmentDAO.getDepartments();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentDAO.getDepartmentById(id);
    }
}