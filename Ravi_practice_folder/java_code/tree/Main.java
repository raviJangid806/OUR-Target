package Ravi_practice_folder.java_code.tree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a sample binary tree
        DemoTrees demoTrees = new DemoTrees();
        Traversal traversal = new Traversal();
        // System.out.println("In-order Traversal of the Sample Tree:");
        // traversal.inOrderTraversal(demoTrees.createSampleTree());

        List<TreeNode> listInline = new ArrayList<>();
        listInline.add(demoTrees.createSampleTree());

        System.out.println("\nIn-line Traversal of the Sample Tree:");
        traversal.inLineTraversal(demoTrees.createSampleTree(), 0, listInline);
    }
}
