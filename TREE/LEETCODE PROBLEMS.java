/**
| 272 | Closest Binary Search Tree Value II |  Hard | Amazon |
| 98 | Validate Binary Search Tree |  Medium | Adobe, Amazon, Apple, Facebook, Microsoft |
| 124 | Binary Tree Maximum Path Sum |  Hard | Apple |
| 538 | Convert BST to Greater Tree |  Easy | Amazon |
| 669 | Trim a Binary Search Tree |  Easy | Amazon |
| 776 | Split BST |  Medium | Google |
| 783 | Minimum Distance Between BST Nodes |  Easy | Amazon |
| 865 | Smallest Subtree with all the Deepest Nodes |  Medium | Facebook |
| 894 | All Possible Full Binary Trees |  Medium | Google |
| 897 | Increasing Order Search Tree |  Easy | Facebook |
| 938 | Range Sum of BST |  Medium | Google |
| 96 | Unique Binary Search Trees |  Medium | Amazon, Google |
| 95 | Unique Binary Search Trees II |  Medium | Adobe, Amazon, Google |
| 99 | Recover Binary Search Tree |  Hard | Facebook, Google |
| 103 | Binary Tree Zigzag Level Order Traversal |  Medium | Adobe, Google |
| 108 | Convert Sorted Array to Binary Search Tree |  Easy | Adobe, Apple |
| 113 | Path Sum II |  Medium | Amazon, appdynamics, Facebook, Google |
| 112 | Path Sum |  Easy | Amazon |
| 114 | Flatten Binary Tree to Linked List |  Medium | Adobe, Amazon, Microsoft |
| 117 | Populating Next Right Pointers in Each Node II |  Medium | Amazon, Facebook, Google, Microsoft |
| 116 | Populating Next Right Pointers in Each Node |  Medium | Facebook |
| 129 | Sum Root to Leaf Numbers |  Medium | Google |
| 173 | Binary Search Tree Iterator |  Medium | Google |
| 222 | Count Complete Tree Nodes |  Medium | Facebook, Google |
| 226 | Invert Binary Tree |  Easy | Adobe, Amazon, Facebook |
| 250 | Count Univalue Subtrees |  Medium | Amazon |
| 257 | Binary Tree Paths |  Easy | Amazon, Facebook, Microsoft |
| 270 | Closest Binary Search Tree Value |  Easy | Google |
| 285 | Inorder Successor in BST |  Medium | Facebook, Microsoft |
| 510 | Inorder Successor in BST II |  Medium | Google |
| 298 | Binary Tree Longest Consecutive Sequence |  Medium | Facebook |
| 549 | Binary Tree Longest Consecutive Sequence II |  Medium | Google |
| 333 | Largest BST Subtree |  Medium | Amazon, Google, Microsoft |
| 337 | House Robber III |  Medium | Amazon, Facebook, Google |
| 366 | Find Leaves of Binary Tree |  Medium | Amazon, Google |
| 404 | Sum of Left Leaves |  Easy | Amazon |
| 437 | Path Sum III |  Easy | Amazon, Facebook |
| 508 | Most Frequent Subtree Sum |  Medium | Amazon |
| 545 | Boundary of Binary Tree |  Medium | Amazon |
| 572 | Subtree of Another Tree |  Easy | Google |
| 617 | Merge Two Binary Trees |  Easy | Amazon |
| 637 | Average of Levels in Binary Tree |  Easy | Amazon, Facebook |
| 652 | Find Duplicate Subtrees |  Medium | Google |
| 653 | Two Sum IV - Input is a BST |  Easy | Google |
| 654 | Maximum Binary Tree |  Medium | Amazon |
| 655 | Print Binary Tree |  Medium | Microsoft |
| 662 | Maximum Width of Binary Tree |  Medium | Google |
| 663 | Equal Tree Partition |  Medium | Facebook |
| 671 | Second Minimum Node In a Binary Tree |  Easy | Microsoft |
| 742 | Closest Leaf in a Binary Tree |  Medium | Google |
| 701 | Insert into a Binary Search Tree |  Medium | Microsoft |
| 834 | Sum of Distances in Tree |  Hard | Google |
| 863 | All Nodes Distance K in Binary Tree |  Medium | Amazon, Google, Microsoft |
| 872 | Leaf-Similar Trees |  Easy | Facebook, Google |
| 951 | Flip Equivalent Binary Trees |  Medium | Google |
| 958 | Check Completeness of a Binary Tree |  Medium | Facebook, Microsoft |
| 968 | Binary Tree Cameras |  Hard | Google |
| 979 | Distribute Coins in Binary Tree |  Medium | Amazon, Google, Microsoft |
| 1022 | Sum of Root To Leaf Binary Numbers |  Easy | Amazon |
| 426 | Convert Binary Search Tree to Sorted Doubly LinkedList |  Medium | Facebook, Google, Microsoft |
| 208 | Implement Trie (Prefix Tree) |  Medium | Amazon |
| 336 | Palindrome Pairs 30.7% |  Hard | Facebook |
| 642 | Design Search Autocomplete System |  Hard | Google |
| 676 | Implement Magic Dictionary |  Medium | Google |
| 720 | Longest Word in Dictionary |  Easy | Amazon, Google |
| 745 | Prefix and Suffix Search |  Hard | Google |

public TreeNode buildTree(int[] preorder,int psi,int pei, int[] inorder,int isi,int iei){
        if(psi > pei) return null;

        TreeNode node = new TreeNode(preorder[psi]);
        int idx = isi;
        while(inorder[idx]!=preorder[psi]){
            idx++;
        }

        int count = idx - isi; // countOfNodesInLeftSubTree.

        node.left = buildTree(preorder,psi+1,psi+count,inorder,isi,idx-1);
        node.right = buildTree(preorder,psi+count+1,pei,inorder,idx+1,iei);

        return node;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        int n = preorder.length;

        return buildTree(preorder,0,n-1,inorder,0,n-1);
    }

    //106
    public TreeNode buildTree(int[] postorder,int psi,int pei, int[] inorder,int isi,int iei) {
        if(psi > pei) return null;

        TreeNode node = new TreeNode(postorder[pei]);
        int idx = isi;

        while(inorder[idx] != postorder[pei]){
            idx++;
        }

        int count = idx - isi;

        node.left = buildTree(postorder,psi,psi + count - 1, inorder, isi,idx-1);
        node.right = buildTree(postorder,psi + count,pei-1, inorder, idx+1,iei);

        return node;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
            if(postorder.length==0) return null;
            int n = postorder.length;
    
            return buildTree(postorder,0,n-1,inorder,0,n-1);
    }

    //Leetcode 889
    public TreeNode buildTree(int[] postorder,int posi,int poei, int[] preorder,int psi,int pei) {
        if(psi > pei) return null;
        if(psi == pei) return new TreeNode(preorder[psi]); // leaf node

        TreeNode node = new TreeNode(preorder[psi]);
        int idx = posi;

        while(postorder[idx] != preorder[psi + 1]){
            idx++;
        }

        int count = idx - posi + 1;

        node.left = buildTree(postorder,posi,posi + count - 1, preorder, psi+1,psi + count);
        node.right = buildTree(postorder,posi + count,poei-1, preorder,psi + count + 1, pei);

        return node;
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(post.length==0) return null;
        int n = post.length;

        return buildTree(post,0,n-1,pre,0,n-1);        
    }
 */


