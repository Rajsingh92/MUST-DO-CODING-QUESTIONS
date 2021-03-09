#Print all nodes that don’t have sibling

def printSingle(root):
    if root is None:
        return 0

    if root.left is not None and root.right is None:
        print(root.left.data,end=" ")
        printSingle(root.left)

    if root.right is not None and root.left is None:
        print(root.right.data,end=" ")
        printSingle(root.right)

    if root.left and root.right:
        printSingle(root.left)
        printSingle(root.right)