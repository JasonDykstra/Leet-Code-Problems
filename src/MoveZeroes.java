public class MoveZeroes {

    //My first solution (slow):
    public void moveZeroes(int[] nums) {
        int numZeroes = 0;
        int index = 0;
        int lookaheadIndex = 0;

        //while both indices are within range...
        while(lookaheadIndex < nums.length && index < nums.length){
            //set your lookahead index to always be >= current marching index
            lookaheadIndex = Math.max(index + 1, lookaheadIndex);

            //when you hit a zero, increase the lookahead index until you find a non-zero value
            //and replace the zero you hit with that value
            while(nums[index] == 0 && lookaheadIndex < nums.length){
                numZeroes += nums[lookaheadIndex] == 0 ? 1 : 0;
                nums[index] = nums[lookaheadIndex];
                nums[lookaheadIndex] = 0;

                ++lookaheadIndex;
            }
            ++index;
        }

        //add all the zeroes to the end of the array
        for(int i = nums.length - 1; i > nums.length - numZeroes; --i){
            nums[i] = 0;
        }
    }

    /*
    Runtime: 2 ms, faster than 14.55% of Java online submissions for Move Zeroes.
    Memory Usage: 41.7 MB, less than 5.59% of Java online submissions for Move Zeroes.
     */


    //My second solution:
    public void moveZeroes2(int[] nums) {
        //A more refined, efficient version of my previous attempt, removing verbose code

        int i = 0;
        int lookahead = 0;

        //same concept as before; loop over the array
        while (lookahead < nums.length) {

            //replace the marching index with non-zero values you find using the lookahead index
            if (nums[lookahead] != 0) {
                nums[i++] = nums[lookahead];
            }

            lookahead++;
        }

        //after replacing the start of the array with non-zero values, fill the rest of the array with zeroes
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }

    /*
    For this attempt, I removed a lot of uneccessary code, such as marching the start index until I found a zero,
    which could be done in a much simpler fashion by using the lookahead index to find non-zero values and just replace
    the marching index value.

    Runtime was still 1ms but not sure how to improve it beyond that.

    Runtime: 1 ms, faster than 17.70% of Java online submissions for Move Zeroes.
    Memory Usage: 41.8 MB, less than 5.59% of Java online submissions for Move Zeroes.
     */

}
