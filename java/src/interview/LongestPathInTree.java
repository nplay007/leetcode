package interview;


class TrieNode {
    public int val;
    public TreeNode[] children;

    public TrieNode(int n, int val) {
        this.val = val;
        children = new TreeNode[n];
    }
}
// https://cs.stackexchange.com/questions/11263/longest-path-in-an-undirected-tree-with-only-one-traversal

//public class LongestPathInTree {
//    int maxPath;
//
//    public int[] longestPathLength(TreeNode root) {
//        if (root.children == null) {
//            return new int[] {0, 0};
//        }
//        for (TreeNode child : root.children) {
//            int[] result = longestPathLength(child);
//            int heights = result[0];
//            int paths = result[1];
//        }
//
//
//    }
//}
