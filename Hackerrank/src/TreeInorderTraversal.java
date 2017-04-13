/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class TreeInorderTraversal {

    class Node {
        int data;
        Node left;
        Node right;
    }

    void inOrder(Node root) {

        if(root.left != null) {
            inOrder(root.left);
        }
        System.out.print(root.data + " ");

        if (root.right != null) {
            inOrder(root.right);
        }
    }
}
