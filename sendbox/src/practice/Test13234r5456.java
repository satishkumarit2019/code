package practice;

import java.util.stream.Collectors;

public class Test13234r5456 {
    public static void main(String[] args) {

    }

    //Write a program to find the first non-repeating character in a given string. If all characters are repeated, return a message saying so.
    public Character nonRepeatingChar(String inputStr){
       return inputStr.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting())).entrySet().stream().filter(e->e.getValue()==1).map(e->e.getKey()).findFirst().orElse(null);
    }
}
