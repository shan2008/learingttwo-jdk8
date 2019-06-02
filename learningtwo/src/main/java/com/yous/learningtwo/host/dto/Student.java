package com.yous.learningtwo.host.dto;

import java.io.Serializable;

/**
 * Created by syou on 2017/7/5.
 */
public class Student implements Serializable {
    private Integer id;
    private String name;
    Boolean gender;
    public  Student(){};


    public Student(int id){
        this.id=id;
    }
    public Student(Integer id,String name){
        this.id=id;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
