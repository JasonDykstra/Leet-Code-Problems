import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    //My first solution (very slow):
    public int lengthOfLongestSubstring(String s) {
        //best possible time complexity I can imagine would be to loop over the string once,
        //while simultaneously finding substrings with break-away loops, resulting in an O(n^2) worse case

        int longestString = 0;

        for(int i = 0; i < s.length(); ++i){
            //System.out.println("new iteration");
            int counter = 0;
            HashSet<Character> letters = new HashSet<Character>();
            //start with the current index and continue along creating a larger and larger substring
            //until you hit a repeat character or hit the end of the string, then compare to the longest stored string
            for(int j = i; j < s.length(); ++j){

                //if you hit a repeating character, compare to longest string then break
                if(letters.contains(s.charAt(j))){
                    longestString = counter > longestString ? counter : longestString;
                    break;
                }

                letters.add(s.charAt(j));
                ++counter;

                //if you hit the end of the string
                if(j == s.length() - 1){
                    longestString = counter > longestString ? counter : longestString;
                }
            }
        }

        return longestString;
    }

    /*
    Runtime: 104 ms, faster than 11.37% of Java online submissions for Longest Substring Without Repeating Characters.
    Memory Usage: 40.2 MB, less than 8.27% of Java online submissions for Longest Substring Without Repeating Characters.
     */




    //My second solution (also very slow):
    public int lengthOfLongestSubstring2(String s) {
        //Another possibility I can think of is to iterate over the string and dynamically add and remove characters
        //from a linked hash map as they appear and repeat, then use a counter to keep track of current substring length
        //I would also need a string to keep track of the order of letters, and use the hash map to reference the index
        //of the letters

        int longestSubstring = 0;
        String dynamicSubstring = "";

        for(int i = 0; i < s.length(); i++){

            //if a character repeats
            if(dynamicSubstring.indexOf(s.charAt(i)) != -1){

                //compare length of string to longestSubstring
                longestSubstring = dynamicSubstring.length() > longestSubstring ? dynamicSubstring.length() : longestSubstring;

                //remove characters from dynamic substring
                int removeIndex = dynamicSubstring.indexOf(s.charAt(i)) + 1;
                dynamicSubstring = dynamicSubstring.substring(removeIndex);


            }

            //update the dynamic substring
            dynamicSubstring += s.charAt(i);

            //update longestSubstring if you are at the end of the string
            if(i == s.length() - 1){
                longestSubstring = dynamicSubstring.length() > longestSubstring ? dynamicSubstring.length() : longestSubstring;
            }

        }
        return longestSubstring;
    }

    /*
    Runtime: 12 ms, faster than 23.03% of Java online submissions for Longest Substring Without Repeating Characters.
    Memory Usage: 40.4 MB, less than 7.56% of Java online submissions for Longest Substring Without Repeating Characters.
     */



    //My third solution (better):
    public int lengthOfLongestSubstring3(String s) {
        //going back to the "sliding window" method, I revisited the idea of using a hashmap

        HashMap<Character, Integer> letters = new HashMap<>();
        int start = 0;
        int end = 0;
        int longestSubstring = 0;
        int len = s.length();

        //same idea as a for loop; loop over the string using a moving "window" or dynamic start and end indices
        while (end < len) {
            char c = s.charAt(end);

            //check to see if the character at the current index is already in the map or not
            int index = letters.getOrDefault(c, -1);

            //if the character is in the map, update the start index
            if (index != -1) {
                start = Math.max(start, index + 1);
            }

            //update the character's index in the map regardless of whether or not it is already in there
            letters.put(c, end);

            //compare the current substring length to longestSubstring
            longestSubstring = Math.max(longestSubstring, end - start + 1);

            //go to the next iteration
            end++;
        }
        return longestSubstring;
    }

    /*
    Runtime: 5 ms, faster than 86.92% of Java online submissions for Longest Substring Without Repeating Characters.
    Memory Usage: 40 MB, less than 10.62% of Java online submissions for Longest Substring Without Repeating Characters.
     */


    //Answer:
    public int lengthOfLongestSubstring4(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }

    /*
    After some research I found this solution. Basically a more efficient version of what I was attempting to write.
    This version uses an array as opposed to a hashmap since accessing elements and adding elements to an array is
    faster than accessing and adding values in a hashmap.

    Runtime: 2 ms, faster than 99.83% of Java online submissions for Longest Substring Without Repeating Characters.
    Memory Usage: 39.3 MB, less than 18.17% of Java online submissions for Longest Substring Without Repeating Characters.
     */


}
