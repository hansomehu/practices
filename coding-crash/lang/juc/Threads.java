package lang.juc;

import java.util.concurrent.*;

public class Threads {
    public static void main(String[] args) {

        new Threads().threadApplication1();

    }

    /**
     * 多个线程循环打印abc
     */
    public void threadApplication1(){
        int num = 1;
        PrintTask1 print = new PrintTask1(num);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                print.printA();
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                print.printB();
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                print.printC();
            }
        });


    }

    class PrintTask1{
        // 推出条件
        private int num = 1;
        PrintTask1(int num){
            super();
            this.num = num;
        }

        //
        public void printA(){
            synchronized (this){
                while (num==1){
                    try{
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    //business
                    System.out.println("A");
                    num = 2;
                    this.notifyAll();
                }
            }
        }

        //
        public void printB(){
            synchronized (this){
                while (num==2){
                    try{
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    //business
                    System.out.println("B");
                    num = 3;
                    this.notifyAll();
                }
            }
        }

        //
        public void printC(){
            synchronized (this){
                while (num==3){
                    try{
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    //business
                    System.out.println("C");
                    num = 1;
                    this.notifyAll();
                }
            }
        }
    }
}
