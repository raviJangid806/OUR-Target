public class BstTree {

    // binary search tree implementation
    public TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public TreeNode search(TreeNode root, int value) {
        if (root == null || root.value == value) {
            return root;
        }
        if (value < root.value) {
            return search(root.left, value);
        }
        return search(root.right, value);
    }

    public TreeNode delete(TreeNode root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.value) {
            root.left = delete(root.left, value);
        } else if (value > root.value) {
            root.right = delete(root.right, value);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.value = minValue(root.right);
            // Delete the inorder successor
            root.right = delete(root.right, root.value);
        }
        return root;
    }

    private int minValue(TreeNode right) {
        int min = right.value;
        while (right.left != null) {
            min = right.left.value;
            right = right.left;
        }
        return min;
    }
}
