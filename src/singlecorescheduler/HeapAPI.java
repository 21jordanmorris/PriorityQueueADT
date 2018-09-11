package singlecorescheduler;

/**
 * This class reports Heap exceptions.
 * @author William Duncan
 * @since 99-99-999
 * Note: DO NOT MODIFY THIS FILE
 */
class HeapException extends Exception
{
    /**
     * Creates a new instance of <code>HeapException</code> without detail
     * message.
     */
    public HeapException() { }

    /**
     * Constructs an instance of <code>HeapException</code> with the specified
     * detail message.
     * @param msg the detail message.
     */
    public HeapException(String msg)
    {
        super(msg);
    }
}


/**
 * Describes the basic operations of a heap
 * @author Duncan
 * @param <E>
 * @since 99-99-9999
 */
public interface HeapAPI<E extends Comparable<E>>
{
    /**
     * Determine whether the Heap is empty.
     * @return this method returns true if the heap is empty;
     * otherwise, it returns false if the heap contains at least one item.
     */
    boolean isEmpty();

    /**
     * Inserts an item into the Heap.
     * @param item the value to be inserted.
     */
    void insert(E item);

    /**
     * An exception is generated if this method is invoked
     * by an empty heap. The maximum/minimum value is removed
     * from the heap if the heap is not empty and its effective
     * size is reduced by 1.
     * @return the maximum (in the case of a maxheap) or the
     * minimum (in the case of a minheap) on the heap.
     * @throws HeapException when the heap is empty
     */
    E remove() throws HeapException;

    /**
     * An exception is generated if this method is invoked
     * by an empty heap
     * @return the maximum (in the case of a maxheap) or the
     * minimum (in the case of a minheap) on the heap.
     * @throws HeapException when the heap is empty
     */
    E peek() throws HeapException;


    /**
     * Gives the size of this heap
     * @return the size of the heap; the effective size of the
     * heap.
     */
    int size();
}

