
public class week6_1_thread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("hi i am "+Thread.currentThread().getName()+" iteration #"+i);    
            }
            
        }

}

//Runnable (single method interface)
// public class week6_1_thread implements Runnable{
//     @Override
//     public void run() {
//         System.out.println("hi i am a thread");
//     }
    
// }
