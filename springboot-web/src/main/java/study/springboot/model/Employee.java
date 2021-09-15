package study.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 员工表实体类
 *
 * @author dhl
 * @datetime 2021/8/2  15:44
 */
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String employeeName;
    private String email;
    /**
     * 0女，1男
     */
    private Integer sex;
    private Department department;
    private Date birth;

    public Employee(Integer id, String employeeName, String email, Integer sex, Department department) {
        this.id = id;
        this.employeeName = employeeName;
        this.email = email;
        this.sex = sex;
        this.department = department;
        // 默认的创建日期
        this.birth = new Date();
    }
}