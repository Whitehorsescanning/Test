package com.mashibing.disruptor.v1;

public class LongEvent {
    @Override
    public String toString() {
        return "LongEvent{" +
                "value=" + value +
                '}';
    }

    private long value;


    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;

    }
}
