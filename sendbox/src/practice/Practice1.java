package practice;

import java.util.Map;
import java.util.stream.Collectors;

public class Practice1 {
    public static void main(String[] args) {
        String srt = "swiisswk";
        System.out.println(findFirstNonRepeatingChar(srt));

    }

    public static String findFirstNonRepeatingChar(String str){
          return str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting())).entrySet().stream().filter(e1->e1.getValue()==1).map(e2->e2.getKey().toString()).findFirst().orElse(null);
         /// return e!=null? ""+e.getKey(): null;
    }


}
