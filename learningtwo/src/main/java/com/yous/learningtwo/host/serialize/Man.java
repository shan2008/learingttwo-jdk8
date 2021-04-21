package com.yous.learningtwo.host.serialize;

import java.beans.Transient;
import java.io.Serializable;

/**
 * @author syou
 * @date 2018/8/1.
 */
public class Man implements Serializable {

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    private transient  Person person;
    private boolean sex;

    public Man() {
        super();
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
