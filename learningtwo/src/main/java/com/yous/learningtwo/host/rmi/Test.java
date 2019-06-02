package com.yous.learningtwo.host.rmi;

import javafx.scene.effect.SepiaTone;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import java.rmi.Naming;
import java.util.HashSet;
import java.util.Set;

/**
 * @author syou
 * @date 2019/5/12.
 */
public class Test {


    public static void test(String[] args) {

        try {

            Set<String> set =new HashSet<>();
            set.add("sasa");

            UserHander userHander = new UserHanderImpl();
            Naming.rebind("user",userHander);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void testHessian(String[] args) {


    }

}
