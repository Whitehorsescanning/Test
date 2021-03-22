package com.mashibing.juc.c_026_01_ThreadPool;

import java.io.IOException;

public class UncheckExcption {


    public void doSomething() throws IOException {
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        UncheckExcption ett = new UncheckExcption();
        ett.doSomething();
    }


}