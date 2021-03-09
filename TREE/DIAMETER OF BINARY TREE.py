'''
| 543 | Diameter of Binary Tree |  Easy | Adobe |
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of 
the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
Note: The length of path between two nodes is represented by the number of edges between them.

'''

class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        if root is None:
            return 0
        
        #one left one right
        leftHeight = self.height(root.left)
        rightHeight = self.height(root.right)
        
        #both ends are at left
        leftDiameter = self.diameterOfBinaryTree(root.left)
        
        #both ends are at right
        rightDiameter = self.diameterOfBinaryTree(root.right)
        
        return max(leftHeight+rightHeight,max(leftDiameter,rightDiameter))
    
    def height(self,root):
        if root is None:
            return 0
        
        return 1+max(self.height(root.left),self.height(root.right))


# optimization
class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        if root is None:
            return 0 
        
        return self.getDiameter(root,0)[1]
        
    def getDiameter(self,root,diameter):
        if root is None:
            return 0,diameter
        
        leftHeight ,diameter = self.getDiameter(root.left,diameter)
        rightHeight ,diameter = self.getDiameter(root.right,diameter)
        
        max_diameter = leftHeight+rightHeight
        diameter = max(diameter,max_diameter)
        
        return max(leftHeight,rightHeight)+1,diameter




'''
 // https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/

    public int diameterOfBinaryTree_01(TreeNode root) {
        if (root == null)
            return -1;
        int leftTreeDia = diameterOfBinaryTree_01(root.left);
        int rightTreeDia = diameterOfBinaryTree_01(root.right);

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(Math.max(leftTreeDia, rightTreeDia), leftHeight + rightHeight + 2);
    }

    // {dia,height}
    public int[] diameterOfBinaryTree_02(TreeNode root) {
        if (root == null)
            return new int[] { -1, -1 };
        int[] leftAns = diameterOfBinaryTree_02(root.left);
        int[] rightAns = diameterOfBinaryTree_02(root.right);

        int[] ans = new int[2];
        ans[0] = Math.max(Math.max(leftAns[0], rightAns[0]), leftAns[1] + rightAns[1] + 2);
        ans[1] = Math.max(leftAns[1], rightAns[1]) + 1;

        return ans;
    }

    int maxDia = 0;

    public int diameterOfBinaryTree_03(TreeNode root) {
        if (root == null)
            return -1;
        int lh = diameterOfBinaryTree_03(root.left);
        int rh = diameterOfBinaryTree_03(root.right);

        maxDia = Math.max(maxDia, lh + rh + 2);

        return Math.max(lh, rh) + 1;
    }

    public int diameterOfBinaryTree_03(TreeNode root, int[] ans) {
        if (root == null)
            return -1;
        int lh = diameterOfBinaryTree_03(root.left);
        int rh = diameterOfBinaryTree_03(root.right);

        ans[0] = Math.max(ans[0], lh + rh + 2);

        return Math.max(lh, rh) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        // return diameterOfBinaryTree_01(root);
        // return diameterOfBinaryTree_02(root)[0];
        int[] ans = new int[1];
        diameterOfBinaryTree_03(root, ans);
        return ans[0];
    }


'''