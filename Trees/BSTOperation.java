import java.util.ArrayList;
import java.util.List;

public class BSTOperation {

    public int diameter(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightHelper(root.left);
        int rightHeight = heightHelper(root.right);
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    public void Height(TreeNode root) {
        if (root == null) {
            return;
        }
        int height = heightHelper(root);
        System.out.println("Height of the BST: " + height);
    }

    private int heightHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightHelper(root.left);
        int rightHeight = heightHelper(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBstHelper(root, root.val + 1);
    }

    private boolean isValidBstHelper(TreeNode root, int max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max) {
            return false;
        }
        return isValidBstHelper(root.left, root.val) && isValidBstHelper(root.right, max);
    }

    void generate(int n, List<Integer> current, boolean[] used, List<TreeNode> bstList) {
        // We have used all numbers
        if (current.size() == n) {
            // System.out.println(current);
            bstList.add(generateBst(current));
            return;
        }

        // Try every number from 1 to n
        for (int i = 1; i <= n; i++) {

            if (used[i]) {
                continue;
            }

            // Choose
            current.add(i);
            used[i] = true;

            // Explore
            generate(n, current, used, bstList);

            // Backtrack
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

    public TreeNode generateBst(List<Integer> current) {
        BstTree bst = new BstTree();
        TreeNode root = null;
        for (int value : current) {
            root = bst.insert(root, value);
        }
        Traversal traversal = new Traversal();
        System.out.print("Level-order traversal of the BST:");
        traversal.levelOrder(root);
        System.out.println();
        return root;

    }
}
