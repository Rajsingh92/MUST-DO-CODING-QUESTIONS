

public class BinaryTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }

        int ls = size(root.left);
        int rs = size(root.right);
        return ls + rs + 1;
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }

        int ls = sum(root.left);
        int rs = sum(root.right);
        return ls + rs + root.data;
    }

    public static int max(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int lm = max(root.left);
        int rm = max(root.right);
        int tm = Math.max(root.data, Math.max(lm, rm));

        return tm;
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static boolean find(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            return true;
        }

        boolean filc = find(root.left, data);
        if (filc) {
            return true;
        }

        boolean firc = find(root.right, data);
        if (firc) {
            return true;
        }

        return false;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {

        if (node == null) {
            return new ArrayList<>();
        }

        if (node.data == data) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(node.data);
            return temp;
        }

        ArrayList<Integer> llist = nodeToRootPath(node.left, data);
        if (llist.size() > 0) {
            llist.add(node.data);
            return llist;
        }

        ArrayList<Integer> rlist = nodeToRootPath(node.right, data);
        if (rlist.size() > 0) {
            rlist.add(node.data);
            return rlist;
        }
        return new ArrayList<>();
    }


    public static void printKLevelsDown(Node node, int k){
        if(node == null || k<0){
            return;
        }
        
        if(k==0){
            System.out.println(node.data);
            return;
        }
        
        printKLevelsDown(node.left,k-1);
        printKLevelsDown(node.right,k-1);
      }
}



