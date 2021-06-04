import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OrderPromise extends MYTOPCLASS
{
    public ArrayList<String> order_Promise = new ArrayList<String>();

    public void P_display()
    {
        System.out.println("OrderPromiseD");
        for(int i =0; i< this.order_Promise.size(); i++)
        {
            System.out.println(order_Promise.get(i));
        }
    }
    public  void order_Promise_set()
    {
        String line = "";
        String splitBy = ",";
        int a =0;
        String con = "";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("OrderPromise.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);    // use comma as separator

                for(String i:employee)
                {

                    con = con + i + "-,-";
                    a++;
                    if (a == 8)
                    {
                        order_Promise.add(con);
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
}  