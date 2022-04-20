/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

   List<Integer> fullTree = new ArrayList<>();
    int pointer = 0;

    public BSTIterator(TreeNode root) {
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            fullTree.add(root.val);
            inorder(root.right);
        }
    }

    public int next() {
        if (pointer < fullTree.size()) {
            return fullTree.get(pointer++);
        }
        return -1;
    }

    public boolean hasNext() {
        return pointer < fullTree.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */