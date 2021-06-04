import java.util.stream.IntStream;

public class week3_4 {
    public static void main(String[] args) {
        // int values[]={99,80,20,1,3,4,5,6,23,32,5,3,32,5};
        
        // int total=IntStream.range(1, 101) //1 to 100
        // .reduce(0, (t,arg)  ->  t+arg); // t=t+arg
        // System.out.println("total= "+total);

        //  4! = 4x3x2x1 
        // 4! = 24
        int factorial= IntStream.range(0, 4) //0 1 2 3
                        // 1*(0+1)=1
                        // 1*(1+1)=2
                        // 2*(2+1)=6
                        // 6*(3+1)=24
                        .reduce(1, (t,current) -> t*(current+1) );
        System.out.println("factorial= "+factorial);
    }
}
