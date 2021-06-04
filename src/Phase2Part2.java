import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Phase2Part2 {


    public int Part3_solution(String docx)
    {
        String invert_index = "";
        String word = "";
        for(int i=0; i<docx.split(" ").length;i++)
        {
            invert_index = docx.split(" ")[i] + "   (1" +  "," + i + ")";
        }
        return 0;

    }

    public static void Part_2()
    { 
        String docx = "";
        System.out.println("Hello world");
        try
        {
            //the file to be opened for reading
            FileInputStream fis=new FileInputStream("Stoplist_2.txt");
            Scanner sc=new Scanner(fis);    //file to be scanned
            //returns true if there is another line to read
            while(sc.hasNextLine())
            {
                System.out.println(sc.nextLine());      //returns the line that was skipped
                docx = sc.nextLine();
                docx = docx + " ";
                System.out.println(docx);
            }
            
            sc.close();     //closes the scanner
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }


    public static void main(String[] args)
    {
//        Phase2Part1 P = new Phase2Part1();
//        String stemming_word = P.stripAffixes("likes");
//        System.out.println(stemming_word);

        Phase2Part2 P1 = new Phase2Part2();
        P1.Part_2();
    }

}
