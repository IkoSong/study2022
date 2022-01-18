package slh.code.java;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    private void lock(){
        Thread thread = Thread.currentThread();
        //准备抢占
        while(!atomicReference.compareAndSet(null,thread)){

        }
        System.out.println(Thread.currentThread().getName()+"Locked");
    }

    private void unLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName()+"unLocked");
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        new Thread(()->{
            spinLock.lock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.unLock();
        },"线程A").start();


        new Thread(()->{
            spinLock.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.unLock();

        },"线程B").start();
    }



}