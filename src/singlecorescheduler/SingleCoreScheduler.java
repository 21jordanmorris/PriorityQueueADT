package singlecorescheduler;

/**
 * A application to simulate a non-preemptive scheduler for a single-core CPU
 * using a heap-based implementation of a priority queue
 * @author William Duncan, Jordan Morris
 * @since 99-99-9999
 * @see Heap.java, PCB.java
 * File:SingleCoreScheduler.java
 */


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class SingleCoreScheduler
{
    /**
     * Single-core processor with non-preemptive scheduling simulator
     * @param args an array of strings containing command line arguments
     * args[0] - number of cyles to run the simulation
     * args[1] - the mode: -r or -R for random mode and -f or -F for file mode
     * args[2] - if the mode is random, this entry contains the probability that
     * a process is created per cycle and if the simulator is running in
     *           file mode, this entry contains the name of the file containing the
     *           the simulated jobs. In file mode, each line of the input file is
     *           in this format:
     * <process ID> <priority value> <cycle of process creation> <time required to execute>
     */
    public static void main(String[] args) throws HeapException, IOException {
        ArrayList<Integer> heapTest = new ArrayList<>();
        heapTest.add(16);
        heapTest.add(14);
        heapTest.add(10);
        heapTest.add(8);
        heapTest.add(7);
        heapTest.add(9);
        heapTest.add(3);
        heapTest.add(2);
        heapTest.add(4);
        heapTest.add(1);


        int parent = 0;
        if(((2 * parent) + 2 < heapTest.size()) || ((2 * parent) + 1 < heapTest.size())) {
            System.out.println("Not a Leaf: " + heapTest.get(parent));
        }
        else {
            System.out.print("Is a leaf Node");
        }
    }
}

