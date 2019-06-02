package com.yous.learningtwo.host.entity;

/**
 * Created by syou on 2017/10/13.
 */
public class ResumeEntity {
    private String name;  //姓名
    private String sex;   //性别
    private int age;      //年龄
    private String experience; //工作经历

    public ResumeEntity(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
    public String getExperience() {
        return experience;
    }

    public void displayResume() {
        System.out.println("姓名："+name+" 性别："+sex+" 年龄:"+age);
        System.out.println("工作经历："+experience);
    }


}


