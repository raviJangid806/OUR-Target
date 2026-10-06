public class BstTree {

    // binary search tree implementation
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public TreeNode search(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return search(root.left, val);
        }
        return search(root.right, val);
    }

    public TreeNode delete(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (val < root.val) {
            root.left = delete(root.left, val);
        } else if (val > root.val) {
            root.right = delete(root.right, val);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.val = minval(root.right);
            // Delete the inorder successor
            root.right = delete(root.right, root.val);
        }
        return root;
    }

    private int minval(TreeNode right) {
        int min = right.val;
        while (right.left != null) {
            min = right.left.val;
            right = right.left;
        }
        return min;
    }
}
