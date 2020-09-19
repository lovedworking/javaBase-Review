package algorithm.LinkedList;

public class HasCycle {
    public static void main(String[] args) {

    }
    //如果有环 那么快的总能追上慢的
    public static boolean hasCycle(ListNode head){
        if(head==null||head.next==null||head.next.next==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) return true;
        }
        return false;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }