
class Solution {

    public static Node findRightNode(Node root, int val) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                Node front = queue.poll();

                if (front.key == val) {
                    if (size == 0) {
                        return null;
                    }
                    return queue.peek();
                }

                if (front.left != null) {
                    queue.add(front.left);
                }
                if (front.right != null) {
                    queue.add(front.right);
                }
            }
        }

        return null;
    }
}


/**
Populating Next Right Pointers in Each Node
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
 */


class Solution {
    public Node connect(Node root) {
        Node curr = root;

        while (curr != null) {
            Node ln = curr;
            while (ln != null) {
                if (ln.left != null) {
                    ln.left.next = ln.right;
                }
                if (ln.right != null && ln.next != null) {
                    ln.right.next = ln.next.left;
                }
                ln = ln.next;
            }
            
            curr = curr.left;
        }

        return root;
    }
}