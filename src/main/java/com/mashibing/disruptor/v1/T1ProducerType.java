package com.mashibing.disruptor.v1;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.*;

public class T1ProducerType {
    public static void main(String[] args) {
        LongEventFactory longEventFactory = new LongEventFactory();
        int bufferSize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent> (longEventFactory, bufferSize, Executors.defaultThreadFactory(),
            ProducerType.MULTI,new BlockingWaitStrategy());
        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        final int threadCount = 50;
        CyclicBarrier barrier = new CyclicBarrier(50);
        ExecutorService service = Executors.newCachedThreadPool();
        for (long i = 0; i < threadCount; i++) {
            final long threadNum = i;
            service.submit(()->{
                System.out.println("Thread "+threadNum+" ready to start");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                for (int i1 = 0; i1 < 100; i1++) {
                    int finalI = i1;
                    ringBuffer.publishEvent((event, sequence) ->{
                        event.setValue(threadNum);
                        System.out.println("produce  " + (threadNum* finalI + finalI));
                    });
                }
            });

        }
        service.shutdown();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LongEventHandler.count);
    }
}
