import java.util.Stack;

class GFC{

    static boolean isOperator(char x){
        switch (x){
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    static String prefixToPostfix(String prefix_exp){

        Stack<String> s= new Stack<String>();

        int l = prefix_exp.length();

        for(int i = l-1; i >= 0; i--){
            if(isOperator(prefix_exp.charAt(i))){

                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();

                String temp = op1 + op2 + prefix_exp.charAt(i);

                s.push(temp);
            }

            else{
                s.push(prefix_exp.charAt(i)+"");
            }
        }

        return s.peek();
    }

    public static void main(String args[]){

        String prefix_exp = "*-A/BC-/ADE";
        System.out.println("Postfix : " + prefixToPostfix(prefix_exp));

    }
}