package practice;

import java.util.stream.IntStream;

public class Factorial2133453532 {
    public static void main(String[] args) {
        System.out.println(factorialRec(10));
        System.out.println(factorialNonRec(10));
        System.out.println(factorialStream(10));

    }

    public static long factorialRec(long i){
        if(i==1) {
            return 1;
        }
        else {
            return i*factorialRec(i-1);
        }
    }

    public static long factorialNonRec(long i){
        long result=1;
        for(int j=1;j<=i;j++){
            result=result*j;
        }
        return result;
    }

    public static int factorialStream(int i){
        return IntStream.range(1,i+1).reduce((a,b)->a=a*b).orElse(1);
    }


}
