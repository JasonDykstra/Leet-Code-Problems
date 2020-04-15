import java.util.PriorityQueue;

public class LastStoneWeight {

    //My solution:
    public int lastStoneWeight(int[] stones) {
        //for this problem, the order of the array shouldn't matter as long as you can find the largest
        //values, which means we could either sort the initial array, or use a different data structure.
        //if we were to sort the original array, we would have to sort it each time we smash stones,
        //so I'll probably use a different data structure for this problem

        //use a priority queue and pop the two largest elements, then push back the result, or the difference
        //here, a lambda expression is used to
        PriorityQueue<Integer> stoneQueue = new PriorityQueue<>((a, b) -> b - a);

        for (int a : stones)
            stoneQueue.offer(a);

        //keep removing the largest two elements and put in the difference until there are 1 or 0 items left
        while (stoneQueue.size() > 1)
            stoneQueue.offer(stoneQueue.poll() - stoneQueue.poll());

        return stoneQueue.poll();
    }

    /*
    Runtime: 1 ms, faster than 87.24% of Java online submissions for Last Stone Weight.
    Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Last Stone Weight.
     */
}
