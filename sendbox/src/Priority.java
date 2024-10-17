import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Priority {
    public static void main(String[] args) {
        int[] numarray = {4,2,1,3,5};
        int k=3;
        PriorityQueue minHeap=new PriorityQueue();
        for(int num:numarray){
            minHeap.offer(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
            System.out.println(minHeap.peek());
        }

    }

}
