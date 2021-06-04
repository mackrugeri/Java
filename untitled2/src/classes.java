import javax.sound.midi.SysexMessage;
import java.util.ArrayList;

class Value{
    private int num;
    public  int getNum()
    {
        return num;
    }

}


public class classes {

    public  static void printsome(int[] nums)
    {
       int counter =0;
       int i= -1;
       while(i <= nums.length-2)
       {
           i++;
           if ( nums[i] < 0)
           {
               counter++;
           }
       }
       System.out.println(counter);
       int counter1 = 0;
       for( int a=1;a<nums.length;a++)
       {
           if(nums[a] < 0)
           {
               counter1++;
           }
       }
       System.out.println(counter1);

       int counter2 =0;
       for(int a:nums)
       {
           if(nums[a] < 0)
           {
               counter2++;
           }
       }
       System.out.println(counter2);
     }
    public  static int printsome1(ArrayList<Integer> values)
    {
//       ProductReview P = ProductReviw();
//       a = P.getReview();



    }



    public static void main(String[] args) {
        int[] data= {6,5,-1,5,6,5};
        ArrayList<Integer> cars = new ArrayList<Integer>();
        cars.add(1);
        cars.add(2);
        cars.add(3);
        cars.add(4);

    //        printsome(data);
        printsome1(cars);
    }
}
