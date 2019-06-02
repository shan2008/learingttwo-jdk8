package com.yous.learningtwo.host.extend;

/**
 * @author syou
 * @date 2018/8/30.
 */
public class Circle  extends Shape{
    private static Mobike mobike = new Mobike();
    private Car car = new Car();
    static {
        System.out.println("Cirlce...静态代码块执行了");
    }

     {
        System.out.println("Circle ...代码块执行了");
    }


    public Circle(){
        System.out.println("Circle 构造...");
    }

    @Override
    public void draw() {
        System.out.println("Circle draw()。。。");
    }

    @Override
    public void erase() {
        System.out.println("Circle erase()。。。");
    }

    public static void main(String[] args) {
        new Circle();
    }
}
