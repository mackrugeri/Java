public class week6_2_3 {
    public static void main(String[] args) {
        int array[]={3,4,5,6,7,8,8,5,4,3,2,4,6,8,6,5,3,4,7,9,9,7,6,45,4,6,7,8,6,4,4,54,6,8,8,6,45,555,34,324,54,56,76,67,45,34,34,34,34,54,65};
        long start=System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            if(array[i]==555)
                System.out.println(System.nanoTime()-start);
//            System.out.println("hello world");
        }

        Runnable runnable1=()->{
            long start2=System.nanoTime();
            for (int i = 0; i < 25; i++) {
//                if(array[i]==555)
//                System.out.println(System.nanoTime()-start2);
            }
        };

        Runnable runnable2=()->{
            long start3=System.nanoTime();
            for (int i = 25; i < 49; i++) {
                if(array[i]==555)
                    System.out.println(System.nanoTime()-start3);
            }
        };

        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }
}
