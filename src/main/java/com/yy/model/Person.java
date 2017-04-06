package com.yy.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by skyler on 2017/4/1.
 */
public class Person implements Serializable{

    private String id;
    private String name;
    private int age;
    private LocalDateTime ctime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ctime=" + ctime +
                '}';
    }
}
