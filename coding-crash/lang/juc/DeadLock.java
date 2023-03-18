package lang.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLock {
    public static void main(String[] args) {

        new DeadLock().add();

        Integer res1 = 1; //resource
        Integer res2 = 2;

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (res1){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        synchronized (res2){
                            System.out.println(Thread.currentThread().getId() + " " + res2);
                        }
                    }
                }

            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (res2){

                        synchronized (res1){
                            System.out.println(Thread.currentThread().getId() + " " + res1);
                        }
                    }
                }

            }
        });
    }

    public void add(){
        System.out.println("---");
    }

}
