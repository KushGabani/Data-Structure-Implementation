# Data-Structure-Implementation
##### Implementations of all Data Structures like Heap, BST, AVL Tress, LinkedList etc.  

### Note : Please remove the first line of each file before using it locally. Remove -> "package DataStructures" 
#### (Ongoing work : The contents may be subject to change)


The following implementation of the data structures are just for education purposes and is not meant to be referred to as guide. These data structure implemenetation includes basic functions of ADTs.

#### LinkedList.java -> This file contains the following contents :-
     Class LinkedList : This Class encapsulates the implementation of the list ADT.
     
     Core Variables of Class LinkedList : 
                      head - (Node Object) A pointer to head of the LinkedList.
                      tail - (Node Object) A pointer to the tail of the LinkedList.
                      size - (int) The size of the LinkedList.
                                          
     
     Class Node : This is a nested class used inside LinkedList and provides basic building block for the LinkedList.
     
     Core variables of Class Node : 
                      data - (int) The data stored in the node
                      next - (Node Object) A pointer to the next Node
     
     LinkedList() : A constructor for class LinkedList to initialise a LinkedList object.
     
     function createList() : This function creates a LinkedList for an object.
                             args : (int) An array containing the dataset to be implementated as LinkedList.
                             returns : void
     
     function add() : This is a subsidiary function that is used to a node at the end of a list.
                      args : (Node Object) A Node object containing the data to be inserted
                      returns : void
                   
     function displayList() : This function displays all the nodes in the LinkedList.
                   
     function addBegin() : This function is used to add a new node at the beginning of a list.
                           args : (Node Object) A Node object containing the data to be inserted
                           returns : void

     function addBetween() : This function is used to add a new node anywhere in the list
                             args : (Node Object) A Node object to be inserted, position of the object
                             returns : void
                             
     function pop() : This function is used to remove the last element of the LinkedList
                      args : null
                      returns : (int) -1 if the list is empty.
                      
     function shift() : This function is used to remove the first node of the LinkedList
                        args : null
                        returns : void
                       
     function searchNode() : This function is used to search a specific Node in the LinkedList
                              args : (int) The data to be searched
                              returns : boolean (True - if found, false - if not found)
                              
     
     function getNode() : This function is used to search a specific Node in the LinkedList and return the node.
                              args : (int) The data to be searched
                              returns : (Node object)
                              
     function getPreviousNode() : This function is used to search a node in the list and return its predecessor.
                                  args : (int) The data whose predecessor needs to be found.
                                  retunrs : (Node Object) It's predecessor.
                              
     function remove() : This function is used to remove a data from the LinkedList
                           args : (int) The data to be removed
                           returns : void
                           
      function update() : This function is used to update a value in the LinkedList.
                          args : (int) The old value to be update, (int) The new value to be replaced.
                          returns : void
<br>                  
<hr>
<br>

#### DoublyLinkedList.java -> This file contains the following contents :-
     Class DoublyLinkedList : This Class encapsulates the implementation of the Doubly LinkedList ADT.
     
     Core Variables of Class LinkedList : 
                      head - (Node Object) A pointer to head of the LinkedList.
                      tail - (Node Object) A pointer to the tail of the LinkedList.
                      size - (int) The size of the LinkedList.
                                          
     
     Class Node : This is a nested class used inside LinkedList and provides basic building block for the DoublyLinkedList.
    
     Core variables of Class Node : 
                      data - (int) The data stored in the node
                      next - (Node Object) A pointer to the next Node
                      prev - (Node Object) A pointer to the previous Node.
     
     DoublyLinkedList() : A constructor for class DoublyLinkedList to initialise a DoublyLinkedList object.
     
     function createList() : This function creates a DoublyLinkedList for an object.
                             args : (int) An array containing the dataset to be implementated as LinkedList.
                             returns : void
     
     function add() : This is a subsidiary function that is used to a node at the end of a list.
                      args : (Node Object) A Node object containing the data to be inserted
                      returns : void
                      
     function displayList() : This function is used to display all the nodes in the list.
     
     function displayReverse() : This function is used to display all the nodes in the list in reverse order.
                   
     function addBegin() : This function is used to add a new node at the beginning of a list.
                           args : (Node Object) A Node object containing the data to be inserted
                           returns : void

     function addBetween() : This function is used to add a new node anywhere in the list
                             args : (Node Object) A Node object to be inserted, position of the object
                             returns : void
                             
     function pop() : This function is used to remove the last element of the DoublyLinkedList
                      args : null
                      returns : void
                      
     function shift() : This function is used to remove the first node of the DoublyLinkedList
                        args : null
                        returns : void
                       
     function searchNode() : This function is used to search a specific Node in the DoublyLinkedList
                              args : (int) The data to be searched
                              returns : boolean (True - if found, false - if not found)
                              
     
     function getNode() : This function is used to search a specific Node in the DoublyLinkedList and return the node.
                              args : (int) The data to be searched
                              returns : (Node object)
                              
     function getPreviousNode() : This function is used to search a node in the list and return its predecessor.
                                  args : (int) The data whose predecessor needs to be found.
                                  retunrs : (Node Object) It's predecessor.
                              
     function remove() : This function is used to remove a data from the DoublyLinkedList
                           args : (int) The data to be removed
                           returns : void
                           
      function update() : This function is used to update a value in the DoublyLinkedList.
                          args : (int) The old value to be update, (int) The new value to be replaced.
                          returns : void
<br>                  
<hr>
<br>

#### StackWithLinkedList.java -> This file contains the following content :-
      Class StackWithLinkedList : This class encapsulates the implementation of stack ADT using LinkedList
      
      function StackWithLinkedList : This is a constructor that is used to intialise a stack object.
                                    args : (int[]) dataset of integers to add into the stack

     function StackWithLinkedList : This is an overloaded constructor that is used to initilialise a default stack object.

     function push() : This function is used to add an element into the stack.
                      args : (int) The element to be added.
                      return : void
                      
     function pop() : This function is used to remove an element into the stack.
                      args : null
                      return : (int) the elemenet popped from the stack. 1 if the stack is empty.
                      
     function peek() : This function is used to retrieve the value of top most element of the stack without removing it.
                       args : void
                       return : (int) -1 if the stack is empty.
     
<br>
<hr>
<br>

 #### StackWithArray.java -> This file contains the followuing content :-
      Class StackWithArray : This class encapsulates the implementation of stack ADT using arrays
      
      function StackWithArray : This is a constructor that is used to intialise a stack object.
                               args : (int[]) dataset of integers to add into the stack

     function StackWithArray : This is an overloaded constructor that is used to initilialise a default stack object
                              args : (int) the size of the stack.

     function push() : This function is used to add an element into the stack.
                      args : (int) The element to be added.
                      return : void
                      
     function pop() : This function is used to remove an element into the stack.
                      args : null
                      return : (int) the elemenet popped from the stack. 1 if the stack is empty.
                      
     function peek() : This function is used to retrieve the value of top most element of the stack without removing it.
                       args : void
                       return : (int) -1 if the stack is empty.
 
<br>
<hr>
<br>

#### Heap.java -> This file contains the following contents :-
     Class Heap : This Class encapsulates the implementation of a Heap Data Structure (Specifically a MAX HEAP). A min heap can be implemented symmetrically.
     
     Core variables of class Heap :
                     heap - (ArrayList<Integer>) A dynamic array to visualise Heap Data Structure
                     
     function Heap() : A constructor of Heap class used to initialise its objects.
                       args : (int[]) An array of integers to be visualised as a heap.
                       returns : void
                       
     function Heap() : A overloaded constructor of Heap Class used to initialise its objects.
     
     PRIVATE function getLeftChild() : A private function that returns the index of left child of an element
                                       args : (ArrayList<Integer>) the heap itself, (int) index of the element whose left child's index need to be found.
                                       returns : int
     
     PRIVATE function getRightChild() : A private function that returns the index of right child of an element.
                                       args : (ArrayList<Integer>) the heap itself, (int) index of the element whose right child's index need to be found.
                                       returns : int
                                       
     function swap() : This function is used to swap to elements in the array
                       args : (int) First element's index, (int) Second element's index
                       returns : void
                       
     function heapify() : A recursive function that is used to bubble up an element to satisy the heap representation invariant a.k.a. rep. invariant.
                          args : (int) index of the element to bubble up
                          returns : void
                          
     function maxHeap() : This function is used to convert an array into MAX HEAP
                          args : null
                          returns : void
                          
     function displayHeap() : This function is used to print all the elements of the heap.
                               args : null
                               returns : void
                               
     function insertNode() : This function is used to insert a new element in the heap
                             args : (int) The data to be inserted
                             returns : void
                             
     function removeNode() : This function is used to remove an element from the heap
                             args : (int) index of the element
                             returns : (int) the value removed from the heap.
                             
     function heapSort() : This function is used to sort an array using heap sort algorithm
                           args : null
                           returns : void
     
<br>
<hr>
<br>
    
#### PriorityQueue.java -> This file contains the following contains :-
###### for simplicity, the value of the element determines its priority. i.e. An element with a large value has high priority.

     Class PriorityQueue : This class encapsulates the implementation of a PriorityQueue data structure. This Class inherits the Class Heap from Heap.java above.
     
     Core variables of the class PriorityQueue -
                         * There is no internal variables because it inherits Heap.java *
     
     function PriorityQueue() : A constructor that is used to initialise to create a priority queue.
     
     function PriorityQueue() : An overloaded constructor that is used to initialise to create a priority queue with a speicied data set.
                                args : (int[]) An array of integers containing the values to be inserted in the priority queue
                                returns : void
                                
     function enqueue() : This function inserts a value into the priority queue
                          args : (int) The element to be inserted.
                          returns : 
     
     function dequeue() : This function returns and removes the element with the highest priority in the prioirity queue.
                           args : null
                           returns : (int) the element with the highest priority.
                           
     function peek() : This function only returns the element with the highest priority.


#### Tree.java -> This file contains the following contents :-
     
     Class Tree : This class encapsulates the implementation of a Tree Data Structure specifically a BST (Binary Search Tree)
     
     Core variables of the Class Tree : 
                           root -  (Node object) A pointer to the root node of the tree.
                           size - (int) The size of the tree i.e. Height of the tree.
     
     Class Node : This is a nested class that produces nodes for the tree.
     
     Core varibles of the Class Node :
                          data - (int) this contains the value of the node.
                          leftChild - (Node Object) A pointer to the left subtree of the node.
                          rightChild - (Node Object) A pointer to the right subtree of the node.
                          parent - (Node Object) A pointer to the parent of the node.
              
     function Tree() : A constructor to intialise the tree's object.
                      root - sets root to null
                      size - sets size to 0
                      function createTree() - A call to create a tree
                      
     function createTree() : A function to create a tree object
                              args : (int[]) Dataset for the tree
                              returns : void
                              
     function addNodes() : A stand alone and a subsidiary function of createTree() function to add nodes into the tree.
                             args : (Node Object) New node to be added, (Node Object) A parent of the tree, generally the root.
                             returns : void
                             
     function displayTree() : A function to display trees in the specified order 
                              1. Inorder Traversal
                              2. Preorder Traversal
                              3. Postorder Traversal
                              args : (int) The choice of display as shown above
                              returns : void
                              
     PRIVATE function hasLeftChild() : This function is used to check whether a node has a left child or not
                                   args : (Node Object) the node whose child needs to be identified
                                   returns : (boolean) true if found, else false
                                   
     PRIVATE function hasRightChild() : This function is used to check whether a node has a right child or not
                                   args : (Node Object) the node whose child needs to be identified
                                   returns : (boolean) true if found, else false
                                   
     PRIVATE function hasNoChild() : This function is used to check whether a node does not have any child
                                   args : (Node Object) the node whose child needs to be identified
                                   returns : (boolean) true if found, else false
     
     PRIVATE function hasBothChild() : This function is used to check whether a node has both left child and right child
                                   args : (Node Object) the node whose child needs to be identified
                                   returns : (boolean) true if found, else false
     
     PRIVATE function hasOneChild() : This function is used to check whether a node has a at most 1 child.
                                   args : (Node Object) the node whose child needs to be identified
                                   returns : (boolean) true if found, else false
     
     function inorderTraversal() : This subsidiary function is used to display the elements of the tree using inorder method.
                                  args : (Node Object) The node from where the print should began, generally the root node.
                                  return : void
     
     function preorderTraversal() : This subsidiary function is used to display the elements of the tree using preorder method.
                                  args : (Node Object) The node from where the print should began, generally the root node.
                                  return : void
     
     function postorderTraversal() : This subsidiary function is used to display the elements of the tree using postorder method.
                                  args : (Node Object) The node from where the print should began, generally the root node.
                                  return : void
                                  
     function searchNode() : This function is used to search a node inside a tree.
                           args : (Node Object) The node that needs to be found
                           return : (boolean) true if found, else false.
                           
     function getNode() : This function is used to search and get the node address in a tree
                           args : (Node ObjecT) The node that needs to be searched.
                           return : (Node Object) The Node if found, else null;
                           
     function min() : A function to find and return the value of the smallest node.
     
     function max() : A function to find and return the value of the largest node.
     
     function min() : An overloaded function to find and return the smallest node.
                      args : (Node Object) The address of the node from where smallest node must be searched
                      return : (Node Object) the smallest node.
     
     function max() : An overloaded function to find and return the largest node.
                      args : (Node Object) The address of the node from where smallest node must be searched
                      return : (Node Object) the largest node.
                      
     function remove() : A function to remove a node from the tree and satisfy the BST rep. invariant.
                       args : (Node Object) the root of the tree, (int) the value to be deleted
                       returns : (Node Object) the node deleted from the tree.
                       
<br>
<hr>
<br>
     
     
