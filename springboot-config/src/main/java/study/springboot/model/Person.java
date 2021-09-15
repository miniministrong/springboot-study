package study.springboot.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

/**
 * @author dhl
 * @datetime 2021/7/30  15:59
 */
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "person")
@Validated
public class Person {
    private String name;
    private Integer age;
    private Boolean happy;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;
}