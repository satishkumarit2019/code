package practice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Testvdfv123123123 {

    public static void main(String[] args) {

        String[] arr = {"hsatis","abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm", "satish","atishs","banti","antib" };


        List<String> list = List.of(arr);

        list.stream().collect(Collectors.groupingBy(k->k.chars().sorted() .mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining()))).forEach((k,v)->System.out.println(v));



    }





}
