
// | 968 | Binary Tree Cameras |  Hard | Google |
class Solution {
    int camera = 0;

    public int minCameraCover_(TreeNode root) {
        if (root == null) {
            return 1;
        }

        int lres = minCameraCover_(root.left);
        int rres = minCameraCover_(root.right);

        if (lres == -1 || rres == -1) {
            camera++;
            return 0;
        }

        if (lres == 0 || rres == 0) {
            return 1;
        }

        return -1;
    }

    public int minCameraCover(TreeNode root) {
        if (minCameraCover_(root) == -1)
            camera++;
        return camera;
    }
}

// | 979 | Distribute Coins in Binary Tree | Medium | Amazon, Google, Microsoft

class Solution {
    int res = 0;

    public int distributeCoins(TreeNode root) {
        postOrder(root);
        return res;
    }

    public int postOrder(TreeNode root) {
        if (root == null)
            return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        res += Math.abs(left) + Math.abs(right);

        return root.val + left + right - 1;
    }
}


// 1372  Longest ZigZag Path in a Binary Tree
class Solution {
    public class Pair {
        int forwardSlop = -1;
        int backwardSlop = -1;
        int maxLen = 0;
    }

    public Pair longestZigZag_(TreeNode root) {
        if (root == null)
            return new Pair();

        Pair left = longestZigZag_(root.left);
        Pair right = longestZigZag_(root.right);

        Pair myAns = new Pair();
        myAns.forwardSlop = left.backwardSlop + 1;
        myAns.backwardSlop = right.forwardSlop + 1;

        int lrMax = Math.max(left.maxLen, right.maxLen);
        int currMax = Math.max(left.backwardSlop, right.forwardSlop) + 1; // kiske sath banau path
        myAns.maxLen = Math.max(currMax, lrMax);

        return myAns;

    }

    public int longestZigZag(TreeNode root) {
        Pair ans = longestZigZag_(root);
        return ans.maxLen;
    }
}



// Convert A Given Tree To Sum Tree
class Solution {
    public void toSumTree(Node root) {
        if (root == null) {
            return;
        }

        getSumTree(root);
    }

    public int getSumTree(Node root) {
        if (root == null) {
            return 0;
        }

        int oldVal = root.data;

        int left = getSumTree(root.left) ;
        int right = getSumTree(root.right);
        root.data = left + right;

        return root.data + oldVal;
    }

}

// Count BST ndoes that lie in a given range
class Tree {
    int getCount(Node root, int l, int h) {
        if (root == null) {
            return 0;
        }

        int left = getCount(root.left, l, h);
        int right = getCount(root.right, l, h);

        if (root.data >= l && root.data <= h) {
            return 1 + left + right;
        } else if (root.data < l) {
            return right;
        } else {
            return left;
        }

    }
}

// | 337 | House Robber III | Medium | Amazon, Facebook, Google |

class Solution {
    public class Pair {
        int withRobbery = 0;
        int withoutRobbery = 0;
    }

    public Pair houseRobber(TreeNode root) {
        if (root == null) {
            return new Pair();
        }

        Pair left  = houseRobber(root.left);
        Pair right = houseRobber(root.right);

        Pair currRes = new Pair();
        currRes.withRobbery = left.withoutRobbery + root.val + right.withoutRobbery;
        currRes.withoutRobbery = Math.max(left.withRobbery, left.withoutRobbery)
                + Math.max(right.withRobbery, right.withoutRobbery);

        return currRes;
    }

    public int rob(TreeNode root) {
        Pair res = houseRobber(root);

        return Math.max(res.withRobbery, res.withoutRobbery);
    }
}

// Range Sum of BST

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {

        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);

        if (root.data >= low && root.data <= high) {
            return root.data + left + right;
        } else if (root.data > high) {
            return left;
        } else {
            return right;
        }
    }

}

// Print all nodes that don’t have sibling
class Solution {
    public void printSingle(TreeNode root) {

        if (root.left != null && root.right == null) {
            System.out.print(root.data);
            printSingle(root.left);
        } else if (root.left == null && root.right != null) {
            System.out.print(root.data);
            printSingle(root.right);
        } else {
            printSingle(root.left);
            printSingle(root.right);
        }
    }
}

