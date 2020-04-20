public class ProductOfArrayExceptSelf {

    //My first solution:
    public int[] productExceptSelf(int[] nums) {
        /*
        can find all elements by factorizing each multiplication step as you move through the array

        example:
        Array:           1      2      3      4
        Multiplication:  1     1*2   1*2*3 1*2*3*4
        Factorization:   1     1*2   1*2*3 1*2*3*4 2*3*4   3*4     4

        So in code, you need to find the progressive product from left to right and right to left
        */

        int[] answer = new int[nums.length];

        //calculate progressive product from left to right
        int left = 1;
        for(int i = 0; i < nums.length; ++i){
            if(i > 0) left = left * nums[i - 1];
            System.out.println("Left = " + left);
            answer[i] = left;
        }

        //right to left
        int right = 1;
        for(int i = nums.length - 1; i >= 0; --i){
            if(i < nums.length - 1) right = right * nums[i + 1];
            System.out.println("Right = " + right);
            answer[i] *= right;
        }

        return answer;
    }

    /*
    Runtime: 153 ms, faster than 5.48% of Java online submissions for Product of Array Except Self.
    Memory Usage: 47.4 MB, less than 5.51% of Java online submissions for Product of Array Except Self.
     */


    //My second (better) solution:
    public int[] productExceptSelf2(int[] nums) {
        /*
        can find all elements by factorizing each multiplication step as you move through the array

        example:
        Array:           1      2      3      4
        Multiplication:  1     1*2   1*2*3 1*2*3*4
        Factorization:   1     1*2   1*2*3 1*2*3*4 2*3*4   3*4     4

        So in code, you need to find the progressive product from left to right and right to left
        */

        int n = nums.length;
        int[] answer = new int[n];

        //no need to have a left variable if you can just use the answer array itself
        //left to right
        answer[0] = 1;
        for (int i = 1; i < n; ++i){
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        //right to left
        int right = 1;
        for (int i = n - 1; i >= 0; --i){
            answer[i] *= right;
            right *= nums[i];
        }

        return answer;
    }

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
    Memory Usage: 47.9 MB, less than 5.51% of Java online submissions for Product of Array Except Self.
     */
}
