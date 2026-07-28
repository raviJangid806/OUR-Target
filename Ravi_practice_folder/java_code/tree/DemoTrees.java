package Ravi_practice_folder.java_code.tree;

public class DemoTrees {
    public TreeNode createSampleTree() {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        return root;
    }
}
