public class PerformStringShifts {

    //My solution:
    public String stringShift(String s, int[][] shift) {
        //sum up all the shifts to perform only one final shift
        int finalShift = 0;

        for(int i = 0; i < shift.length; ++i){
            finalShift += (shift[i][0] == 0 ? -shift[i][1] : shift[i][1]);
        }

        //get rid of any wraps
        finalShift %= s.length();

        //account for left or right rotations
        if(finalShift >= 0){
            return (s.substring(s.length() - finalShift) + s.substring(0, s.length() - finalShift));
        } else {
            return (s.substring(-finalShift) + s.substring(0, -finalShift));
        }
    }

    /*
    Not listed under problems, found in 30-Day LeetCoding Challenge

    Runtime: 0 ms
    Memory Usage: 39.7 MB
     */
}
