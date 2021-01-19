class Node:
    def __init__(self,data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None
    
    def insertAtstart(self,data):
        if self.head is None:
            newNode = Node(data)
            self.head = newNode
        else:
            newNode = Node(data)
            newNode.next = self.head
            self.head = newNode

    def insertAtEnd(self,data):
        if self.head is None:
            newNode = Node(data)
            self.head = newNode
        else:
            newNode = Node(data)
            curr = self.head
            while curr.next is not None:
                curr = curr.next
            curr.next = newNode

    def getPrevNode(self,refNode):
        curr = self.head
        while curr and curr.next!=refNode:
            curr = curr.next
        return curr

    def insertBetween(self,data,prev):
        if prev is None:
            print("Nothing")
            return
        else:
            newNode = Node(data)
            newNode.next = prev.next
            prev.next = newNode

    def delete(self,node):
        prev = self.getPrevNode(node)
        if prev is None:
            self.head = self.head.next
        else:
            prev.next = node.next


    def printLinkedList(self):
        if self.head is None:
            print("Nothing")
        else:
            curr = self.head
            while curr:
                print(curr.data,end=" ")
                curr = curr.next

    def printReverse(self):
        if head is None:
            return
        
        tmp = self.head
        self.printReverse(self.head.next)
        print(tmp.data)

    def size(self):
        if head is None:
            return 0

        return 1+self.size(self.head.next)


    


class CircularLinkedList:
    def __init__(self):
        self.head = None
    
    def insertAtStart(self,data):
        newNode = Node(data)

        if self.head is None:
            self.head = newNode
            newNode.next = self.head
        else:
            curr = self.head
            while curr and curr.next!= self.head:
                curr = curr.next
            newNode.next = self.head
            curr.next =  newNode
            self.head = newNode
        

    def printLinkedList(self):
        if self.head is None:
            print("Nothing")

        curr = self.head
        while True:
            print(curr.data,end=" ")
            curr  = curr.next
            if curr == self.head:
                break

    def isCircular(self):
        curr = self.head
        while curr:
            curr = curr.next
            if curr==self.head:
                return True
        return False

class DoublyNode:
    def __init__(self,data):
        self.data = data
        self.prev = None
        self.next = None

class DoublyLinkedList:
    def __init__(self,data):
        self.head = None
    
    def printLinkedList(self):
        if self.head is None:
            print("Nothing")
        else:
            curr = self.head
            while curr:
                print(curr.data,end=" ")
                curr = curr.next

    def insertAtStart(self,data):
        if self.head is None:
            newNode = DoublyNode(data)
            self.head = newNode
        else:
            newNode = DoublyNode(data)
            self.head.prev = newNode
            newNode.next = self.head
            self.head = newNode
    
    def insertAtEnd(self,data):
        if self.head is None:
            newNode = DoublyNode(data)
            self.head = newNode
        else:
            curr = self.head
            while curr and curr.next:
                curr = curr.next
            newNode = DoublyNode(data)
            curr.next = newNode
            newNode.prev = curr
    
    def printReverse(self):
        curr = self.head
        while curr : 
            curr = curr.next
        while curr:
            print(curr.data,end=" ")
            curr = curr.prev

    def delete(self,head,node):
        if head is None:
            return head
        
        prev = head
        while prev and prev.next!=node:
            prev = prev.next
            
        prev.next = node.next
    
    
    