import java.util.HashSet;

public class HappyNumber {

    //My solution (fast, but bad space complexity):
    public boolean isHappy(int n) {
        HashSet<Integer> used = new HashSet<Integer>();

        while(!used.contains(n)){
            //add num to used list
            used.add(n);

            //calculate new sum and update num
            int temp = 0;
            while(n != 0){
                temp += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = temp;

            //return true if you get 1 as the sum
            if(n == 1){
                return true;
            }

        }
        //otherwise, if the serires repeats, return false
        return false;
    }

    /*
    All the solutions I found in the discussion page had the same space and time complexity as my solution,
    so I'm gonna call that a win

    Runtime: 1 ms, faster than 84.38% of Java online submissions for Happy Number.
    Memory Usage: 36.4 MB, less than 6.06% of Java online submissions for Happy Number.
     */
}
