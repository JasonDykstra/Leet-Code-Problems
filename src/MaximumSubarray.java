public class MaximumSubarray {

    //My first solution:
    public int maxSubArray(int[] nums) {

        //key a dynamic sum of the numbers
        int sum = 0, max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            //if the sum is less than 0, reset it to 0
            //if the sum is positive, keep adding to it
            sum = sum < 0 ? nums[i] : sum + nums[i];

            //compare the sum to the max
            max = Math.max(sum, max);
        }
        return max;
    }

    /*
    Runtime 2ms, fast, but the fastest option would be a divide and conquer algorithm.

    Runtime: 2 ms, faster than 13.04% of Java online submissions for Maximum Subarray.
    Memory Usage: 42.2 MB, less than 5.16% of Java online submissions for Maximum Subarray.
     */
}
