import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Part2 {


    public String inverted_index(String docx, int number)
    {
        Phase2Part1 P = new Phase2Part1();
        String invert_index = "";
        String stemming_word = "";
        String word = "";
        for(int i=0; i<docx.split(" ").length;i++)
        {
            invert_index = docx.split(" ")[i] + "   (1" +  "," + i + ")";
//            System.out.println((invert_index));
            if (number == 0)
            {
                 stemming_word = P.stripAffixes(invert_index);
                word = invert_index + "\n"+ word;
            }
            else{
                 stemming_word = " ";
                word = invert_index + "    Stemming " +stemming_word +"\n"+ word;
            }

//            word = invert_index + "    Stemming " +stemming_word +"\n"+ word;
        }
        return word;

    }

    public static void Part_2(int number ) {
        File file = null;
        FileWriter filewriter = null;
        Part2 P = new Part2();
        System.out.println("Hello world");
        try {
            file = new File("data.txt");
            //the file to be opened for reading
            FileInputStream fis = new FileInputStream("Texting.txt");
            filewriter = new FileWriter(file);
            Scanner sc = new Scanner(fis);    //file to be scanned
            //returns true if there is another line to read
            while (sc.hasNextLine()) {
//                System.out.println(sc.nextLine());      //returns the line that was
                String word = P.inverted_index(sc.nextLine(),number);
                filewriter.write(word);

            }

            sc.close();     //closes the scanner
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

        public static void main(String[] args)
    {
//        Phase2Part1 P = new Phase2Part1();
//        String stemming_word = P.stripAffixes("likes");
//        System.out.println(stemming_word);

        Part2 P1 = new Part2();
//        P1.Part_2(0);

//      Part3 is stemming allowed or not
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter user choice");

        int number = myObj.nextInt();  // Read user input
        P1.Part_2(1);

    }

}
