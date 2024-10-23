package practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice1 {
    public static void main(String[] args) {
        String srt = "swiisswk";

        var list = new ArrayList<String>();


        //System.out.println(findFirstNonRepeatingChar(srt));
        //method1();
        method2();
        var jjk=0;
    }

    public static String findFirstNonRepeatingChar(String str){
          return str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting())).entrySet().stream().filter(e1->e1.getValue()==1).map(e2->e2.getKey().toString()).findFirst().orElse(null);
         /// return e!=null? ""+e.getKey(): null;
    }

    /*
    Two Sum
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to the target.
    Example:
    Input: nums = [2, 7, 11, 15], target = 9
    Output: [0, 1]
     */

    public static void method1() {
        int[] ss = {2, 7, 11, 150};
        int target = 9;

        // Use a HashMap to store the elements and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < ss.length; i++) {
            int lookup = target - ss[i];

            // Check if the complement exists in the HashMap
            if (map.containsKey(lookup)) {
                System.out.println(map.get(lookup) + "," + i);
                return; // Exit after finding the first valid pair
            }

            // Store the element with its index in the HashMap
            map.put(ss[i], i);
        }
    }
    /*
    Longest Palindromic Substring
    Find the longest substring in a given string that reads the same forward and backward.
    Example:
    Input: "babad"
    Output: "bab" or "aba"
     */

    public static void method2(){
        String str = "babadaabaa";
        Set<String> substrings = new LinkedHashSet<String>();
        for(int i=0;i < str.length(); i++){
            for(int j=2; i+j<=str.length(); j++){
                String sub = str.substring(i,i+j);
                if(sub.length()>1)
                    substrings.add(sub);
            }
        }
        System.out.println(substrings);
        //substrings.stream().filter(s -> s.contentEquals(new StringBuilder(s).reverse())).forEach(System.out::println);
        System.out.println(substrings.stream().filter(s -> s.contentEquals(new StringBuilder(s).reverse())).max(Comparator.comparingInt(String::length)).orElse(null));
    }

    /*
    Input: arr = [1, -1, 5, -2, 3], target = 3
    Output: 4
    Explanation: The longest subarray with sum 3 is [1, -1, 5, -2].
     */

    public static void method3(){
       int[] arr = {1, -1, 5, -2, 3};
       int target = 3;
       List<Integer> list= IntStream.of(arr).boxed().toList();

    }
}
