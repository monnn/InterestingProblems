/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class TreePostOrderTraversal {

    class Node {
        int data;
        Node left;
        Node right;
    }

    void postOrder(Node root) {
        //first left child, then right child, then parent
        if(root.left != null) {
            postOrder(root.left);
        }
        if(root.right != null) {
            postOrder(root.right);
        }
        System.out.print(root.data + " ");
    }
}
