package Ravi_practice_folder.java_code.tree;

import java.util.ArrayList;
import java.util.List;

public class Traversal {

    
    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        // Traverse the left subtree
        inOrderTraversal(root.left);

        // Visit the current node
        System.out.print(root.val + " ");

        // Traverse the right subtree
        inOrderTraversal(root.right);
    }

    public void inLineTraversal(TreeNode root,int i,List<TreeNode> listInline) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        listInline.add(root.left);
        listInline.add(root.right);
        i++;
        inLineTraversal(listInline.get(i),i,listInline);
    }
}
