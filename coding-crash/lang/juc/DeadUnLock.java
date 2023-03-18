package lang.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class DeadUnLock {
    public static Integer res1 = 1;
    public static Integer res2 = 2;
    // lock for res1
    public static final Semaphore a1 = new Semaphore(1);
    //lock for res2
    public static final Semaphore a2 = new Semaphore(1);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        if (DeadUnLock.a1.tryAcquire(1, TimeUnit.SECONDS)){
                            System.out.println(Thread.currentThread().getId()+"::is using res1");
                            if (DeadUnLock.a2.tryAcquire(1, TimeUnit.SECONDS)){
                                System.out.println(Thread.currentThread().getId()+"::is using res2");
                            }else {
                                System.out.println(Thread.currentThread().getId()+"::acquire res2 failed");
                            }
                        }else {
                            System.out.println(Thread.currentThread().getId()+"::acquire res1 failed");
                        }
                        DeadUnLock.a1.release();
                        DeadUnLock.a2.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        if (DeadUnLock.a2.tryAcquire(1, TimeUnit.SECONDS)){
                            System.out.println(Thread.currentThread().getId()+"::is using res2");
                            if (DeadUnLock.a1.tryAcquire(1, TimeUnit.SECONDS)){
                                System.out.println(Thread.currentThread().getId()+"::is using res1");
                            }else {
                                System.out.println(Thread.currentThread().getId()+"::acquire res1 failed");
                            }
                        }else {
                            System.out.println(Thread.currentThread().getId()+"::acquire res2 failed");
                        }
                        DeadUnLock.a2.release();
                        DeadUnLock.a1.release();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
