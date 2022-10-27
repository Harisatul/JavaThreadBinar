package org.binar;

public class Sleep {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Inside : " + Thread.currentThread().getName());

            for (int i = 0; i < 5; i++) {
                System.out.println(Color.ANSI_YELLOW + i);
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread2 = new Thread(runnable);
        thread2.setName("thread-3");
        thread2.start();
    }
}
