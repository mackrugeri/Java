public class week6_2 {
    public static void main(String[] args) throws InterruptedException {
        week6_2_thread thread1,thread2,thread3;
        thread1=new week6_2_thread();
        thread2=new week6_2_thread();
        thread3=new week6_2_thread();

        thread1.setName("thread1");
        thread2.setName("thread2");
        thread3.setName("thread3");


        thread1.run();

        thread1.start();
        thread1.join();
        thread2.start();
        thread3.start();
    }    
}
