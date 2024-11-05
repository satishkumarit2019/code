package practice;

import java.security.KeyStore;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 Here's a coding challenge for you that will test your skills in algorithm design, data structures, and efficient data retrieval.

 Coding Challenge: Find the First Unique Character in a Stream
 You need to design a data structure that accepts characters one by one from a stream and, after each insertion, can return the first non-repeating character in the stream.

 Requirements:
 Implement two main methods:
 insert(char c): This method should insert a character into the data structure.
 getFirstUnique(): This method should return the first non-repeating character in the stream after each insertion. If there is no unique character, return None.
 Example:

 Given the stream of characters: ['a', 'b', 'a', 'c', 'd', 'b', 'c']

 After inserting 'a', the first unique character is 'a'.
 After inserting 'b', the first unique character is 'a'.
 After inserting another 'a', the first unique character is 'b'.
 After inserting 'c', the first unique character is 'b'.
 After inserting 'd', the first unique character is 'b'.
 After inserting another 'b', the first unique character is 'c'.
 After inserting another 'c', the first unique character is 'd'.

 */


public class Test35345464346 {
    public static void main(String[] args) {
        Base b= new BaseImpl();
        b.insert('a');
        System.out.println(b.getFirstUnique());
        b.insert('a');
        System.out.println(b.getFirstUnique());
        b.insert('b');
        System.out.println(b.getFirstUnique());
        b.insert('c');
        System.out.println(b.getFirstUnique());
        b.insert('b');
        System.out.println(b.getFirstUnique());

    }
}

interface Base {
    public void insert(char c);
    public Character getFirstUnique();
}

enum Visited {
    YES,
    NO
}

class BaseImpl implements Base {
    Map<Character,Visited> unique = new LinkedHashMap<Character,Visited>();
    @Override
    public void insert(char c) {
        if(unique.containsKey(c)){
            unique.put(c,Visited.YES);
        } else {
            unique.put(c,Visited.NO);
        }
    }

    @Override
    public Character getFirstUnique() {
       Optional<Map.Entry<Character,Visited>> resu= unique.entrySet().stream().filter(e->e.getValue()==Visited.NO).findFirst();
        return resu.map(Map.Entry::getKey).orElse(null);

    }
}