public class PalindromeNumber {

    // My first solution
    public boolean isPalindrome(int x) {
        // Start by converting x to a string
        String testPalindrome = Integer.toString(x);

        // Test if the number is a palindrome by seeing if the first half is equal to the second half
        for(int i = 0; i < Math.floor(testPalindrome.length()/2); i++){
            if(testPalindrome.charAt(i) != testPalindrome.charAt(testPalindrome.length() - i - 1)) return false;
        }
        return true;
    }

    /*
    Runtime: 8 ms, faster than 45.47% of Java online submissions for Palindrome Number.
    Memory Usage: 38.3 MB, less than 79.23% of Java online submissions for Palindrome Number.
     */

    // This could be done faster without strings by reversing the number and comparing the two digit by digit.
    // I chose not to use this method for this problem simply because it involves a lot of dividing and
    // Modulo operations which would make the code harder to understand.


}
