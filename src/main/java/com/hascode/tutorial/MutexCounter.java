package com.hascode.tutorial;

public class MutexCounter implements Counter {
    //Тоже самое , что SeqCounter
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
