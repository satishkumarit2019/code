package practice;

import java.util.HashSet;
import java.util.Set;

public class Test1234 {
    public static void main(String[] args) {
       //System.out.println(nonRepeatingSubStringLength("abcabcbb")); // Output: 3
       System.out.println(nonRepeatingSubStringLength("bacabdcbb")); // Output: 3
        //System.out.println(nonRepeatingSubStringLength("bbbbb"));    // Output: 1
       // System.out.println(nonRepeatingSubStringLength("pwwkewrthfyukjfthdgaehrtsawe"));  // Output: 4
    }

    //Given a string s, find the length of the longest substring without repeating characters.
    public static int nonRepeatingSubStringLength(String inStr){
        char[] chars = inStr.toCharArray();
        Set<Character> charsSet=new HashSet<Character>();
        int start=0;
        int stringStart=0;
        int stringEnd=0;
        int maxLength=0;
        for(int end=0;end<chars.length;end++){
            char currentChar=chars[end];
            //System.out.println("inStr::"+inStr);
            //System.out.println("currentChar::"+currentChar);
            while(charsSet.contains(currentChar)){
                charsSet.remove(chars[start]);
                start++;
            }
            charsSet.add(currentChar);


            int beforeMaxLength=maxLength;
            System.out.println("before maxLength: " + maxLength);
            maxLength=Math.max(maxLength,end-start+1);
            int afterMaxLength=maxLength;
            if(afterMaxLength>beforeMaxLength){
                stringStart=start;
                stringEnd=end;
            }
            System.out.println("Start: "+start+" end: "+end);
            System.out.println("before maxLength: " + maxLength);
        }
        System.out.println(inStr.substring(stringStart,stringEnd+1));
        return maxLength;
    }
}
