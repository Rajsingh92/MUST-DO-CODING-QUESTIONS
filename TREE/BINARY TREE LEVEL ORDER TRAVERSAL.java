/**
| 102 | Binary Tree Level Order Traversal |  Medium | Apple, Google |
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]


class Solution{
    public static void levelOrder1(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while(queue.size()!=0){
            TreeNode rnode = queue.removeFirst();
            System.out.print(rnode.data + " ");
            if(rnode.left!=null) queue.addLast(rnode.left);
            if(rnode.right!=null) queue.addLast(rnode.right);
        }
    }

    public static void levelOrder2(TreeNode node) {
        LinkedList < TreeNode > pQue = new LinkedList < > (); 
        LinkedList < TreeNode > cQue = new LinkedList < > (); 

        pQue.addLast(node);


        while (pQue.size() != 0) {
            TreeNode rnode = pQue.removeFirst();
            System.out.print(rnode.data + " ");
            if (rnode.left != null) cQue.addLast(rnode.left);
            if (rnode.right != null) cQue.addLast(rnode.right);

            if (pQue.size() == 0) {
                LinkedList < TreeNode > temp = pQue;
                pQue = cQue;
                cQue = temp;
            }
        }
    }
}

 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        
        while(queue.size()!=0){
            
            int size = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            
            while(size-->0){
                TreeNode rnode = queue.removeFirst();
                if(rnode.left!=null){
                    queue.addLast(rnode.left);
                }
                if(rnode.right!=null){
                    queue.addLast(rnode.right);
                }
                
                subList.add(rnode.val);
            }
            
            res.add(subList);
        }
        
        return res;
    }
}

/**
| 107 | Binary Tree Level Order Traversal II |  Easy | Microsoft |
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by 
level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

 */

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        
        while(queue.size()>0){
            int size = queue.size();
            LinkedList<Integer> sublist = new LinkedList<>();
            
            while(size-->0){
                TreeNode node = queue.removeFirst();
                
                if(node.left!=null){
                    queue.addLast(node.left);
                }
                
                if(node.right!=null){
                    queue.addLast(node.right);
                }
                sublist.add(node.val);
            }
            res.add(0,sublist);
        }
        
        return res;
    }
}
