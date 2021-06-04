import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class week4_2 {
    public static void main(String[] args) {
        List<String> dataPoints=new ArrayList<>();
        dataPoints.add("5,3,9");
        dataPoints.add("6,,7");
        dataPoints.add("2,3,7");
        dataPoints.add("2,4,8");
        dataPoints.add(",8,5");

        List<String[]> goodDataPoints=dataPoints.stream() //"5,3,9" , "6,,7" ..
        .map(a->a.split(",")) //{"5", "3" ,"9"} {"6", "", "7"}..
        .filter(b-> !b[0].equals("") && !b[1].equals("") && !b[2].equals("")) // true && false && true =false
        .collect(Collectors.toList());
        // .forEach(c-> System.out.println(c[0]+","+c[1]+","+c[2]));          
    }   
}
