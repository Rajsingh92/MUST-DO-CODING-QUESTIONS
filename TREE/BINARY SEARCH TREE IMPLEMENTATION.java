public class BST {
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

    public static Node add(Node node, int data) {
        if (node == null) {
            return new Node(data, null, null);
        }

        if (data > node.data) {
            node.right = add(node.right, data);
            return node;
        } else if (data < node.data) {
            node.left = add(node.left, data);
            return node;
        } else {
            return node;
        }
    }

    public static Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (data > node.data) {
            node.right = remove(node.right, data);
            return node;
        } else if (data < node.data) {
            node.left = remove(node.left, data);
            return node;
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                int max = max(node.left);
                node.data = max;
                node.left = remove(node.left, max);
                return node;
            }
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

    public static int max(Node node) {
        if (root.right == null) {
            return root.data;
        }

        int res = max(node.right);
        return res;
    }

    public static int min(Node node) {
        if (root.left == null) {
            return root.data;
        }

        int res = min(node.left);
        return res;
    }

    public static boolean find(Node node, int data) {

        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        } else if (node.data > data) {
            return find(node.left, data);
        } else {
            return find(node.right, data);
        }
    }

    // iterative method
    public static boolean find2(Node node, int data) {
        if (node == null) {
            return false;
        }

        Node curr = node;
        while (curr != null) {
            if (curr.data == data) {
                return true;
            } else if (curr.data > data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return false;
    }

    // | 235 | Lowest Common Ancestor of a Binary Search Tree |  Easy | Adobe |
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    //  | 783 | Minimum Distance Between BST Nodes |  Easy | Amazon |
    //   Find LCA  of 2 nodes in a BST


}