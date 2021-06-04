import java.util.ArrayList;

class HW6dClass{
    String FirstName ="";
    String LastName ="";
    int StudentId =0;
    double height =0;
    int HatSize =0;

    HW6dClass(String Fname,String Lname,int Sid,double hei,int hat)
    {
        FirstName = Fname;
        LastName = Lname;
        StudentId = Sid;
        height = hei;
        HatSize = hat;
    }

}
class HW6eClass{
    String ProductName = "";
    int number =0;
    int price =0;
    public float  myValuePlusVAT()
    {
        price = price +((int) (1.2 * price));
        return (float)price ;
    }

    HW6eClass HW6e(String name , int num, int pr)
    {
//        System.out.println("ProductName    Number   price");
        float price = myValuePlusVAT();
        HW6eClass H = new  HW6eClass();
        H.price = pr;
        H.number = num;
        H.ProductName = name;
        return H;
    }
}
class common{

    Button B;
    BurgerMenu BM;

    common HW6F()
    {
        common C = null;
        C.B.title = "";
        C.B.sizeClosed =3;
        C.B.penThickness = (float) 3.0;
        C.B.hoz = 3;
        C.B.vert =3;
        C.B.sizedOpen =3;
        C.BM.title="";
        C.BM.hoz =3;
        C.BM.vert =3;
        C.BM.sizedOpen=3;
        C.BM.totalWidth=3;
        C.BM.process=3;
        return C;
    }

}
class Button extends common

{

    String title ;
    int hoz, vert ;
    int sizedOpen;
    int sizeClosed ;
    float penThickness;

}
class BurgerMenu extends common
{

    String title ;
    int hoz, vert ;
    int sizedOpen;
    int totalWidth ;
    int process;

}


class HW6GStarterClass
{
    private String trackTitle ="";
    private  String album ="";
    private  String artistName ="";
    private  int trackLength = 0;
    private  String trackURL ="";
    private  int numberOfPlays = 0;
    private int numberOfLikes = 0;
    private  int trackRateing = 0;


    HW6GStarterClass HW6G()
    {
        HW6GStarterClass H = null;
        H.trackTitle ="";
        H.album ="";
        H.artistName = "";
        H.trackLength =0;
        H.numberOfPlays =0;
        H.trackLength =0;
        return H;
    }
}



public class Starting_Class {

    public static void main(String[] args) {

//        Part E

        System.out.println("\nQ4\n");
        HW6dClass d1 = new HW6dClass("Jenny","Banks",230230293,1.8,8);
        HW6dClass d2 = new HW6dClass("Brooklyn","Rockwood",90943049,2.1,12);
        HW6dClass d3 = new HW6dClass("Muhammad","Ahsan",230234393,2.0,12);   // set it to your name

        ArrayList<HW6dClass> al=new ArrayList<HW6dClass>();
        al.add(d1);
        al.add(d2);
        al.add(d3);

        System.out.println("First_Name Last_Name Sudent-ID Height HatSize");
        System.out.println(d1.FirstName + "      " + d1.LastName +"       "+ d1.height +"      " +d1.HatSize);
        System.out.println(d2.FirstName + "   " + d2.LastName +"    "+ d2.height +"      " +d2.HatSize);
        System.out.println(d3.FirstName + "   " + d3.LastName +"       "+ d3.height +"      " +d3.HatSize);


        HW6eClass H = new HW6eClass();
        System.out.println("\nQ5\n");
        H = H.HW6e("cheese",1,165);
        System.out.println("ProductName, number,  price");
        System.out.println(H.ProductName+"       "+H.number +"       "+ H.price);

    }
}
_