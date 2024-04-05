package Q86;

public class Main {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        Solution solution = new Solution();
        ListNode res = solution.partition(node1, 3);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}

class Solution {
    public ListNode partition(ListNode head, int x) {
        // 创建两个链表，分别是大于等于x和小于x
        ListNode dummy1 = new ListNode(-1), p1 = dummy1;
        ListNode dummy2 = new ListNode(-1), p2 = dummy2;
        while(head != null) {
            if (head.val < x) {
                p1.next = new ListNode(head.val);
                p1 = p1.next;
                head = head.next;
            } else {
                p2.next = new ListNode(head.val);
                p2 = p2.next;
                head = head.next;
            }
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
