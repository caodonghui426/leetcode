package Q19;

public class Main {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Solution solution = new Solution();
        ListNode res = solution.removeNthFromEnd(node1, 2);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for(int i = 0; i < n + 1; i++){
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = temp.next;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.next = next;
    }
}