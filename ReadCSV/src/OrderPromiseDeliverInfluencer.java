import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OrderPromiseDeliverInfluencer extends OrderPromiseDeliver
{
    public ArrayList<String> order_Promise_delier_Influencer = new ArrayList<String>();

    public void I_display()
    {
        System.out.println("OrderPromiseDeliverInfluencer");
        for(int i =0; i< this.order_Promise_delier_Influencer.size(); i++)
        {
            System.out.println(order_Promise_delier_Influencer.get(i));
        }
    }
    public  void setOrder_Promise_delier_Influencer_set()
    {
        String line = "";
        String splitBy = ",";
        int a =0;
        String con = "";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("OrderPromiseDeliverInfluencer.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);    // use comma as separator

                for(String i:employee)
                {

                    con = con + i + "-,-";
                    a++;

                    if (a == 14)
                    {
                        order_Promise_delier_Influencer.add(con);
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

    public static void main(String[] args) {
        OrderPromiseDeliverInfluencer D = new OrderPromiseDeliverInfluencer();
        D.Order_check();
        D.O_display();
        System.out.println();
        System.out.println();
        D.order_Promise_set();
        D.P_display();
        System.out.println();
        System.out.println();
        D.setOrder_Promise_delier_set();
        D.D_display();
        System.out.println();
        System.out.println();
        D.setOrder_Promise_delier_Influencer_set();
        D.I_display();

    }
}  