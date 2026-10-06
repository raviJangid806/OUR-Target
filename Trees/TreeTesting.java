public class TreeTesting {

    public void main(String[] args) {
        TreeTesting treeTesting = new TreeTesting();
        CreateTree createTree = new CreateTree();
        TreeNode root = createTree.createBinaryTree();
        treeTesting.displayTree(root);
    }

    public void displayTree(TreeNode root) {
        Traversal traversal = new Traversal();
        System.out.println("Inorder Traversal:");
        traversal.inOrder(root);
    }
}
