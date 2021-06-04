public class week6_1 {

    public static void main(String[] args) {
        week6_1_thread thread1=new week6_1_thread();
        week6_1_thread thread2=new week6_1_thread();
        week6_1_thread thread3=new week6_1_thread();
        
        thread1.start();
        thread2.start();
        thread3.start();


        // Runnable runnable=()->{};
        
        // week6_1_thread obj =new week6_1_thread();
        // Thread thread1=new Thread(obj);
        // thread1.start();


    }
}
