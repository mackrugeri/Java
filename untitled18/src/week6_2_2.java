public class week6_2_2 {
    static int sum=0;
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=()->{
            for (int i = 1; i <= 10; i++) {
                sum+=i;
            }
        };
        Thread thread=new Thread(runnable);
        thread.start();
        thread.join();
        System.out.println("the result is "+sum);
    }
}
