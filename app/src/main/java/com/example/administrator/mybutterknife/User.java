package com.example.administrator.mybutterknife;

import android.util.Log;

/**
 * Created by LiBing
 * on 2017/10/9 0009
 * describe:
 */

public class User {

    private String name;
    public int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(String eat) {
        Log.e("---------", eat + "非常好吃");
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
