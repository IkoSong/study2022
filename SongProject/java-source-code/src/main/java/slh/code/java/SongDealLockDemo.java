package slh.code.java;

class LockDemo implements Runnable {
    private String lockA;
    private String lockB;

    public LockDemo(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + " has " + lockA + ",and attemp to get" + lockB);
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + " has " + lockB + ",and attemp to get" + lockA);
            }
        }
    }
}

public class SongDealLockDemo {


    public static void main(String[] args) {
        String lockA = "A";
        String lockB = "B";
        new Thread(new LockDemo(lockA,lockB),"T1").start();
        new Thread(new LockDemo(lockB,lockA),"T2").start();
    }
}
