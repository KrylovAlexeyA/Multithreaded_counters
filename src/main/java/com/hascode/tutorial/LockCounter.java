package com.hascode.tutorial;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.locks.ReentrantLock;

public class LockCounter implements Counter {
    private ReentrantLock lock = new ReentrantLock();
    private long value;

    @Override
    public void increment() { ;
        lock.lock();
        try {
            value++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public long getValue() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }
}
