

public class BinaryTree{
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


    public static int  size(Node root){
        if(root == null){
            return 0;
        }

        int ls = size(root.left);
        int rs = size(root.right);
        return ls+rs+1;
    }

    public static int  sum(Node root){
        if(root == null){
            return 0;
        }

        int ls = sum(root.left);
        int rs = sum(root.right);
        return ls+rs+root.data;
    }

    public static int  height(Node root){
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh)+1;
    }
}