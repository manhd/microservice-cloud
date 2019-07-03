package com.haidm.spring.cn.threads;

import sun.applet.Main;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/7/2 10:56
 * @Version 1.0
 **/
public class MyThread_2 implements Runnable {

    private  Thread t;
    private String threadName;

    public MyThread_2(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating" + threadName);
    }

    @Override
    public void run() {
        System.out.println("Runing" + threadName);

        try {
            for (int i = 0; i<4; i++){
                System.out.println("Thread" + threadName + ","+ i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Thread " +  threadName + " interrupted.");
        }

        System.out.println("Thread " +  threadName + " exiting.");
    }


    public void start(){
        System.out.println("Starting" + threadName);
        if(t == null){
            t = new Thread (this, threadName);
            t.start();
        }
    }


    public static void main(String[] args) {
        MyThread_2 myThread_2 = new MyThread_2("Thread_2");
        myThread_2.start();
    }
}

