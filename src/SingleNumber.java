public class SingleNumber {

    //My solution:
    public int singleNumber(int[] nums) {
        //most likely need to use an XOR comparison so that when two numbers that are the same get compared,
        //their bit signatures cancel out, so eventually you are only left with the odd one out
        int x = 0;
        for (int n : nums) {
            x = x ^ n;
        }
        return x;
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number.
    Memory Usage: 40.7 MB, less than 74.82% of Java online submissions for Single Number.
     */
}
