package com.yous.learningtwo.host.dto;

/**
 * @author syou
 * @date 2018/10/21.
 */
public interface Food {
    void getName();

    enum Appetizer implements Food {
        A {
            @Override
            public void getName() {
                System.out.println("A");
            }
        }, B {
            @Override
            public void getName() {
                System.out.println("B");
            }
        }
    }

    enum Desert implements Food {
        AA {
            @Override
            public void getName() {
                System.out.println("AA");
            }
        }, BB {
            @Override
            public void getName() {
                System.out.println("BB");
            }
        }
    }
}
