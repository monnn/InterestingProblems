import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class TreeLevelOrderTraversal {
    //BFS

    class Node {
        int data;
        Node left;
        Node right;
    }

    void LevelOrder(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
