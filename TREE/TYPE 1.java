/**
Left View of Binary Tree 
Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from 
Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    /    \
  4     5   6    7
   \
     8 
 */

class Solution {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        
        while(queue.size()!=0){
            
            int size = queue.size();
            int i = 0;
            
            while(i<size){
                i++;
                TreeNode node = queue.removeFirst();
                if(i == 1){
                    res.add(node.val);
                }
                
                if(node.left!=null){
                    queue.addLast(node.left);
                }
                if(node.right!=null){
                    queue.addLast(node.right);
                }
                
            }
            
            
        }
        
        return res;
    }
}



/**
| 199 | Binary Tree Right Side View |  Medium | Adobe, Google, Amazon |

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you 
can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        
        while(queue.size()!=0){
            
            int size = queue.size();
            int i = 0;
            
            while(i<size){
                i++;
                TreeNode node = queue.removeFirst();
                if(i == size){
                    res.add(node.val);
                }
                
                if(node.left!=null){
                    queue.addLast(node.left);
                }
                if(node.right!=null){
                    queue.addLast(node.right);
                }
                
            }
            
            
        }
        
        return res;
    }
}




/**
 Binary Tree Zigzag Level Order Traversal
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to 
left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

 */


class Solution {
    public static class Pair{
        TreeNode node;
        int level;
        
        Pair(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(root,1));
        
        while(queue.size()>0){
            int size = queue.size();
            List<Integer> sublist = new ArrayList<>();
            
            while(size-->0){
                Pair rem = queue.removeFirst();
                if(rem.level%2 == 0){
                    sublist.add(0,rem.node.val);
                }else{
                    sublist.add(rem.node.val);
                }
                
                if(rem.node.left!=null){
                    queue.addLast(new Pair(rem.node.left,rem.level+1));
                }
                
                if(rem.node.right!=null){
                    queue.addLast(new Pair(rem.node.right,rem.level+1));
                }
            }
            
            res.add(sublist);
        }
        
        return res;
        
    }
}



/**
Print a Binary Tree in Vertical Order

           1
        /    \ 
       2      3
      / \   /   \
     4   5  6   7
               /  \ 
              8   9 
               
              
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9
 */

public class Main {
    public static class pairVO {
        Node node; //actual Node
        int vl = 0; // vertical Level
        public pairVO(Node node, int vl) {
            this.node = node;
            this.vl = vl;
        }
    }

    static int leftMinValue = 0;
    static int rightMaxValue = 0;

    public static void width(Node node, int lev) {
        if (node == null) return;

        leftMinValue = Math.min(leftMinValue, lev);
        rightMaxValue = Math.max(rightMaxValue, lev);

        width(node.left, lev - 1);
        width(node.right, lev + 1);
    }


    public static void verticalOrder(Node node) {
        width(node, 0);
        int n = rightMaxValue - leftMinValue + 1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); 
        for (int i = 0; i < n; i++)
            ans.add(new ArrayList<>());

        LinkedList<pairVO> que = new LinkedList<>();
        que.addLast(new pairVO(node, -leftMinValue));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                pairVO rpair = que.removeFirst();
                ans.get(rpair.vl).add(rpair.node.data);
                if (rpair.node.left != null)
                    que.addLast(new pairVO(rpair.node.left, rpair.vl - 1));
                if (rpair.node.right != null)
                    que.addLast(new pairVO(rpair.node.right, rpair.vl + 1));
            }
        }

        for (ArrayList<Integer> ar : ans)
            System.out.println(ar);
        System.out.println();
    }

    public static void verticalOrderSum(Node node) {
        width(node, 0);
        int[] ans = new int[rightMaxValue - leftMinValue + 1];

        LinkedList<pairVO> que = new LinkedList<>();
        que.addLast(new pairVO(node, -leftMinValue));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                pairVO rpair = que.removeFirst();
                ans[rpair.vl] += rpair.node.data;
                if (rpair.node.left != null)
                    que.addLast(new pairVO(rpair.node.left, rpair.vl - 1));
                if (rpair.node.right != null)
                    que.addLast(new pairVO(rpair.node.right, rpair.vl + 1));
            }
        }

        for (int ele : ans)
            System.out.println(ele);
        System.out.println();
    }
}




// Top View of a tree
// Bottom View of a tree

public class Main {
    public static class pairVO {
        Node node; //actual Node
        int vl = 0; // vertical Level
        public pairVO(Node node, int vl) {
            this.node = node;
            this.vl = vl;
        }
    }

    static int leftMinValue = 0;
    static int rightMaxValue = 0;

    public static void width(Node node, int lev) {
        if (node == null) return;

        leftMinValue = Math.min(leftMinValue, lev);
        rightMaxValue = Math.max(rightMaxValue, lev);

        width(node.left, lev - 1);
        width(node.right, lev + 1);
    }

    
    public static void bottomView(Node node) {
        width(node, 0);
        int[] ans = new int[rightMaxValue - leftMinValue + 1];

        LinkedList<pairVO> que = new LinkedList<>();
        que.addLast(new pairVO(node, -leftMinValue));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                pairVO rpair = que.removeFirst();
                ans[rpair.vl] = rpair.node.data;
                if (rpair.node.left != null)
                    que.addLast(new pairVO(rpair.node.left, rpair.vl - 1));
                if (rpair.node.right != null)
                    que.addLast(new pairVO(rpair.node.right, rpair.vl + 1));
            }
        }

        for (int ele : ans)
            System.out.println(ele);
        System.out.println();
    }

    public static void topView(Node node) {
        width(node, 0);
        int[] ans = new int[rightMaxValue - leftMinValue + 1];
        Arrays.fill(ans, (int) -1e8);

        LinkedList<pairVO> que = new LinkedList<>();
        que.addLast(new pairVO(node, -leftMinValue));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                pairVO rpair = que.removeFirst();

                if (ans[rpair.vl] == (int) -1e8)
                    ans[rpair.vl] = rpair.node.data;

                if (rpair.node.left != null)
                    que.addLast(new pairVO(rpair.node.left, rpair.vl - 1));
                if (rpair.node.right != null)
                    que.addLast(new pairVO(rpair.node.right, rpair.vl + 1));
            }
        }

        for (int ele : ans)
            System.out.println(ele);
        System.out.println();
    }
}




/**
Diagonal Traversal of Binary Tree 
Given a Binary Tree, print the diagonal traversal of the binary tree.
Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal elements in a binary tree 
belonging to same line.

Example 1:

Input :
            8
         /     \
        3      10
      /   \      \
     1     6     14
         /   \   /
        4     7 13
Output : 8 10 14 3 6 7 13 1 4
 */


public class Main {

    public static class pairVO {
        Node node; // actual Node
        int vl = 0; // vertical Level

        public pairVO(Node node, int vl) {
            this.node = node;
            this.vl = vl;
        }
    }

    static int leftDMinValue = 0;

    public static void widthDiagonal(Node node, int lev) {
        if (node == null)
            return;

        leftMinValue = Math.min(leftMinValue, lev);

        width(node.left, lev - 1);
        width(node.right, lev + 0);
    }

    public static void diagonalOrder(Node node) {
        widthDiagonal(node, 0);
        int n = -leftDMinValue + 1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            ans.add(new ArrayList<>());

        LinkedList<pairVO> que = new LinkedList<>();
        que.addLast(new pairVO(node, -leftMinValue));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                pairVO rpair = que.removeFirst();
                ans.get(rpair.vl).add(rpair.node.data);
                if (rpair.node.left != null)
                    que.addLast(new pairVO(rpair.node.left, rpair.vl - 1));
                if (rpair.node.right != null)
                    que.addLast(new pairVO(rpair.node.right, rpair.vl + 0));
            }
        }

        for (ArrayList<Integer> ar : ans)
            System.out.println(ar);
        System.out.println();
    }

    public static void diagonalSum(Node node) {
        widthDiagonal(node, 0);
        int n = -leftDMinValue + 1;
        int[] ans = new int[n];

        LinkedList<pairVO> que = new LinkedList<>();
        que.addLast(new pairVO(node, -leftMinValue));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                pairVO rpair = que.removeFirst();
                ans[rpair.vl] += rpair.node.data;
                if (rpair.node.left != null)
                    que.addLast(new pairVO(rpair.node.left, rpair.vl - 1));
                if (rpair.node.right != null)
                    que.addLast(new pairVO(rpair.node.right, rpair.vl + 0));
            }
        }

        for (int ele : ans)
            System.out.println(ele);
        System.out.println();
    }
}








/**
// Boundary traversal of a Binary tree
 */