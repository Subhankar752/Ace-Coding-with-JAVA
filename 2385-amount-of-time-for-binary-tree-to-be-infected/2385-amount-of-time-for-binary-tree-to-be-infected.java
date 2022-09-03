class Solution {
    static TreeNode mapParent(TreeNode root,HashMap<TreeNode,TreeNode> map,int start){
        TreeNode ans=null;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp.val==start)ans=temp;
            if(temp.left!=null){
                map.put(temp.left,temp);
                q.add(temp.left);
            }
            if(temp.right!=null){
                map.put(temp.right,temp);
                q.add(temp.right);
            }
        }
        return ans;
    }
    static int distK(TreeNode target,HashMap<TreeNode,TreeNode> parent){
        Queue<TreeNode> q=new LinkedList<>();
        HashMap<TreeNode,Integer> vis=new HashMap<>();
        q.add(target);
        vis.put(target,1);
        int cnt=0;
        while(!q.isEmpty()){
            int n=q.size();
            boolean fl=false;
            for(int i=0;i<n;i++){
            TreeNode temp=q.poll();
            if(temp.left!=null && !vis.containsKey(temp.left)){
                q.add(temp.left);
                vis.put(temp.left,1);
                fl=true;
            }
             if(temp.right!=null && !vis.containsKey(temp.right)){
                q.add(temp.right);
                vis.put(temp.right,1);
                 fl=true;
            }
                if(parent.get(temp)!=null && !vis.containsKey(parent.get(temp))){
                    q.add(parent.get(temp));
                    vis.put(parent.get(temp),1);
                    fl=true;
                }
            }
            if(fl)cnt++;
        }
        return cnt;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> parent=new HashMap<>();
        TreeNode st=mapParent(root,parent,start);
        return distK(st,parent);
    }
}