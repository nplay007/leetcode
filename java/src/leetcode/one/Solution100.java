package JavaAnswer.one;

import java.util.LinkedList;
import java.util.Queue;

import JavaAnswer.TreeNode;

public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class Solution100Iterative {
    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        Queue<TreeNode> queueOfP = new LinkedList<>();
        Queue<TreeNode> queueOfQ = new LinkedList<>();
        queueOfP.add(p);
        queueOfQ.add(q);
        while (!queueOfP.isEmpty() && !queueOfQ.isEmpty()) {
            p = queueOfP.poll();
            q = queueOfQ.poll();
            if (p.val != q.val) {
                return false;
            }
            if (p.left != null) {
                queueOfP.add(p.left);
            }
            if (q.left != null) {
                queueOfQ.add(q.left);
            }
            if (queueOfP.size() != queueOfQ.size()) {
                return false;
            }
            if (p.right != null) {
                queueOfP.add(p.right);
            }
            if (q.right != null) {
                queueOfQ.add(q.right);
            }
            if (queueOfP.size() != queueOfQ.size()) {
                return false;
            }
        }
        return queueOfP.size() == queueOfQ.size();
    }
}