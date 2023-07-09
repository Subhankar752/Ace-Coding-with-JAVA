/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) 
            return "null,";
        
        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);
        
        return root.val + "," + leftSerialized + rightSerialized;
    }

    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return constructTree(nodes);
    }

    private TreeNode constructTree(Queue<String> nodes) {
        String val = nodes.poll();
        
        if (val.equals("null")) 
            return null;
        
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = constructTree(nodes);
        node.right = constructTree(nodes);
        
        return node;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
