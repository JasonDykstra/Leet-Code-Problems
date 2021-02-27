import java.util.Arrays;
import java.util.HashSet;

// My first solution using hash sets
class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(Arrays.asList(nums).size() != nums.length) return true;
        else return false;
    }

    /*
    Runtime: 10 ms, faster than 14.71% of Java online submissions for Contains Duplicate.
    Memory Usage: 53.7 MB, less than 7.43% of Java online submissions for Contains Duplicate.
    */

    // My second solution, after remembering Arrays.sort might be faster than hash sets
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }

    /*
    Runtime: 3 ms, faster than 99.69% of Java online submissions for Contains Duplicate.
    Memory Usage: 41.8 MB, less than 97.97% of Java online submissions for Contains Duplicate.
     */

}



