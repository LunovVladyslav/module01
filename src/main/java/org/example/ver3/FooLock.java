package org.example.ver3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooLock {

    ReentrantLock lock = new ReentrantLock();
    Condition conditionSecond = lock.newCondition();
    Condition conditionThird = lock.newCondition();

    public void first() {
        try {
            lock.lock();
            System.out.print("first");
            conditionSecond.signal();
        } finally {
            lock.unlock();
        }


    }
    public void second() {
        try {
            lock.lock();
            conditionSecond.await();
            System.out.print("second");
            conditionThird.signal();
        } catch (InterruptedException exc) {
            System.out.println(exc);
        } finally {
            lock.unlock();
        }

    }
    public void third() {
        try {
            lock.lock();
            conditionThird.await();
            System.out.print("third");
        } catch (InterruptedException exc) {
            System.out.println(exc);
        } finally {
            lock.unlock();
        }
    }
}
