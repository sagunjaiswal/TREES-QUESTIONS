/**
FIND THE LEETOCODE QUESTION HERE :
ALTERNATIVE LINK IF YOU DON'T HAVE LEETCODE PREMIUM : https://www.lintcode.com/problem/878
**/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    private boolean isLeaf(TreeNode root){
        return (root.left == null)&&(root.right == null);
    }

    private void addLeftBoundary(TreeNode root,ArrayList<Integer> res){
        TreeNode curr = root.left;
        while(curr != null){
            if(isLeaf(curr) == false)
                res.add(curr.val);
            if(curr.left != null)
                curr = curr.left;
            else
                curr = curr.right; 
        }
    }

    private void addRightBoundary(TreeNode root, ArrayList<Integer> res){
        TreeNode curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();

        while(curr != null){

            if(isLeaf(curr) == false)
                temp.add(curr.val);
            
            if(curr.right != null){
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        for(int i = temp.size()-1 ; i >= 0 ; i--)
            res.add(temp.get(i));
    }

    private void addLeaves(TreeNode root, ArrayList<Integer> res){
        if(isLeaf(root)){
            res.add(root.val);
            return;
        }

        if(root.left != null)
            addLeaves(root.left,res);

        if(root.right != null)
            addLeaves(root.right,res);

    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null)
            return ans;

        if(isLeaf(root) == false) 
            ans.add(root.val); 

	    addLeftBoundary(root, ans); 
	    addLeaves(root, ans); 
	    addRightBoundary(root, ans); 

	    return ans;
    }
}
