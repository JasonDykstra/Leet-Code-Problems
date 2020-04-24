public class ValidParenthesisString {

    //My solution (looked at discussion for idea):
    public boolean checkValidString(String s) {
        //keep track of number of unpaired '('
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                //if there are more '(' than ')' then treat the '*' as a ')'
                //this way, when low < 0 the string can still be valid
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Parenthesis String.
    Memory Usage: 37.3 MB, less than 5.00% of Java online submissions for Valid Parenthesis String.
     */
}
