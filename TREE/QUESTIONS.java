
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

// | 979 | Distribute Coins in Binary Tree | Medium | Amazon, Google, Microsoft |

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
        root.data = getSumTree(root.left) + getSumTree(root.right);

        return root.data + oldVal;
    }

}

// Count BST ndoes that lie in a given range
class Tree {
    int getCount(Node root, int l, int h) {
        if (root == null) {
            return 0;
        }

        if (root.data >= l && root.data <= h) {
            return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
        } else if (root.data < l) {
            return getCount(root.right, l, h);
        } else {
            return getCount(root.left, l, h);
        }

    }
}
