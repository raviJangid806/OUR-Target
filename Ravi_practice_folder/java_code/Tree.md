## Level Order Traversal

Sabse better aur clean approach hai "iterative preorder traversal" jisme explicit stack use hoti hai.

```java
import java.util.ArrayDeque;
import java.util.Deque;

public void inLineTraversal(TreeNode root) {
    if (root == null) {
        return;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        System.out.print(node.val + " ");

        if (node.right != null) {
            stack.push(node.right);
        }
        if (node.left != null) {
            stack.push(node.left);
        }
    }
}
```

Iska fayda:
- Time complexity: O(n)
- Space complexity: O(h) — jahan h tree ki height hai, worst case O(n)
