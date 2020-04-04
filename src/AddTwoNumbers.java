public class AddTwoNumbers {

    //My solution:
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentNode1 = l1;
        ListNode previousNode1 = null;
        ListNode currentNode2 = l2;
        ListNode previousNode2 = null;

        ListNode answer = new ListNode(0);
        ListNode currentAnswerNode = answer;

        //continue to traverse the singly-linked list(s) until both terminate
        while(currentNode1 != null || currentNode2 != null){
            int node1Val = 0;
            int node2Val = 0;
            int carry = 0;

            //if one of the lists terminates, just 0 for that node's value
            if(currentNode1 != null){
                node1Val = currentNode1.val;
            }

            if(currentNode2 != null){
                node2Val = currentNode2.val;
            }

            //calculate the sum of the two nodes, and keep track of whether or not you need to carry a 1, then update the current node value
            carry = node1Val + node2Val;
            int total = carry + currentAnswerNode.val;
            currentAnswerNode.val = total%10;
            carry = (total - total%10)/10;

            //traverse to the next node(s)
            if(currentNode1 != null){
                previousNode1 = currentNode1;
                currentNode1 = currentNode1.next;
            }

            if(currentNode2 != null){
                previousNode2 = currentNode2;
                currentNode2 = currentNode2.next;
            }

            //create a new next-node as long as there are still items in either of the singly-linked lists, or if there is a carry
            if(currentNode1 != null || currentNode2 != null || carry > 0){
                currentAnswerNode.next = new ListNode(0);
                currentAnswerNode = currentAnswerNode.next;
                currentAnswerNode.val = carry;
            }
        }
        return answer;
    }

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers.
    Memory Usage: 39.8 MB, less than 99.37% of Java online submissions for Add Two Numbers.
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
