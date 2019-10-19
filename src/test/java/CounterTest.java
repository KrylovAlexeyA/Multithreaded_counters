import com.hascode.tutorial.*;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static org.junit.Assert.assertEquals;

public class CounterTest {
    private static final Counter MAGIC_COUNTER = new MagicCounter(100);
    private static final Counter LOCK_COUNTER = new LockCounter();
    private static final Counter MUTEX_COUNTER = new MutexCounter();
    private static final Counter MAGIC_COUNTER2 = new MagicCounter2(30);
    private static final Counter CONCURRENT_COUNTER = new ConcurrentCounter();
    private static final Counter SEQ_COUNTER = new SeqCounter();


    @Test
    public void testMagic2Execution() throws ExecutionException, InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(30);

        int incrementCallsCount = 100;

        List<Future> futures = range(0, incrementCallsCount)
                .mapToObj(i -> executors.submit(incrementRunnableMagic2()))
                .collect(toList());
        for (Future future : futures) {
            future.get();
        }
        assertEquals("Oops! Smth is wrong!", incrementCallsCount, MAGIC_COUNTER2.getValue());
    }

    private static Runnable incrementRunnableMagic2(){
        return MAGIC_COUNTER2::increment;
    }

    @Test
    public void testMagicExecution() throws ExecutionException, InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(100);

        int incrementCallsCount = 11000;

        List<Future> futures = range(0, incrementCallsCount)
                .mapToObj(i -> executors.submit(incrementRunnableMagic()))
                .collect(toList());
        for (Future future : futures) {
            future.get();
        }
        assertEquals("Oops! Smth is wrong!", incrementCallsCount, MAGIC_COUNTER.getValue());
    }

    private static Runnable incrementRunnableMagic(){
        return MAGIC_COUNTER::increment;
    }

    @Test
    public void testLockExecution() throws ExecutionException, InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(100);

        int incrementCallsCount = 11000;

        List<Future> futures = range(0, incrementCallsCount)
                .mapToObj(i -> executors.submit(incrementRunnableLock()))
                .collect(toList());
        for (Future future : futures) {
            future.get();
        }
        assertEquals("Oops! Smth is wrong!", incrementCallsCount, LOCK_COUNTER.getValue());
    }

    private static Runnable incrementRunnableLock(){
        return LOCK_COUNTER::increment;
    }

    @Test
    public void testMutexExecution() throws ExecutionException, InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(100);

        int incrementCallsCount = 11000;

        List<Future> futures = range(0, incrementCallsCount)
                .mapToObj(i -> executors.submit(incrementRunnableMutex()))
                .collect(toList());
        for (Future future : futures) {
            future.get();
        }
        assertEquals("Oops! Smth is wrong!", incrementCallsCount, MUTEX_COUNTER.getValue());
    }

    private static Runnable incrementRunnableMutex(){
        return MUTEX_COUNTER::increment;
    }

    @Test
    public void testConcurrentExecution() throws ExecutionException, InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(100);

        int incrementCallsCount = 11000;

        List<Future> futures = range(0, incrementCallsCount)
                .mapToObj(i -> executors.submit(incrementRunnableConcurrent()))
                .collect(toList());
        for (Future future : futures) {
            future.get();
        }
        assertEquals("Oops! Smth is wrong!", incrementCallsCount, CONCURRENT_COUNTER.getValue());
    }

    private static Runnable incrementRunnableConcurrent(){
        return CONCURRENT_COUNTER::increment;
    }

    @Test
    public void testSeqExecution() throws ExecutionException, InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(100);

        int incrementCallsCount = 11000;

        List<Future> futures = range(0, incrementCallsCount)
                .mapToObj(i -> executors.submit(incrementRunnableSeq()))
                .collect(toList());
        for (Future future : futures) {
            future.get();
        }
        assertEquals("Oops! Smth is wrong!", incrementCallsCount, SEQ_COUNTER.getValue());
    }

    private static Runnable incrementRunnableSeq(){
        return SEQ_COUNTER::increment;
    }
}