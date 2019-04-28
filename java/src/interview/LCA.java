// Lowest Common Ancestor of Binary Search Tree
// with parent pointer
// https://www.careercup.com/question?id=56769
// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=176715
// follow up是如果两个节点靠的很近怎么办，这样如果树的height太高，这样就需要把所有的ancestors都遍历一遍
// 只要边存边查就可以了，不用先全部遍历把所有ancestors都存到hashSet里
// （注意考虑一下如果有一个节点是Null，或者两个节点不在同一个tree里怎么办）

package interview;

import java.util.HashSet;
import java.util.Set;


// Hashset ( Time: O(h), Space: O(h) )
public class LCA {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null || q != null) {
            if (p != null) {
                if (!ancestors.add(p)) {
                    return p;
                }
                p = p.parent;
            }
            if (q != null) {
                if (!ancestors.add(q)) {
                    return q;
                }
                q = q.parent;
            }
        }
        return null;
    }


    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        int h1 = getHeight(p), h2 = getHeight(q);
        if (h1 < h2) {
            int tmp = h1;
            h1 = h2;
            h2 = tmp;
            TreeNode t = p;
            p = q;
            q = t;
        }
        int deltaH = h1 - h2;
        while (deltaH-- > 0) {
            p = p.parent;
        }
        while (p != null && q != null) {
            if (p == q) {
                return p;
            }
            p = p.parent;
            q = q.parent;
        }
        return null;
    }

    private static int getHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            node = node.parent;
            height++;
        }
        return height;
    }
}
