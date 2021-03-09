public class GenericTree{
    public static class Node{
        int data;  
        ArrayList<Node> childs=new ArrayList<>();
 
        Node(int data){
            this.data=data;
        } 
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack < Node > st = new Stack < > ();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node(arr[i]);

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static int size(Node root){
        int s = 0;

        for(Node child : root.children){
            s+=size(child);
        }

        return s+1;
    }
}



/**
Maximum Depth of N-ary Tree
Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by 
the null value (See examples).


Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: 3
 */

class Solution {
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        int h = 0;

        for (Node child: root.children) {
            int ch = maxDepth(child);
            h = Math.max(h, ch);
        }
        h += 1;

        return h;
}
}

/**
N-ary Tree Preorder Traversal
Given an n-ary tree, return the preorder traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by 
the null value (See examples).

Follow up:
Recursive solution is trivial, could you do it iteratively?

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]
 * 
 */

class Solution {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null)
            return list;
        
        list.add(root.val);
        for(Node node: root.children)
            preorder(node);
                
        return list;
    }
}

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        
        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }
        
        return list;
    }
}

/**
N-ary Tree Postorder Traversal
Given an n-ary tree, return the postorder traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by 
the null value (See examples).

Follow up:
Recursive solution is trivial, could you do it iteratively?

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]
 */

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root==null){
            return res;
        }
        
        for(Node child : root.children){
            postorder(child);
        }
        res.add(root.val);
        
        return res;
        
    }
}

class Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        
        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for(Node child : root.children){
                stack.add(child);
            }
        }
        Collections.reverse(list);
        
        return list;
        
    }
}




































/**
N-ary Tree Preorder Traversal		
N-ary Tree Postorder Traversal		
//  | 429 | N-ary Tree Level Order Traversal |  Easy | Google |
//  | 559 | Maximum Depth of N-ary Tree |  Easy | Amazon, Google |
//  Diameter N Ary Tree
//  Check Mirror N Ary Tree
N-ary Tree Level Order Traversal	Leet				https://leetcode.com/problems/n-ary-tree-level-order-traversal



// Function to find immediate Smaller Element 
// of a given number x 
void immediateSmallerElementUtil(Node* root, 
							int x, Node** res) 
{ 
	if (root == NULL) 
		return; 

	// if root is greater than res, but less 
	// than x, then update res 
	if (root->key < x) 
		if (!(*res) || (*res)->key < root->key) 
			*res = root; // Updating res 

	// Number of children of root 
	int numChildren = root->child.size(); 

	// Recursive calling for every child 
	for (int i = 0; i < numChildren; i++) 
		immediateSmallerElementUtil(root->child[i], x, res); 

	return; 
} 

// Function to return immediate Smaller 
// Element of x in tree 
Node* immediateSmallerElement(Node* root, int x) 
{ 
	// resultant node 
	Node* res = NULL; 

	// calling helper function and using 
	// pass by reference 
	immediateSmallerElementUtil(root, x, &res); 

	return res; 
} 



 */