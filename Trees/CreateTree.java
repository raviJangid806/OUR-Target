import java.util.LinkedList;
import java.util.Queue;

class CreateTree {
    public TreeNode createSampleTree() {
        BstTree bst = new BstTree();
        TreeNode root = null;
        int[] values = { 50, 30, 20, 40, 70, 60, 80 };
        for (int value : values) {
            root = bst.insert(root, value);
        }
        return root;
    }

    public TreeNode createBinaryTree() {
        // Integer[] values = { 1, 3, null, null, 2 };
        Integer[] values = { 3, 1, 4, null, null, 2 };
        return createBinaryTree(values);
    }

    public TreeNode createBinaryTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty() && index < values.length) {
            TreeNode current = queue.poll();

            if (current == null) {
                continue;
            }

            if (index < values.length && values[index] != null) {
                current.left = new TreeNode(values[index]);
                queue.offer(current.left);
            }
            index++;

            if (index < values.length && values[index] != null) {
                current.right = new TreeNode(values[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }
}