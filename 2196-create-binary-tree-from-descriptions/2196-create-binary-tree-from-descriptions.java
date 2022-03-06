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
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        // int root = 0;
        // for(int[] i : descriptions){
        //     if(root == 0)
        //         root = i[0];
        //     else{
        //         if(root == i[1])
        //             root = i[0];
        //     }
        // }
        // Queue<TreeNode> q = new LinkedList<>();
        // TreeNode node = new TreeNode(root);
        // q.add(node);
        // while(!q.isEmpty()){
        //     TreeNode cur = q.remove();
        //     for(int[] i : descriptions){
        //         if(i[0] == cur.val){
        //             if(i[2] == 1){
        //                 cur.left = new TreeNode(i[1]);
        //                 q.add(cur.left);
        //             }
        //             else{
        //                 cur.right = new TreeNode(i[1]);
        //                 q.add(cur.right);
        //             }
        //         }
        //     }
        // }
        // return node;
         HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();
        for (int[] arr : descriptions) {
            int parent = arr[0], child = arr[1], isLeft = arr[2];
            TreeNode parentNode = map.getOrDefault(parent, new TreeNode(parent));
            TreeNode childNode = map.getOrDefault(child, new TreeNode(child));

            if (isLeft == 1) parentNode.left = childNode;
            else parentNode.right = childNode;

            map.put(parent, parentNode);
            map.put(child, childNode);
            children.add(child);
        }

        for (int[] arr : descriptions) if (!children.contains(arr[0])) return map.get(arr[0]);
        return null;
    }
}