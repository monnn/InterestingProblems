/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class TreeTopView {

    class Node {
        int data;
        Node left;
        Node right;
    }

    Node baseRoot;
    int count = 0;

    void top_view(Node root) {
        count++;
        if(count == 1) {
            baseRoot = root;
        }
        if(root.left != null) {
            top_view(root.left);
        }
        System.out.print(root.data + " ");
        if(baseRoot == root) {
            //go right
            top_view_right(root);
        } else {
            root = null;
        }
    }

    void top_view_right(Node root) {
        if (root.right != null) {
            System.out.print(root.right.data + " ");
            top_view_right(root.right);
        }
    }
}
