package com.yous.learningtwo.host.builder;

public class User {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    private User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public static UserBuilder builder(){
        return new UserBuilder();
    }

    public static class UserBuilder{
        private String name;
        private int age;

        public  UserBuilder name(String name){
            this.name=name;
            return this;
        }

        public UserBuilder age(int age){
            this.age=age;
            return this;
        }

        public User build(){
            return new User(name,age);
        }
    }

}
