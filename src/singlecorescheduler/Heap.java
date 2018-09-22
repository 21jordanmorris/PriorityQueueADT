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
        tree = new ArrayList<E>();
        cmp = (e1, e2) ->
        {
          if(e1.compareTo(e2) > 0)
              return 1;
          if(e1.compareTo(e2) < 0)
              return -1;
          return 0;
        };
    }

    /**
     * A parameterized constructor that uses an externally defined comparator
     * @param fn - a trichotomous integer value comparator function
     */
    public Heap(Comparator<? super E> fn)
    {
//        cmp = (e1, e2) ->
//        {
//            if(e1 > e1)
//                return 1;
//            if(fn < e1)
//                return -1;
//            return 0;
//        };

    }

    public boolean isEmpty()
    {
        return tree.size() == 0;
    }

    public void insert(E obj)
    {
        tree.add(size(), obj);
        int place = tree.size() - 1;
        int parent = (place - 1) / 2;
        while((parent >= 0) && tree.get(place).compareTo(tree.get(parent)) > 0) {
            swap(place, parent);
            place = parent;
            parent = (place - 1) / 2;
        }
    }

    public E remove() throws HeapException
    {
        if(isEmpty()) {
            throw new HeapException("Method invoked by an empty heap.");
        }
        else {
            E root = tree.get(0);
            tree.set(0, tree.get(size() - 1));
            rebuild(0, size());
            return root;
        }

    }

    public E peek() throws HeapException
    {
        if(isEmpty())
            throw new HeapException("Method invoked by an empty heap.");
        return tree.get(0);
    }

    public int size() { return tree.size(); }

    /**
     * Swaps a parent and child elements of this heap at the specified indices
     * @param place an index of the child element on this heap
     * @param parent an index of the parent element on this heap
     */
    private void swap(int place, int parent)
    {
        E temp = tree.get(place);
        tree.set(place, tree.get(parent));
        tree.set(parent, temp);
    }

    /**
     * Rebuilds the heap to ensure that the heap property of the tree is preserved.
     * @param root the root index of the subtree to be rebuilt
     * @param eSize the size of this tree
     */
    private void rebuild(int root, int eSize)
    {
        if(((2 * root) + 2 < eSize) || ((2 * root) + 1 < eSize)) {
            int child = 2 * root + 1;
            if((2 * root) + 2 < eSize) {
                if(cmp.compare(tree.get(child+1), tree.get(child)) == -1)
                    child = child + 1;
            }
            if(cmp.compare(tree.get(root), tree.get(child)) == 1) {
                swap(root, child);
                rebuild(child, eSize);
            }
        }
    }

    /**
     * Prints Heap Array (primarily used for testing)
     */
    public void printTree() {
        System.out.println(tree.toString());
    }
}
