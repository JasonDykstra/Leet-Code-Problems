import java.util.HashMap;
import java.util.Map;

public class ContiguousArray{

    //My solution:
    public int findMaxLength(int[] nums) {
        /*
        replace zeroes in the array with -1 and march along the array while summing up everything behind the
        current index. Store the sums in a hash map using the sum as the key, and the current index as the value.
        When you come across a sum you have already seen, the length of the contiguous sub-array is going to be
        i - hashMap.get(sum). This way, smaller sub-arrays will be counted but larger ones will overwrite them.
        Here are some examples:

        nums: -1, -1, 1, 1
        (key, value) for hash map
        (0, -1)
        (-1, 0)
        (-2, 1)
        (-1, 2) sum of -1 is already a key in the hash map! max = 2 - 0 = 2
        (0, 3) sum of 0 is already a key in the hash map!max = 3 - (-1) = 4

        Here's an example where a longer sub-array overwrites a smaller one:
        nums: -1, 1, -1, 1
        (0, -1)
        (-1, 0)
        (0, 1) sum of 0 is already a key in the hash map!max = 1 - (-1) = 2
        (-1, 2)
        (0, 3) sum of 0 is already a key in the hash map!max = 3 - 1 = 2
        */

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        //start with sum of 0 at index -1 to cover cases where the entire array is the sub-array
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;


        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            //if the sum has been seen in the hash map already, update max
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            }

            //if not, add it to the hash map with value of current index
            else {
                sumToIndex.put(sum, i);
            }
        }
        return max;
    }

    /*
    Runtime: 20 ms, faster than 76.63% of Java online submissions for Contiguous Array.
    Memory Usage: 49.4 MB, less than 100.00% of Java online submissions for Contiguous Array.
     */
}
