package com.hascode.tutorial;

public class SeqCounter implements Counter {
    private long value;
    @Override
    public void increment() {
        synchronized (this) {
            value++;
        }
    }

    @Override
    public long getValue() {
        synchronized (this) {
            return value;
        }
    }
}
