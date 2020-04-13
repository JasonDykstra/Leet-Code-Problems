public class BackspaceStringCompare {

    //My solution (looked at discussion for guidance):
    public boolean backspaceCompare(String S, String T) {
        return formatString(S).equals(formatString(T));
    }

    //make a copy of the string and as you loop over the original, delete the backspaces from the new one which you return
    private String formatString(String s) {
        StringBuilder builder = new StringBuilder(s);
        int index = 0;
        for (int i = 0; i < s.length(); ++i){
            ++index;
            char c = s.charAt(i);
            //remove the backspace indicator and character that comes before it
            if (c == '#'){
                --index;
                builder.deleteCharAt(index);
                if (index > 0){
                    --index;
                    builder.deleteCharAt(index);
                }
            }
        }
        return builder.toString();
    }

    /*
    Runtime: 1 ms, faster than 62.36% of Java online submissions for Backspace String Compare.
    Memory Usage: 37.6 MB, less than 6.06% of Java online submissions for Backspace String Compare.
     */
}
