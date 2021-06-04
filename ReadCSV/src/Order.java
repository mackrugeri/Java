import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MYTOPCLASS
{
    public ArrayList<String> order = new ArrayList<String>();

    public void O_display()
    {
        System.out.println("Order");
        for(int i =0; i< this.order.size(); i++)
        {
            System.out.println(order.get(i));
        }
    }

    public  void Order_check()
    {
        String line = "";
        String splitBy = ",";

        int a =0;
        String con = "";
        try
        {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("Order.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);    // use comma as separator

                for(String i:employee)
                {

                    con = con + i + "-,-";
                    a++;
                    if (a == 4)
                    {
                        order.add(con);
                        a =0;
                        con= "";
                    }
                }
//                System.out.println("Employee [First Name=" + employee[0] + ", Last Name=" + employee[1] + ", Designation=" + employee[2] + ", Contact=" + employee[3] + ", Salary= " + employee[4] + ", City= " + employee[5] +"]");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public String toString()
    {
        return "Iteam here";
    }




}  