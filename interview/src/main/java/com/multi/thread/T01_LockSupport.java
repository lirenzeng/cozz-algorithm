package com.multi.thread;

import java.util.concurrent.locks.LockSupport;

public class T01_LockSupport {


    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {

        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {

            for (char i : aI) {
                System.out.print(i);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(() -> {

            for (char j : aC) {
                LockSupport.park();
                System.out.print(j);
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
