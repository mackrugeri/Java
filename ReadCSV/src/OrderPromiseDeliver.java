import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OrderPromiseDeliver extends OrderPromise
{
    public ArrayList<String> order_Promise_delier = new ArrayList<String>();

    public void D_display()
    {
        System.out.println("OrderPromiseDeliver");
        for(int i =0; i< this.order_Promise_delier.size(); i++)
        {
            System.out.println(order_Promise_delier.get(i));
        }
    }
    public  void setOrder_Promise_delier_set()
    {
        String line = "";
        String splitBy = ",";
        int a =0;
        String con = "";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("OrderPromiseDeliver.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);    // use comma as separator

                for(String i:employee)
                {
                    a++;
                    con = con + i + "-,-";

                    if (a == 11)
                    {
                        order_Promise_delier.add(con);
                        con= "";
                        a =0;

                    }
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
//
//    public static void main(String[] args) {
//        OrderPromiseDeliver D = new OrderPromiseDeliver();
//        D.order_Promise_set();
//        D.D_display();
//    }
}  