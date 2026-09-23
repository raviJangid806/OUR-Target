import java.util.ArrayList;

public class TreeMain {
    public static void main(String[] args) {
        bstPermutation(3);
    }

    public static void testBstTree() {
        BstTree bst = new BstTree();
        TreeNode root = null;
        int[] values = { 50, 30, 20, 40, 70, 60, 80 };
        for (int value : values) {
            root = bst.insert(root, value);
        }

        Traversal traversal = new Traversal();
        System.out.println("\nLevel-order traversal:");
        traversal.levelOrder(root);
        bst.delete(root, 70);
        traversal.levelOrder(root);

    }

    public static void bstPermutation(int n) {
        BSTOperation bstOperation = new BSTOperation();
        bstOperation.generate(n, new ArrayList<>(), new boolean[n + 1], new ArrayList<>());
    }

}
