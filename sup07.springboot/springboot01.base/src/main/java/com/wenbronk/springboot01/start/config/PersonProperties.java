package com.wenbronk.springboot01.start.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-10 19:58
 * description:
 */
@ConfigurationProperties(prefix = "person")
public class PersonProperties {

    private String name;
    private Integer age;
    private List<String> addr;
    private List<String> city;
    private Map<String, String> student;
    private Map<String, String> parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getAddr() {
        return addr;
    }

    public void setAddr(List<String> addr) {
        this.addr = addr;
    }

    public List<String> getCity() {
        return city;
    }

    public void setCity(List<String> city) {
        this.city = city;
    }

    public Map<String, String> getStudent() {
        return student;
    }

    public void setStudent(Map<String, String> student) {
        this.student = student;
    }

    public Map<String, String> getParent() {
        return parent;
    }

    public void setParent(Map<String, String> parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "PersonProperties{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr=" + addr +
                ", city=" + city +
                ", student=" + student +
                ", parent=" + parent +
                '}';
    }
}
