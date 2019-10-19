package com.hascode.tutorial;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;

@State(Scope.Benchmark)
@Measurement(iterations = 5,time = 5)
@Warmup(iterations = 2,time = 5)
@Fork(value = 1)
@BenchmarkMode(value = Mode.Throughput)
public class Benchmark {

    private LockCounter lockCounter = new LockCounter();
    private MutexCounter mutexCounter = new MutexCounter();
    private ConcurrentCounter concurrentCounter = new ConcurrentCounter();
    private MagicCounter magicCounter = new MagicCounter(4);
    private MagicCounter magicCounter2 = new MagicCounter(4);

    public static void main(String[] args) throws IOException, RunnerException {
        org.openjdk.jmh.Main.main(args);
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(1)
    public void lockCounterIncrement1() {
        lockCounter.increment();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(2)
    public void lockCounterIncrement2() {
        lockCounter.increment();
    }
    @org.openjdk.jmh.annotations.Benchmark
    @Threads(3)
    public void lockCounterIncrement3() {
        lockCounter.increment();
    }
    @org.openjdk.jmh.annotations.Benchmark
    @Threads(4)
    public void lockCounterIncrement4() {
        lockCounter.increment();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(1)
    public long lockCounterGet1() {
        return lockCounter.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(2)
    public long lockCounterGet2() {
        return lockCounter.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(3)
    public long lockCounterGet3() {
        return lockCounter.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(4)
    public long lockCounterGet4() {
        return lockCounter.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(1)
    public void mutexIncrement1() {
        mutexCounter.increment();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(2)
    public void mutexCounterIncrement2() {
        mutexCounter.increment();
    }
    @org.openjdk.jmh.annotations.Benchmark
    @Threads(3)
    public void mutexCounterIncrement3() {
        mutexCounter.increment();
    }
    @org.openjdk.jmh.annotations.Benchmark
    @Threads(4)
    public void mutexCounterIncrement4() {
        mutexCounter.increment();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(1)
    public long mutexCounterGet1() {
        return mutexCounter.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(2)
    public long mutexCounterGet2() {
        return mutexCounter.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(3)
    public long mutexCounterGet3() {
        return mutexCounter.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(4)
    public long mutexCounterGet4() {
        return mutexCounter.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(1)
    public void councurrentIncrement1() {
        concurrentCounter.increment();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(2)
    public void councurrentCounterIncrement2() {
        concurrentCounter.increment();
    }
    @org.openjdk.jmh.annotations.Benchmark
    @Threads(3)
    public void councurrentCounterIncrement3() {
        concurrentCounter.increment();
    }
    @org.openjdk.jmh.annotations.Benchmark
    @Threads(4)
    public void councurrentCounterIncrement4() {
         concurrentCounter.increment();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(1)
    public long councurrentCounterGet1() {
        return concurrentCounter.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(2)
    public long councurrentCounterGet2() {
        return concurrentCounter.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(3)
    public long councurrentCounterGet3() {
        return concurrentCounter.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(4)
    public long councurrentCounterGet4() {
        return concurrentCounter.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(1)
    public void magic1Increment1() {
        magicCounter.increment();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(2)
    public void magic1CounterIncrement2() {
        magicCounter.increment();
    }
    @org.openjdk.jmh.annotations.Benchmark
    @Threads(3)
    public void magic1CounterIncrement3() {
        magicCounter.increment();
    }
    @org.openjdk.jmh.annotations.Benchmark
    @Threads(4)
    public void magic1CounterIncrement4() {
        magicCounter.increment();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(1)
    public long magic1CounterGet1() {
        return magicCounter.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(2)
    public long magic1CounterGet2() {
        return magicCounter.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(3)
    public long magic1CounterGet3() {
        return magicCounter.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(4)
    public long magic1CounterGet4() {
        return magicCounter.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(1)
    public void magic2Increment1() {
        magicCounter2.increment();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(2)
    public void magic2CounterIncrement2() {
        magicCounter2.increment();
    }
    @org.openjdk.jmh.annotations.Benchmark
    @Threads(3)
    public void magic2CounterIncrement3() {
        magicCounter2.increment();
    }
    @org.openjdk.jmh.annotations.Benchmark
    @Threads(4)
    public void magic2CounterIncrement4() {
        magicCounter2.increment();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(1)
    public long magic2CounterGet1() {
        return magicCounter2.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(2)
    public long magic2CounterGet2() {
        return magicCounter2.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(3)
    public long magic2CounterGet3() {
        return magicCounter2.getValue();
    }

    @org.openjdk.jmh.annotations.Benchmark
    @Threads(4)
    public long magic2CounterGet4() {
        return magicCounter2.getValue();
    }
}
