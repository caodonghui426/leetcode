package Q102;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] arg) {
        Solution solution = new Solution();
        // 创建树的节点
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        // 构建树的结构
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        // node1是树的根节点
        TreeNode root = node1;

        System.out.println(solution.levelOrder(root));
    }
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // while 循环控制从上向下一层层遍历
        while(!q.isEmpty()) {
            int sz = q.size();
            // 记录这一层的节点值
            List<Integer> level = new LinkedList<>();
            // for 循环控制每一层从左向右的遍历
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}