import java.util.ArrayList;

public class CW5 {

    static int CW5A()
    {
        return ((2*4)+8)/2;
    }

    static double CW5B(int milePerhour)
    {
        return (2*1.60934);
    }
    static boolean CW5C(double temp)
    {
        if (temp > 25.0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static  void CW5D()
    {
        int count =0;
        for(int i =5;i<34;i++)
        {
            count++;
            System.out.println(i);
        }
    }
    static int CW5E(int[] array)
    {
        for(int i=0; i<array.length;i++)
        {
            if(array[i] > 0 || array[i] < -70)
            {
                return i;
            }
        }
        return -1;

    }
    static int CW5F(int[] array)
    {
        int index =-2;
        for(int i=0; i<array.length;i++)
        {
            if(array[i] > 0 || array[i] < -70)
            {
                index = i;
            }
        }
        if (index >=0)
        {
            return index;
        }
        return -1;
    }

    static int CW5G(ArrayList<String> check)
    {
        String var ="";
        int counter =0;
        for(int i =0; i<check.size(); i++)
        {
            var = check.get(i);
            int k = var.indexOf("x");
            if (k != -1)
            {
                counter++;
            }
        }
        return counter;

    }
    static String CW5H(String[] array)
    {
        int index = array.length/2;
        return array[index];

    }

    static String CW5M(String[] array) {
        String sb1 = array[0];
        String sb2 = array[1];
        String cat = "[";
        for (int i = 0; i < sb1.length(); i++) {
            for (int j = 0; j < sb2.length(); j++) {
                if ((sb1.charAt(i) == sb2.charAt(j) ) && (sb1.charAt(i) != ',')) {
                    cat = cat + sb1.charAt(i) +",";
                }
            }
        }
        return cat;
    }




    public static void main(String[] args) {

//        System.out.print(CW5A());
//        System.out.println(CW5B(2));
//        System.out.println(CW5C(25.0));

//        int[] array = {-23,-1,-34,-23,-45};
//        System.out.println(CW5E(array));
//        int [] array1 = {-23,-1,1,1,-45};
//        System.out.println(CW5F(array1));

//        ArrayList <String> check = new ArrayList<String>();
//        check.add("Hello");
//        check.add("xxxxxx");
//        check.add("hellox");
//        System.out.println(CW5G(check));

//        String[] array2 = {"1,2,3,4,5,6","1,3,5,7"};
////        System.out.println(CW5H(array2));
//        System.out.println(CW5M(array2));



    }


}
