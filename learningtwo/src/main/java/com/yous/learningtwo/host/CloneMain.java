package com.yous.learningtwo.host;

import java.util.Arrays;

/**
 * Created by syou on 2017/10/13.
 */
public class CloneMain {
    public static void main(String[] args)  throws Exception{

        UserDTO user1=new UserDTO();
        user1.setStudent(new Student(1, "shan"));
        user1.setCode(1);
        UserDTO user2=(UserDTO)user1.clone();
        user2.getStudent().setName("you");

        System.out.println(user1.getStudent().getName());
        System.out.println(user2.getStudent().getName());

    }

}
