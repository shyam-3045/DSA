/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        Stack<Integer> st = new Stack<>();
        int max =0;
        ListNode curr = head ;
        int len =0;
        while(curr != null){
            st.push(curr.val);
            len++;
            curr = curr.next;
        }
        curr = head ;
        while ((len /2 ) > 0){
            int sum = curr.val + st.pop();
            max = Math.max(max , sum);
            len -- ;
            curr = curr.next ;
        }

        return max;

    }
}