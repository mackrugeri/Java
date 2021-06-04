import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class week4_1 {
    public static void main(String[] args) {
//        map {1,2,23}
//        filter {}
//         Filter Even Odd
         List<Integer> evens=IntStream.range(1, 101) //1,2,3,4,5,6,7,8.....100
         .filter(x-> x%2==0) // 2,4,6,8...100
         .boxed()
         .collect(Collectors.toList());
         evens.forEach(e -> System.out.print(e+" "));

        //Map
        String arrayNames[]={"dEll","APPle","FaSt","GrEE"};
        List<String> names=Arrays.asList(arrayNames);
        List<String> resolvedNames=names.stream()
        .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1,str.length()).toLowerCase())
        .collect(Collectors.toList());  // [0].... 
        resolvedNames.forEach(e->System.out.println(e));
    }
}
