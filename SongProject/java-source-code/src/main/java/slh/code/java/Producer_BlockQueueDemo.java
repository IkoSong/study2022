package slh.code.java;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource{
    private volatile boolean flag = true;  //默认开启 生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }
    public void myProd() throws Exception{
        String data = null;
        boolean retValue;
        while(flag){
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
            }else{
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
            }
        }
        System.out.println("Stop!");
    }

    public void myCons() throws Exception{
        String result = null;
        while(flag){
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(null == result || "".equalsIgnoreCase(result)){
                flag = false;
                System.out.println(Thread.currentThread().getName()+"\t 超过两秒没有取到，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费队列"+result+"成功");
        }
    }
    public void stop(){
        this.flag = false;
    }
}


public class Producer_BlockQueueDemo {

    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(100));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t 生产者线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+ "\t 消费者线程启动");
            try {
                myResource.myCons();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consumer").start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5s后 stop");
        myResource.stop();
    }
}

