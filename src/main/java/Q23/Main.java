package Q23;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        node7.next = node8;

        ListNode[] lists = {node1, node4, node7};

        Solution solution = new Solution();
        ListNode res = solution.mergeKLists(lists);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));

        for(ListNode list : lists) {
            if(list != null) {
                pq.add(list);
            }
        }

        while(!pq.isEmpty()) {
            p.next = pq.poll();
            if (p.next.next != null) {
                pq.add(p.next.next);
            }
            p = p.next;
        }
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