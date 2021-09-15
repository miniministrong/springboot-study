package study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.springboot.model.Department;
import study.springboot.model.Employee;
import study.springboot.service.DepartmentService;
import study.springboot.service.EmployeeService;

import java.util.Collection;

/**
 * @author dhl
 * @datetime 2021/8/2  17:53
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeService.getEmployees();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        // 查出所有的部门
        Collection<Department> departments = departmentService.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeService.add(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        Employee emp = employeeService.getEmployeeById(id);
        model.addAttribute("emp", emp);
        Collection<Department> departments = departmentService.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeService.add(employee);
        return "redirect:/emps";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/emps";
    }
}