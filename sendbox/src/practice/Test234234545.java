package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Input: arr[] = [0, 2, 1, 2, 0]
Output: [0, 0, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.
 */
public class Test234234545 {
    String test = "";


    Test234234545(String k){
        this.test=k;

    }
    public void setTest(String s){
        this.test=s;
    }

    public String getTest(){
        return this.test;
    }

    public static void main(String[] args) {

        String html = """
              <html>
                 <body>Hello!</body>
              </html>
              """;

        List<Integer> ll = new ArrayList<>();
        ll.add(1);
        ll.add(2);
        System.out.println("ll-->"+ll);
        ll.remove(1);
        System.out.println("ll-->"+ll.size());

        String sasas="2     f";
        System.out.println(html);
        record Record(String a,String b){
            public void printName(){
                System.out.println("This is record"+a()+b());
            }
        };

        record Record1(String a,String b,Test234234545 test234234545){
            public void printName(){
                System.out.println("This is record"+a()+b());
            }
        };
        var r = new Record1("q","p", new Test234234545("TESTE"));
        System.out.println(r.a());
        r.printName();
        System.out.println(r.test234234545().getTest());
        r.test234234545().setTest("KKK");
        System.out.println(r.test234234545().getTest());

        int[] arr = {0, 2, 1, 2, 0};

        int[] out = new int[3];
        int l = 0, k = 0, j = 0;
        for (int i : arr) {
            if (i == 0) {
                out[0] = ++l;
            }
            if (i == 1) {
                out[1] = ++k;
            }
            if (i == 2) {
                out[2] = ++j;
            }
        }
        String str = IntStream.range(0, out[0]).mapToObj(i -> "0").collect(Collectors.joining(",")) + "," + IntStream.range(0, out[1]).mapToObj(i -> "1").collect(Collectors.joining(",")) + "," + IntStream.range(0, out[2]).mapToObj(i -> "2").collect(Collectors.joining(","));
        System.out.println(str);
    }

}
