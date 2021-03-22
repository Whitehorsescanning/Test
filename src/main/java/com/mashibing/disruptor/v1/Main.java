package com.mashibing.disruptor.v1;

import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        //Executor executor = Executors.newCachedThreadPool();

        LongEventFactory factory = new LongEventFactory();

        //must be power of 2
        int ringBufferSize = 1024;

        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(LongEvent::new, ringBufferSize, Executors.defaultThreadFactory());
        LongEventHandler h1 = new LongEventHandler();
        LongEventHandler h2 = new LongEventHandler();
        disruptor.handleEventsWith(h1,h2);
        disruptor.handleExceptionsFor(h1).with(new ExceptionHandler<LongEvent>(){
            @Override
            public void handleEventException(Throwable ex, long sequence, LongEvent event) {
                ex.printStackTrace();
            }

            @Override
            public void handleOnStartException(Throwable ex) {
                System.out.println("exception start to handle");
            }

            @Override
            public void handleOnShutdownException(Throwable ex) {
                System.out.println("exception end to handle");
            }
        });
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        ringBuffer.publishEvent((event, sequence, arg0,arg1) ->{
            event.setValue(arg0+arg1);
            System.out.println("生产");
        },55L,44L);

       /* long squence = ringBuffer.next();

        try {
            for (int i = 0; i < 3; i++) {
                LongEvent event = ringBuffer.get(squence);
                event.setValue(8888L);

            }
        } finally {
            ringBuffer.publish(squence);


        }
*/
/*
        LongEventProducer producer = new LongEventProducer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);

        for(long l = 0; l<100; l++) {
            bb.putLong(0, l);

            producer.onData(bb);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        disruptor.shutdown();*/
    }
}

