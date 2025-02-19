import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//Time Complexity functions: O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


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
//BFS 
/*
Use a queue to store nodes at a level. Initially add root to queue. Then use a while loop to remove root node.
Before while loop find the size of queue. Those many children were added in the previous level. So iterate that many times 
to remove them one by one add their children in queue. While removing add the node values to the list. Add it to the result list.
*/
class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer> > res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return res;
        }
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.peek();
            int size= q.size();
            List<Integer> ll=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode tn=q.remove();
                ll.add(tn.val);
                if(tn.left!=null){
                    q.add(tn.left);
                }
                if(tn.right!=null){
                    q.add(tn.right);
                }
            }
            res.add(ll);
        }
        return res;
    }
}
//DFS
/*
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer> > result=new ArrayList<>();
        dfs(root,0,result);
        return result;
    }

    private void dfs(TreeNode root, int level,List<List<Integer> > result ){
        //base
        if(root==null){
            return;
        }

        //logic
        if(level==result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left,level+1,result);
        dfs(root.right,level+1,result);
    }
}
*/
