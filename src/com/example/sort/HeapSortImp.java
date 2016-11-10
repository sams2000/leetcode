package com.example.sort;

/**
 * heapSort.java demonstrate heap sort
 * Steps:

	Consider the values of the elements as priorities and build the heap tree.
	Start deleteMin operations, storing each deleted element at the end of the heap array.
	After performing step 2, the order of the elements will be opposite to the order in the heap tree.
	Hence, if we want the elements to be sorted in ascending order, we need to build the heap tree
	in descending order - the greatest element will have the highest priority.

	Note that we use only one array , treating its parts differently:
 *
 *	when building the heap tree, part of the array will be considered as the heap,
 *	and the rest part - the original array.
 *  when sorting, part of the array will be the heap, and the rest part - the sorted array.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    private int val;

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}

class Heap {
    private Node[] heap;
    private int capacity; // size of array
    private int currentSize; // number of items in array

    public Heap(int capacity) {
        this.capacity = capacity;
        currentSize = 0;
        heap = new Node[capacity];
    }

    /**
     * remove method
     * @return
     */
    public Node remove(){ 
        Node root = heap[0];
        heap[0] = heap[--currentSize];//move the last element to first
        heapDown(0);
        return root;
    }
    
    /**
     * invoked after remove() is called
     * @param index
     */
    public void heapDown(int index) {
        int largerChildIndex;
        Node top = heap[index]; // save root
        while (index < currentSize / 2){ // not on bottom row
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;
            
            // find larger child
            if (rightChildIndex < currentSize && // right ch exists?
                    heap[leftChildIndex].getVal() < heap[rightChildIndex]
                            .getVal()) {
                largerChildIndex = rightChildIndex;
            } else {
                largerChildIndex = leftChildIndex;
            }
            // top >= largerChild?
            if (top.getVal() >= heap[largerChildIndex].getVal()) {
                break;
            }
            // shift child up
            heap[index] = heap[largerChildIndex];
            index = largerChildIndex; // go down
        }
        heap[index] = top; // root to index
    }

    /**
     * invoked after add() is called
     * @param index
     */
    public void heapUp(int index){
        
    }
    
    public void displayHeap() {
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int i = 0; // current item
        String dots = "...............................";
        System.out.println(dots + dots); // dotted top line

        while (currentSize > 0){ // for each heap item
            if (column == 0) {
                for (int k = 0; k < nBlanks; k++) {
                    System.out.print(' ');
                }
            }
            // display item
            System.out.print(heap[i].getVal());

            if (++i == currentSize) {
                break;
            }

            if (++column == itemsPerRow){ // end of row?
                nBlanks /= 2; // half the blanks
                itemsPerRow *= 2; // twice the items
                column = 0; // start over on
                System.out.println(); // new row
            } else {
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(' '); // interim blanks
                }
            }
        }
        
        System.out.println("\n" + dots + dots); // dotted bottom line
    }

    public void displayArray() {
        for (int i = 0; i < capacity; i++) {
            System.out.print(heap[i].getVal() + " ");
        }
        System.out.println("");
    }

    public void insertAt(int index, Node newNode) {
        heap[index] = newNode;
    }

    public void incrementSize() {
        currentSize++;
    }

}

class HeapSortImp {
    public static void main(String[] args) throws IOException {
        //get input heap capacity/size
        System.out.print("Enter number of items: ");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        int capacity = Integer.parseInt(s);
      
        //initialize heap size
        Heap heap = new Heap(capacity);

        //fill array with random numbers, starting at index 0
        for (int i = 0; i < capacity; i++){ 
            int random = (int) (Math.random() * 100);
            Node newNode = new Node(random);
            heap.insertAt(i, newNode);
            heap.incrementSize();
        }

        System.out.print("Generated random numbers: ");
        heap.displayArray(); // display random array

        for (int i = capacity / 2 - 1; i >= 0; i--) {
            heap.heapDown(i);
        }

        System.out.print("Heap:   ");
        heap.displayArray(); // display heap array
        heap.displayHeap(); // display heap

        // remove root from heap and save it in later part of array
        for (int i = capacity - 1; i >= 0; i--){ 
            Node largestNode = heap.remove();
            heap.insertAt(i, largestNode);//put the largest node to the end as sorted array
        }
        System.out.print("Sorted: ");
        heap.displayArray(); // display sorted array
    } 
}
