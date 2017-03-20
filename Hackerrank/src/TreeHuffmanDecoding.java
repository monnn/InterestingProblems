/**
 * @author Monica Shopova <monica.shopova@gmail.com>
 */
public class TreeHuffmanDecoding {

    class Node {
        Node right;
        Node left;
        char data;
    }

    static Node baseRoot;
    static void decode(String S ,Node root)
    {
        baseRoot = root;
        for(int i=0; i< S.length(); i++) {
            if(S.charAt(i) == '1') {
                if(root.right != null) {
                    root = root.right;
                } if(root.right == null && root.left == null) {
                    //leaf
                    System.out.print(root.data);
                    root = baseRoot;
                }
            }
            if(S.charAt(i) == '0') {
                if(root.left != null) {
                    root = root.left;
                } if(root.right == null && root.left == null) {
                    //leaf
                    System.out.print(root.data);
                    root = baseRoot;
                }
            }
        }

    }
}
