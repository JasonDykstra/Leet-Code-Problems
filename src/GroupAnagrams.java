import java.util.*;

public class GroupAnagrams {

    //My first solution (very slow):
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<List<String>>();

        HashMap<HashMap<Character, Integer>, ArrayList<String>> anagrams = new HashMap<HashMap<Character, Integer>, ArrayList<String>>();

        for(int i = 0; i < strs.length; ++i){
            String word = strs[i];

            //add to the anagrams map if the letters in the current value match the letters in the hash set
            HashMap<Character, Integer> tempSet = new HashMap<Character, Integer>();
            for(int j = 0; j < word.length(); ++j){

                //add to the tempset
                tempSet.put(word.charAt(j), tempSet.containsKey(word.charAt(j)) ? tempSet.get(word.charAt(j)) + 1 : 1);
            }
            if(anagrams.containsKey(tempSet)){
                anagrams.get(tempSet).add(word);
            } else {
                ArrayList<String> tempList = new ArrayList<String>();
                tempList.add(word);
                anagrams.put(tempSet, tempList);
            }


        }

        for(HashMap<Character, Integer> c : anagrams.keySet()){
            ArrayList<String> tempAnagramList = new ArrayList<String>();
            tempAnagramList = anagrams.get(c);
            answer.add(tempAnagramList);
        }


        return answer;
    }

    /*
    Runtime: 77 ms, faster than 5.01% of Java online submissions for Group Anagrams.
    Memory Usage: 47 MB, less than 8.19% of Java online submissions for Group Anagrams.
     */


    //My second solution (faster):
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String,ArrayList> H = new HashMap<>();

        for(int i = 0; i < strs.length; ++i){
            //put the characters of each word into a list, then sort it
            char letters[] = strs[i].toCharArray();
            Arrays.sort(letters);
            String a = new String(letters);

            //if the string is already in the map, add it to the ArrayList associated with that key
            if(H.containsKey(a)){
                ArrayList<String> B = H.get(a);
                B.add(strs[i]);
                H.put(a, B);

                //if not, create a new ArrayList for it
            } else{
                ArrayList<String> B = new ArrayList<>();
                B.add(strs[i]);
                H.put(a,B);
            }
        }

        //loop over the values in the hash set and add them to the answer list
        List<List<String>> answer = new LinkedList<>();
        for(String s: H.keySet()){
            List<String> B = H.get(s);
            answer.add(B);
        }
        return answer;
    }

    /*
    I looked at the example response for the majority of the answers, and saw they were using Arrays.sort.
    This was my original plan, but disregarded it since I thought it would be slower than using a HashMap.

    The fastest way to do this problem would be to associate each anagram with an Integer key,
    using primes for uniqueness.

    Runtime: 18 ms, faster than 20.59% of Java online submissions for Group Anagrams.
    Memory Usage: 54.3 MB, less than 5.26% of Java online submissions for Group Anagrams.
     */
}
