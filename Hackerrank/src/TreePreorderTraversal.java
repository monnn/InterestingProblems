import java.util.ArrayList;
import java.util.List;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class TreePreorderTraversal {
    //DFS

    class Node {
        int data;
        Node left;
        Node right;
    }

    List<Node> set = new ArrayList<>();
    void preOrder(Node root) {
        if (!set.contains(root)) {
            set.add(root);
            System.out.print(root.data + " ");
        }
        if (root.left != null && !set.contains(root.left)) {
            preOrder(root.left);
        }
        if(root.right != null && !set.contains(root.right)) {
            preOrder(root.right);
        }
    }
}
