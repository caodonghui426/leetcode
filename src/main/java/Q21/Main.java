package Q21;

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
        node4.next = node5;
        node5.next = node6;

        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        ListNode res = solution2.mergeTwoLists(node1,node4);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val,ListNode next) {
        this.next = next;
    }
}
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode res = new ListNode(-1);
        ListNode temp = new ListNode(0,res);

        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = new ListNode(l1.val);
                res = res.next;
                l1 = l1.next;
            } else {
                res.next = new ListNode(l2.val);
                res = res.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            res.next = new ListNode(l1.val);
            res = res.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            res.next = new ListNode(l2.val);
            res = res.next;
            l2 = l2.next;
        }

        return temp.next.next;
    }
}
class Solution2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode res = new ListNode(-1);
        ListNode temp = new ListNode(0,res);

        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = l1;
                res = res.next;
                l1 = l1.next;
            } else {
                res.next = l2;
                res = res.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            res.next = l1;
        }
        if (l2 != null) {
            res.next = l2;
        }

        return temp.next.next;
    }
}