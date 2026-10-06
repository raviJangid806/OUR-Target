import java.util.ArrayList;
import java.util.List;

public class BTOperation {
    public static void main(String[] args) {
       
    }
    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, targetSum, currentPath, result);
        return result;
    }
     private void findPaths(TreeNode root, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (root == null) return;
        currentPath.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList<>(currentPath));
        } else {
            findPaths(root.left, targetSum - root.val, currentPath, result);
            findPaths(root.right, targetSum - root.val, currentPath, result);
        }
        currentPath.remove(currentPath.size() - 1);
     }

}
