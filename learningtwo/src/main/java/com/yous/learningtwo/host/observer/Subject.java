package com.yous.learningtwo.host.observer;

import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

public class Subject extends Observable {


    @Test
    public void test() {
        Subject observable = new Subject();
        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(o.hasChanged() + "---" + arg);
            }
        });

        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(o.hasChanged() + "---2" + arg);
            }
        });

        observable.setChanged();

        observable.notifyObservers("come in ...");
    }
}
