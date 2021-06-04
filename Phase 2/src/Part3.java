// Importing
import java.util.HashMap; // import the HashMap class


public class Part3 {

    public int Part3_solution(String docx)
    {
        String invert_index = "";
        String word = "";
        HashMap<String,String> InvertedIndexMap = new HashMap<String,String>();
        for(int i=0; i<docx.split(" ").length;i++)
        {
            invert_index = docx.split(" ")[i] + "   (1" +  "," + i + ")";
            InvertedIndexMap.put(docx.split(" ")[i], "   (1" +  "," + i + ")" );
        }
        System.out.println(InvertedIndexMap);
        return 0;

    }


    public static void main(String [] args)
    {
        Part3 p = new Part3();

        try
        {
            FileInputStream fis=new FileInputStream("Texting.txt");
            Scanner sc=new Scanner(fis);    //file to be scanned
            while(sc.hasNextLine())
            {
                System.out.println(sc.nextLine());      //returns the line that was skipped
                p.Part3_solution(sc.nextline);
            }
            sc.close();     //closes the scanner
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        int a = p.Part3_solution(" “hello everyone, ” “this article is based on inverted index, ” “which is hashmap like data structure”.");
    }

}
