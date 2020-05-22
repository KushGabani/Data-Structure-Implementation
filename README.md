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
     
     LinkedList() : A constructor for class LinkedList to initialise a LinkedList object.
     
     function createList() : This function creates a LinkedList for an object.
                             args : (int) An array containing the dataset to be implementated as LinkedList.
                             returns : void
     
     function add() : This is a subsidiary function that is used to a node at the end of a list.
                      args : (Node Object) A Node object containing the data to be inserted
                      returns : void
                   
     function addBegin() : This function is used to add a new node at the beginning of a list.
                           args : (Node Object) A Node object containing the data to be inserted
                           returns : void

     function addBetween() : This function is used to add a new node anywhere in the list
                             args : (Node Object) A Node object to be inserted, position of the object
                             returns : void
                             
     function pop() : This function is used to remove the last element of the LinkedList
                      args : null
                      returns : void
                      
     function shift() : This function is used to remove the first node of the LinkedList
                        args : null
                        returns : void
                       
     function searchNode() : This function is used to search a specific Node in the LinkedList
                              args : (int) The data to be searched
                              returns : boolean (True - if found, false - if not found)
                              
     function removeAt() : This function is used to remove a data from the LinkedList
                           args : (int) The data to be removed
                           returns : void
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
