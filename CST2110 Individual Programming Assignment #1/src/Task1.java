import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Task1 {
    static void detection(Dictionary vovels, Dictionary consonant,String encoding_var)
    {
        String var = "";
        String Result ="";
        int flag = 1;

        for(int i =0; i< encoding_var.length();i++)
        {
            if(encoding_var.charAt(i) == 'V')
            {
                if (flag == 2)
                {
                    Result = Result + vovels.get(var);
                }
                else if (flag ==3)
                {
                    Result = Result + consonant.get(var);
                }
                var = "";
                flag =2 ;
            }
            else if(encoding_var.charAt(i) == 'C')
            {
                if(flag ==2 )
                {
                    Result = Result + vovels.get(var);
                }
                else if (flag == 3)
                {
                    Result = Result + consonant.get(var);
                }

                var = "";
                flag = 3;
            }
            else
            {
                var = var + encoding_var.charAt(i);
            }
        }
        if(flag == 2)
        {
            Result = Result + vovels.get(var);
        }
        else if (flag == 3)
        {
            Result = Result + consonant.get(var);
        }

        System.out.println(Result);
    }

    public static void main(String[] args) {
        Dictionary vovels = new Hashtable();

        vovels.put("1","a");
        vovels.put("2","A");
        vovels.put("3","e");
        vovels.put("4","E");
        vovels.put("5","i");
        vovels.put("6","I");
        vovels.put("7","o");
        vovels.put("8","O");
        vovels.put("9","u");
        vovels.put("10","U");
        vovels.put("11","y");
        vovels.put("12","Y");

        Dictionary consonant = new Hashtable();

        consonant.put("1","b");
        consonant.put("2","B");
        consonant.put("3","c");
        consonant.put("4","d");
        consonant.put("5","D");

        consonant.put("6","f");
        consonant.put("7","F");
        consonant.put("8","g");
        consonant.put("9","G");
        consonant.put("10","h");

        consonant.put("11","H");
        consonant.put("12","j");
        consonant.put("13","J");
        consonant.put("14","k");
        consonant.put("15","k");
        consonant.put("16","K");
        consonant.put("17","l");
        consonant.put("18","L");
        consonant.put("19","m");
        consonant.put("20","M");

        consonant.put("21","n");
        consonant.put("22","N");
        consonant.put("23","p");
        consonant.put("24","P");
        consonant.put("25","q");
        consonant.put("26","Q");
        consonant.put("27","r");
        consonant.put("28","R");
        consonant.put("29","s");
        consonant.put("30","S");

        consonant.put("31","t");
        consonant.put("32","T");
        consonant.put("33","v");
        consonant.put("34","V");
        consonant.put("35","w");
        consonant.put("36","W");
        consonant.put("37","x");
        consonant.put("38","X");
        consonant.put("39","z");
        consonant.put("40","Z");

        String encoding_var = "V2C23C23C17V3C29";
        detection(vovels,consonant,encoding_var);

    }
}
