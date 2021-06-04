import java.util.Arrays;
import java.util.List;

//reduce
//map
//filter

public class week3_3 {
    public static void main(String[] args) {
         String array[]={"a","a","c","d"};
         List<String> list=Arrays.asList(array);
         System.out.println(list.stream().anyMatch( var -> var=="b"));
        Integer intArray[]={99,80,20,1,3,4,5,6,23,32,5,3,32,5};
        List<Integer> intList=Arrays.asList(intArray);


        intList.stream()
        .distinct() //{99,80,20,1,3,4,5,6,23,32,3}
        .skip(2)    //{20,1,3,4,5,6,23,32,3}
        .sorted()   //sorted
        .forEach(x-> System.out.print(x+" "));

        
    }
}
