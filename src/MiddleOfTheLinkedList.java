import java.util.HashMap;

public class MiddleOfTheLinkedList {

    //My solution:
    public ListNode middleNode(ListNode head) {
        //use a counter to store values in a hashmap using the counter as an index
        int index = 0;
        HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();

        //loop over the values in the nodes and add them to the hashmap
        while(head != null){
            ++index;
            map.put(index, head);
            head = head.next;
        }

        //calculate the middle index of the list
        int middleIndex = index % 2 == 0 ? index/2 + 1 : (int)(index/2) + 1;

        //return the middle node
        ListNode middleNode = map.get(middleIndex);

        return middleNode;

    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
    Memory Usage: 36.7 MB, less than 7.84% of Java online submissions for Middle of the Linked List.
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


