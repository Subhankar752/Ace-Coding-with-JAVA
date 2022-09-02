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
    public List<Double> averageOfLevels(TreeNode root) {
        
    List<Double> ans= new ArrayList<>();

    // queue for bfs
    Queue<TreeNode> q= new LinkedList<>();

    // if root is not null only then wew add it to our queue
    if( root!=null) q.add(root);


    while(q.isEmpty()==false){

        // get the no nodes in the current level
        int n= q.size();

        // initialize the sum varaible just the start of a new level
        Double sum=0.0;
        for( int i=0; i<n;i++){

            // get the element
            TreeNode x= q.poll();

            // add its val too the sum varialbe
            sum+=x.val;


            // if its left and right nodes are not null we add it to the queue for next level iteration
            if( x.left!=null)q.add( x.left);

            if( x.right!=null) q.add(x.right);

        }

        // now that we have finsished iterating over a level we add its average to our answer
        ans.add(sum/n);
    }

    return ans;
    }
}