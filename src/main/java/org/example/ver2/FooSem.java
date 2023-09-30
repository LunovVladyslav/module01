package org.example.ver2;

import java.util.concurrent.Semaphore;

public class FooSem {
    Semaphore semaphore1 = new Semaphore(0);
    Semaphore semaphore2= new Semaphore(0);
    public void first() {
        System.out.print("First");
        semaphore1.release();
    }
    public void second() {
        try {
            semaphore1.acquire();
            System.out.print("Second");
            semaphore2.release();
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

    }
    public void third() {
        try {
            semaphore2.acquire();
            System.out.print("Third");
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }
}
