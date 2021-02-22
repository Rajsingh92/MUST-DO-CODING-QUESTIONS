
// | 450 | Delete Node in a BST |  Medium | Google |
// | 700 | Search in a Binary Search Tree |  Easy | Google |




public class BST{
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }


    public static int size(Node node) {
        if (node == null) {
            return 0;
        }

        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls + rs + 1;
        return ts;
    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }

        int ls = sum(node.left);
        int rs = sum(node.right);
        int ts = ls + rs + node.data;
        return ts;
    }
}