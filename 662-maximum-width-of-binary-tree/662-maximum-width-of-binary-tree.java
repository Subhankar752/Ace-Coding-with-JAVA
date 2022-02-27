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
    public int widthOfBinaryTree(TreeNode root) {
        //queue to hold bfs order
		Queue<TreeNode> queue = new LinkedList<>();
		//queue to hold index of corresponding node in bfs order
		Queue<Integer> queueIndex = new LinkedList<>();
		//add first node to queue
		queue.add(root);
		//first node index is let say 1
		queueIndex.add(1);
		//hold max width
		int width = 0;
		//do level order traversal
		while (!queue.isEmpty()) {
			int size = queue.size();
			//hold the index of first node in a level
			int start = 0;
			//hold index of last node in a level
			int end = 0;
			for (int i = 0; i < size; i++) {
				//remove from both queue
				TreeNode node = queue.poll();
				int index = queueIndex.poll();
				//if i==0 it means its first node
				if (i == 0) {
					//update start index
					start = index;
				}
				//if i==last index update end index
				if (i == size - 1) {
					end = index;
				}
				//normal bfs logic to add node to queue if present. here add to both queue
				if (node.left != null) {
					queue.add(node.left);
					queueIndex.add(index * 2);
				}
				//normal bfs logic to add node to queue if present. here add to both queue
				if (node.right != null) {
					queue.add(node.right);
					queueIndex.add(index * 2 + 1);
				}
			}
			//update max width
			width = Math.max(width, end - start + 1);
		}
		//return answer
		return width;
    }
}