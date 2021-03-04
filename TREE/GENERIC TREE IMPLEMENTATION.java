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



public class Solution{
    public static Node immediateSmallerElement(Node root,int x){

    }

    public static Node immediateSmallerElementUtil(Node root,int x){
        
    }
}


/**
N-ary Tree Preorder Traversal		
N-ary Tree Postorder Traversal		
//  | 429 | N-ary Tree Level Order Traversal |  Easy | Google |
//  | 559 | Maximum Depth of N-ary Tree |  Easy | Amazon, Google |
//  Diameter N Ary Tree
//  Check Mirror N Ary Tree



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