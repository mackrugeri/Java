
//shahzad.khan@nu.edu.pk


//Lamda's

interface singleMethod{
    public void sum(int a,int b,int c);
}

public class week3_2 {
    public static void main(String[] args) {

        singleMethod obj=(int x,int y,int c) -> System.out.println("sum = "+(x-y+c));
            
        obj.sum(2,2,2);
    }
}
