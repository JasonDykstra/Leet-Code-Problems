import java.util.Arrays;
import java.util.HashSet;

public class CountingElements {

    /*
    This problem was a daily challenge, but does not seem to be listed at the time of completion.

    Problem description:


    Given an integer array arr, count element x such that x + 1 is also in arr.

    If there're duplicates in arr, count them seperately.

    Example 1:
    Input: arr = [1,2,3]
    Output: 2
    Explanation: 1 and 2 are counted cause 2 and 3 are in arr.

    Example 2:
    Input: arr = [1,1,3,3,5,5,7,7]
    Output: 0
    Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.

    Example 3:
    Input: arr = [1,3,2,3,5,0]
    Output: 3
    Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.

    Example 4:
    Input: arr = [1,1,2,2]
    Output: 2
    Explanation: Two 1s are counted cause 2 is in arr.


    Constraints:
    1 <= arr.length <= 1000
    0 <= arr[i] <= 1000

     */

    //My solution:
    public int countElements(int[] arr) {
        //Create a hashset to store all values
        HashSet<Integer> nums = new HashSet<Integer>();

        //add all values to hashset
        for(int i = 0; i < arr.length; ++i){
            nums.add(arr[i]);
        }

        int answer = 0;
        int counter = 0;

        //sort the array so that everything is in sequential order
        Arrays.sort(arr);

        //go over values in arr and see if the succeeding number is in the hash set, if so, add to the counter
        //otherwise, reset the counter
        for(int i = 0; i < arr.length; ++i){
            if(nums.contains(arr[i] + 1)){
                ++counter;
                answer = counter > answer ? counter : answer;
            }
        }

        return answer;
    }

    /*
    Runtime: 1 ms
    Memory Usage: 37.4 MB
     */
}
