import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Part3 {


    public String inverted_index(String docx, int number)
    {
        Phase2Part1 P = new Phase2Part1();
        String word = "";
        String invert_index = "";
        for(int i=0; i<docx.split(" ").length;i++) {
            invert_index = docx.split(" ")[i] + "   (1" + "," + i + ")";
            word = invert_index + "\n" + word;
        }
        return word;

    }

    public static void Part_2(int number ) {
        File file = null;
        FileWriter filewriter = null;
        Part3 P = new Part3();
        System.out.println("Hello world");
        try {
            file = new File("data.txt");
            //the file to be opened for reading
            FileInputStream fis = new FileInputStream("Texting.txt");
            filewriter = new FileWriter(file);
            Scanner sc = new Scanner(fis);    //file to be scanned
            filewriter.write("Doc Name "+ file.getName() +"\n");
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

        Part3 P1 = new Part3();
        P1.Part_2(0);




    }

}
