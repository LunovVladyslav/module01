package org.example.ver1;

public class FooSync {
    private String state = "first";

    public synchronized void first() {
        try {
            while (!"first".equals(state)) {
                wait();
            }
            state = "second";
            notifyAll();
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }

    public synchronized void second() {
        try {
            while (!"second".equals(state)) {
                wait();
            }

            System.out.print("Second");
            state = "third";
            notifyAll();
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }

    public synchronized void third() {
        try {
            while (!"third".equals(state)) {
                wait();
            }

            System.out.print("Third");
            state = "end";
            notifyAll();
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }
}
