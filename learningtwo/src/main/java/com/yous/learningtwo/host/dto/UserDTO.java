package com.yous.learningtwo.host.dto;

/**
 * Created by syou on 2017/7/28.
 */
public class UserDTO  implements Cloneable{
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    Student student;
    int code;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (UserDTO)super.clone();
    }
}
