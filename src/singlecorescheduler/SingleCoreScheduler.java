package singlecorescheduler;

/**
 * A application to simulate a non-preemptive scheduler for a single-core CPU
 * using a heap-based implementation of a priority queue
 * @author William Duncan, Jordan Morris
 * @since 9-20-2018
 * @see Heap.java, PCB.java
 * File:SingleCoreScheduler.java
 */


import java.io.*;
import java.nio.file.Files;
import java.util.*;

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

        int numberCycles = Integer.parseInt(args[0]);
        char mode = args[1].charAt(1);

        Heap<PCB> readyQ = new Heap<>();

        PrintStream outFile = new PrintStream(new File("simulatedjobsoutput.txt"));

        //RANDOM MODE
        if(mode == 'r' || mode == 'R') {
            double randProb = Double.parseDouble(args[2]);
            if(randProb < .01 || randProb > 1.00)
                System.out.println("Parameter args[2] is not a valid input.");
            else {
                double rNumber;
                for(int i = 1; i <= numberCycles; i++) {
                    //Cycle line 1 - cycle count
                    outFile.println("*** Cycle #: " + i);

                    //Cycle line 2 - CPU current task
                    if(readyQ.isEmpty())
                        outFile.println("The CPU is idle.");
                    else
                    {
                    }

                    //Cycle line 3 - Add new job if applicable
                    if(false) {

                    }
                    else
                    {
                        outFile.println("No new job this cycle.");
                    }
                }
            }
        }





        //FILE MODE
        else if(mode == 'f' || mode == 'F') {
            Scanner inFile = new Scanner(new FileReader(args[2]));

            //INITIALIZATION
            int id = 0, priority = 0, cycleStart = 0, length = 0;
            boolean iCS = true;

            double numberComp = 0, totalWait = 0;
            for (int i = 0; i < numberCycles + 1; i++) {

                //Cycle line 1 - cycle count
                outFile.println("*** Cycle #: " + i + " ***");

                //Cycle line 2 - CPU current task
                if (readyQ.isEmpty())
                    outFile.println("The CPU is idle.");
                else {
                    if (!(readyQ.peek().isExecuting())) {
                        readyQ.peek().execute();
                        readyQ.peek().setStart(i);
                        readyQ.peek().setWait(readyQ.peek().getStart() - readyQ.peek().getArrival());
                        totalWait += readyQ.peek().getStart() - readyQ.peek().getArrival();
                    }
                    if (readyQ.peek().getLength() == (i - readyQ.peek().getStart())) {
                        int pid = readyQ.peek().getPid();
                        readyQ.remove();
                        outFile.printf("Process #%d has just been terminated.%n", pid);
                        numberComp++;
                    } else {
                        outFile.printf("Process #%d is executing.%n", readyQ.peek().getPid());
                    }
                }

                if (iCS && inFile.hasNextLine()) {
                    String numbers = inFile.nextLine();
                    String[] numbersArray = numbers.split(" ");


                    id = Integer.parseInt(numbersArray[0]);
                    priority = Integer.parseInt(numbersArray[1]);
                    cycleStart = Integer.parseInt(numbersArray[2]);
                    length = Integer.parseInt(numbersArray[3]);

                }

                //Cycle line 3 - Add new job if applicable
                if (i == cycleStart) {
                    iCS = true;
                    PCB newPCB = new PCB(id, priority, 0, i, length);
                    readyQ.insert(newPCB);
                    outFile.printf("Adding job with pid %d and priority %d and length %d%n",
                            id, priority, length);
                } else {
                    outFile.println("No new job this cycle.");
                    iCS = false;
                }
            }
            double pPC = numberComp / (numberCycles + 1);
            outFile.printf("The average throughput is %.5f per cycle.%n", pPC);

            double avgWait = totalWait / numberComp;
            outFile.printf("The average wait time is %.1f", avgWait);
            inFile.close();
        }
    }
}

