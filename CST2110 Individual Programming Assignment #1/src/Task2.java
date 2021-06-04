import java.util.Scanner;

public class Task2 {

    public static void game(String[][] twoDimentional, int value)
    {

        int row_num;
        int column_num;
        int row_num1;
        int column_num2;
        String  res1 = null;
        String res = null;

        for(int i =0; i<value;i++)
        {
            for(int j=0; j<value;j++)
            {
                System.out.print( "[    xxxxxx]  ");
            }
            System.out.println();
        }
        int flag =0;
        for(int k=0; k< value; k++ ) {
            System.out.println("Enter the Row Value: ");
            Scanner s = new Scanner(System.in);
            row_num = s.nextInt();

            System.out.println("Enter the Column Value: ");
            Scanner s1 = new Scanner(System.in);
            column_num = s1.nextInt();


            for (int i = 0; i <value; i++) {
                for (int j = 0; j < value; j++) {
                    if (i == row_num && j == column_num) {
                        System.out.print(twoDimentional[i][j] + "    ");

                    }
                    else {
                        System.out.print("[xxxxxx]    ");
                    }

                }
                System.out.println();
            }
            System.out.println("Enter the another Row Value: ");
            Scanner s2 = new Scanner(System.in);
            row_num1 = s2.nextInt();

            System.out.println("Enter the another  Column Value: ");
            Scanner s3 = new Scanner(System.in);
            column_num2 = s3.nextInt();


            for (int i = 0; i <value; i++) {
                for (int j = 0; j < value; j++) {
                    if (i == row_num && j == column_num) {
                        System.out.print(twoDimentional[i][j] + "    ");
                        res = twoDimentional[i][j];

                    }
                    else if( i == row_num1 && j == column_num2) {
                        System.out.print(twoDimentional[i][j] + "    ");
                        res1 = twoDimentional[i][j];

                    }
                    else {
                        System.out.print("[xxxxxx]    ");
                    }

                }
                System.out.println();
            }
            if(res == res1)
            {
                System.out.println("Match found");
            }
            else
            {
                System.out.println("Match Not founded");
            }
    } }

    public static void main(String[] args) {
//        Game Console

        System.out.println("----------------------------------");
        System.out.println("Welcome to the memory square game ");
        System.out.println("----------------------------------");

        System.out.println("\n \nEasy................ 1");
        System.out.println("Intermediate........2");
        System.out.println("Difficult...........3");
        System.out.println("Just give up now....0");

        System.out.println("Select your preferred level > 2\n");

        System.out.println("Enter the number");


        int enter_value = 2;


        if (enter_value == 1)
        {
            String[][] twoDimentional = {{"Abc","def"},{"def","Abc"}};
            game(twoDimentional,2);

        }else if ( enter_value == 2)
        {
            String[][] twoDimentional = {{"Abc","def","def","Abc"},{"Abc","def","Abc","def"},{"Abc","def","def","Abc"},{"Abc","def","Abc","def"}};
            game(twoDimentional,4);
        }else if (enter_value == 3)
        {
            String[][] twoDimentional = {{"Abc","def","def","Abc"},{"Abc","def","Abc","def"},{"Abc","def","def","Abc"},{"Abc","def","Abc","def"},
                    {"Abc","def","def","Abc"},{"Abc","def","Abc","def"},{"Abc","def","def","Abc"},{"Abc","def","Abc","def"}};
            game(twoDimentional,16);

        }else if (enter_value == 0)
        {
            System.out.println("You have quitted from the game");
        }
    }
}
