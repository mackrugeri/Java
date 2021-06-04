public class week6_2_thread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // try {
            //     Thread.currentThread().sleep(500);
            // } catch (InterruptedException e) {System.out.println(e.getMessage());}
            System.out.println("hi i am "+Thread.currentThread().getName()+" iteration #"+i);    
        }
    }
    
}
