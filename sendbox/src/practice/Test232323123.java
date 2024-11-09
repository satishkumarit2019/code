package practice;

import java.util.List;
import java.util.stream.Collectors;

public class Test232323123 {
    public static void main(String[] args) {
        //firstNonRepeatingChar("swiss");
        //firstNonRepeatingChar("relevel");
        //firstNonRepeatingChar("aabbcc");
        //  int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
          int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18},{15,17},{16,19},{20,22},{21,26}};
        //  int[][] intervals = {{1,4}, {4,5}};
        mergeIntervals(intervals);
    }

    public static void firstNonRepeatingChar(String str){

        str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting())).entrySet().stream().filter(e->e.getValue()==1).findFirst().ifPresent(r->System.out.println(r.getKey()));


       // return 'C';
    }

    /*
Input: [[1,3], [2,6], [8,10], [15,18]]
Output: [[1,6], [8,10], [15,18]]

Input: [[1,4], [4,5]]
Output: [[1,5]]

//

     */

    public static List<int[]> mergeIntervals(int[][] intervals){
        int[][] result = new int[intervals.length][intervals[0].length];
        result[0][0]=intervals[0][0];
        result[0][1]=intervals[0][1];
        int k=0;
            for(int i=1;i<intervals.length; i++){
                if(result[k][1]>=intervals[i][0]){
                    result[k][1]=intervals[i][1];
                }else {
                    k++;
                    result[k][0]=intervals[i][0];
                    result[k][1]=intervals[i][1];
                }

            }
        for(int i=1;i<result.length; i++) {
            System.out.print(result[i - 1][0] + ":");
            System.out.println(result[i - 1][1]);
        }
        return null;
    }
}
