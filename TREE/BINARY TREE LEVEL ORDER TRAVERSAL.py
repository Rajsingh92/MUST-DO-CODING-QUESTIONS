'''
Binary Tree Level Order Traversal
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


public static void levelOrder(Node node) {
        Queue < Node > mq = new ArrayDeque < > ();
        mq.add(node);

        while (mq.size() > 0) {
            int cicl = mq.size();

            for (int i = 0; i < cicl; i++) {
                node = mq.remove();
                System.out.print(node.data + " ");

                if (node.left != null) {
                    mq.add(node.left);
                }

                if (node.right != null) {
                    mq.add(node.right);
                }
            }

            System.out.println();
        }
    }
'''
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []
        
        queue = [root]
        result = []
        
        while queue:
            current_level = []
            next_level = []
            
            for node in queue: 
                current_level.append(node.val)
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
                    
            result.append(current_level)
            queue = next_level
            
        
        return result        
                    


'''
Binary Tree Level Order Traversal II
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

'''
class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []
        
        queue = [root]
        result = []
        
        while queue:
            current_level = []
            next_level = []
            
            for node in queue: 
                current_level.append(node.val)
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
                    
            result.append(current_level)
            queue = next_level
            
        
        return result[::-1]  
                

