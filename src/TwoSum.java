import java.util.HashMap;

public class TwoSum {

    //My solution:
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            //find dif between target and number
            int difference = target - nums[i];
            //check map to see if num is a key in map
            if(hash.containsKey(difference)){
                //if it is, use the key and current index to return two indices
                int answer[] = {hash.get(difference), i};
                return answer;
            }

            //use the value as the key and the index as the map values
            hash.put(nums[i], i);
        }
        return null;
    }

    /*
    Runtime: 1 ms, faster than 99.89% of Java online submissions for Two Sum.
    Memory Usage: 39.2 MB, less than 14.70% of Java online submissions for Two Sum.


     */
}
