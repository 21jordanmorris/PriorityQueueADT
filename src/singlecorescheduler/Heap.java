package singlecorescheduler;

import java.util.*;

/**
 * This class models an array-list-based min binary heap that implements the
 * singlecorescheduler.HeapAPI interface. The array holds objects that implement the
 * parameterized Comparable interface.
 * @author Duncan, Jorda Morris
 * @param <E> the heap element type.
 * @since 09-11-2018
 */
public class Heap<E extends Comparable<E>> implements HeapAPI<E>
{
    /**
     * A complete tree stored in an array list representing this
     * binary heap
     */
    private ArrayList<E> tree;
    /**
     * A comparator lambda function that compares two elements of this
     * heap when rebuilding it; cmp.compare(x,y) gives 1. negative when x less than y
     * 2. positive when x greater than y 3. 0 when x equal y
     */
    private Comparator<? super E> cmp;

    /**
     * Constructs an empty heap using the compareTo method of its data type as the
     * comparator
     */
    public Heap()
    {
        //implement this method

    }

    /**
     * A parameterized constructor that uses an externally defined comparator
     * @param fn - a trichotomous integer value comparator function
     */
    public Heap(Comparator<? super E> fn)
    {
        // implement this method

    }

    public boolean isEmpty()
    {
        // implement this method

    }

    public void insert(E obj)
    {
        //implement this method

    }

    public E remove() throws HeapException
    {
        //implement this method

    }

    public E peek() throws HeapException
    {
        //implement this method

    }

    public int size()
    {
        //implement this method

    }

    /**
     * Swaps a parent and child elements of this heap at the specified indices
     * @param place an index of the child element on this heap
     * @param parent an index of the parent element on this heap
     */
    private void swap(int place, int parent)
    {
        //implement this method

    }

    /**
     * Rebuilds the heap to ensure that the heap property of the tree is preserved.
     * @param root the root index of the subtree to be rebuilt
     * @param eSize the size of this tree
     */
    private void rebuild(int root, int eSize)
    {
        //implement this method

    }
}
