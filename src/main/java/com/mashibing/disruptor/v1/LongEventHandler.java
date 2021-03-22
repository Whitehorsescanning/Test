package com.mashibing.disruptor.v1;

import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent> {
    static long count = 0;
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(longEvent.toString());
        System.out.println(Thread.currentThread().getName()+" : "+count);
        count++;
    }
}
