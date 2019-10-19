package com.hascode.tutorial;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class MagicCounter2 implements Counter {
    //Порой магия не работает )) но очень редко
    private long value;
    private int numberOfThreads;
    private Queue queue = new ArrayDeque<Thread>(numberOfThreads);

    public MagicCounter2(int numberOfThreads){
        this.numberOfThreads = numberOfThreads;
    }


    @Override
    public void increment() {
        queue.offer(Thread.currentThread());
        while (!Thread.currentThread().equals(queue.peek()) && queue.peek() != null){
            Thread.currentThread().yield();
        }
        value++;
        queue.poll();
    }

    @Override
    public long getValue() {
        return value;
    }
}