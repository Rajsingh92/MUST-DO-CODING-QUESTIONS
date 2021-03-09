
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

    // | 104 | Maximum Depth of Binary Tree | Easy | Apple, Facebook, Google |
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

    public static void printKLevelsDown(Node node, int k) {
        if (node == null || k < 0) {
            return;
        }

        if (k == 0) {
            System.out.println(node.data);
            return;
        }

        printKLevelsDown(node.left, k - 1);
        printKLevelsDown(node.right, k - 1);
    }
    

    // | 257 | Binary Tree Paths | Easy | Amazon, Facebook, Microsoft |
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        getPath(root, "", res);
        return res;
    }

    public void getPath(TreeNode root, String psf, ArrayList<String> res) {
        if (root.left == null && root.right == null) {
            String te = psf + root.val;
            res.add(te);
            return;
        }

        if (root.left != null) {
            getPath(root.left, psf + root.val + "->", res);
        }

        if (root.right != null) {
            getPath(root.right, psf + root.val + "->", res);
        }
    }

    // | 111 | Minimum Depth of Binary Tree | Easy | Adobe, Amazon, Microsoft |
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        int ts = Math.min(left, right);
        return ts + 1;
    }

    // | 226 | Invert Binary Tree | Easy | Adobe, Amazon, Facebook |
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = root.left, right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }

    // | 112 | Path Sum | Easy | Amazon |
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum_rec(root, targetSum, 0);
    }

    public boolean hasPathSum_rec(TreeNode root, int data, int ssf) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            int res = ssf + root.val;
            // System.out.print(res);

            if (res == data)
                return true;
        }

        return hasPathSum_rec(root.left, data, ssf + root.val) || hasPathSum_rec(root.right, data, ssf + root.val);

    }

    // | 236 | Lowest Common Ancestor of a Binary Tree | Medium | Google |
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == p || root == q || root == null)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;

    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();

        rootToNodePath(root, p, list1);
        rootToNodePath(root, q, list2);

        int i = list1.size() - 1;
        int j = list2.size() - 1;

        TreeNode LCA = null;

        while (i >= 0 && j >= 0) {
            if (list1.get(i) != list2.get(j)) // cpp : list1[i] == list2[j]
                break;

            LCA = list1.get(i);
            i--;
            j--;
        }

        return LCA;
    }

    // | 1022 | Sum of Root To Leaf Binary Numbers | Easy | Amazon |
    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> nums = new ArrayList<>();
        rootToLeaf(root, 0, nums);
        int res = 0;
        for (int te : nums) {
            res += te;
        }

        return res;
    }

    public void rootToLeaf(TreeNode root, int sum, ArrayList<Integer> nums) {

        if (root.left == null && root.right == null) {
            int res = sum * 10 + root.val;
            System.out.println(res);
            nums.add(res);
            return;
        }

        if (root.left != null) {
            rootToLeaf(root.left, sum * 10 + root.val, nums);
        }

        if (root.right != null) {
            rootToLeaf(root.right, sum * 10 + root.val, nums);
        }
    }

}
