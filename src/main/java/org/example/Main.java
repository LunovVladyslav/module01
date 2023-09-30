package org.example;

import org.example.ver1.FooSync;
import org.example.ver2.FooSem;
import org.example.ver3.FooLock;

public class Main {
    public static void main(String[] args) {
//        FooSync o = new FooSync();
//        FooSem o = new FooSem();
        FooLock o = new FooLock();

        Thread one = new Thread(() -> o.first());
        Thread two = new Thread(() -> o.second());
        Thread three = new Thread(() -> o.third());

//        two.start();
//        one.start();
//        three.start();

//        three.start();
//        two.start();
//        one.start();

        two.start();
        three.start();
        one.start();

//        three.start();
//        one.start();
//        two.start();

    }
}
