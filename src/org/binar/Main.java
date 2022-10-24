package org.binar;

public class Main {

    public static void main(String[] args) {

        int A [] = new int[1000];
        int B [] = new int[1000];
        int C [] = new int[1000];
        int []sum = new int[1000];
        int []mul = new int[1000];

        //Fill A
        for (int i = 1; i <= 1000 ; i++) {
            A[i-1] = i;
        }
        //FillB
        for (int i  = 0; i < B.length ; i++) {
            B[i] = i+1000;
        }

        //FillC
        for (int i = 0; i < 1000; i++) {
            int temp = i+1;
            C[i] = i + temp;
        }

        // thread pertama (operasi sum)
        Thread thread = new Thread(){
            @Override
            public synchronized void run() {
                for (int i = 0; i < 1000; i++) {
                    sum[i] = A[i] + B[i];
                    System.out.println(Color.ANSI_GREEN +
                            currentThread().getName()
                            + ", index  : " + i  + ", sum : " + sum[i]);
                }
            }
        };

        //Thread kedua (operasi multiplication)
        Thread thread1 = new Thread() {
            @Override
            public synchronized void run() {
                for (int i = 0; i < 1000; i++) {
                    mul[i] = sum[i] * C[i];
                    System.out.println(Color.ANSI_BLUE +
                            currentThread().getName()  +
                            ", index  : " + i  + ", mul : " +  mul[i] );
                }
            }
        };


        thread.setName("Thread-1");
        thread1.setName("Thread-2");
        thread.start();
        thread1.start();




    }
}
