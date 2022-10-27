package org.binar;

public class Join {

    public static void main(String[] args) {

        // thread pertama (operasi sum)
        Thread thread1 = new Thread() {
            @Override
            public synchronized void run() {
                System.out.println("Entered Thread-1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Exiting thread-1");
            }
        };

        thread1.start();
        //Thread kedua (operasi mul)
        Thread thread2 = new Thread() {
            @Override
            public synchronized void run() {
                System.out.println("Entered Thread-2");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Exiting thread-2");
            }
        };
        thread2.start();

        System.out.println("Waiting for thread 1 to complete");
        try
        {
            thread1.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
