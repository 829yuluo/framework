package indi.exer.yuluo.basic;

import java.util.*;

public class Person {

    private String[] emails;
    private Integer id;
    private String name;
    private Set<String> tels;
    private List<String> address;
    private Map<String, String> qqs;
    private Properties p;

    public Properties getP() {
        return p;
    }

    public void setP(Properties p) {
        this.p = p;
    }

    public Map<String, String> getQqs() {
        return qqs;
    }

    public void setQqs(Map<String, String> qqs) {
        this.qqs = qqs;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public Set<String> getTels() {
        return tels;
    }

    public void setTels(Set<String> tels) {
        this.tels = tels;
    }

    public Person(String[] emails) {
        this.emails = emails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String[] getEmails() {
        return emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Person() {
        // 如果输出了这个语句 就证明反射创建对象的方式调用了类的构造方法
        System.out.println("Person.Person");
    }

    @Override
    public String toString() {
        return "Person{" +
                "emails=" + Arrays.toString(emails) +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
