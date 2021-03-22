package com.mashibing.juc.c_023_02_FromHashtableToCHM;

import java.util.UUID;

public class Constants {
    public static final int COUNT = 1000000;
    public static final int THREAD_COUNT = 100;
    static UUID[] keys = new UUID[COUNT];
    static UUID[] values = new UUID[COUNT];

    static {
        for (int i = 0; i < COUNT; i++) {
            keys[i] = UUID.randomUUID();
            values[i] = UUID.randomUUID();
        }
    }


}
