package study.springboot.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author dhl
 * @datetime 2021/7/30  15:58
 */
@Data
@ToString
@Component
public class Dog {
    private String name;
    private Integer age;
}