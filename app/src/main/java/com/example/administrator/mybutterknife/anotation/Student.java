package com.example.administrator.mybutterknife.anotation;

/**
 * Created by LiBing
 * on 2017/10/10 0010
 * describe:Student使用了注解BindView
 */
public class Student {

    @BindView(name = "zhangsan", age = 10)
    private String name;

    private int age;

    public void study() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
