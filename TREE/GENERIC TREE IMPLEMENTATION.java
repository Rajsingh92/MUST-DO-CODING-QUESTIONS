//  | 429 | N-ary Tree Level Order Traversal |  Easy | Google |
//  | 559 | Maximum Depth of N-ary Tree |  Easy | Amazon, Google |
//  Diameter N Ary Tree
//  Check Mirror N Ary Tree


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
N-ary Tree Preorder Traversal		
N-ary Tree Postorder Traversal		
 */