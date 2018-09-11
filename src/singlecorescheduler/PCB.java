package singlecorescheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Models a process control block.
 * @author Duncan
 * @since 99-99-9999
 * Note: DO NOT MODIFY THIS FILE
 */
public class PCB implements Comparable<PCB>
{

    /**
     * the process ID
     */
    private int pid;
    /**
     * the priority value of this process
     */
    final private int priority;
    /**
     * running status
     */
    private int running;
    /**
     * cycle during which this process was created
     */
    private int arrived;
    /**
     * length of time this process will take to execute
     */
    private int length;
    /**
     * cycle during which this process begins executing
     */
    private int start;
    /**
     * how long the process waits before it begins executing
     */
    private int wait;

    /**
     * Creates a simulated job with default values for its parameters.
     */
    public PCB()
    {
        priority = 20;
        running = 0;
        arrived = 0;
        length = 0;
    }

    /**
     * Creates a simulated job with the specified parameters.
     * @param iD the process id
     * @param pVal the priority value
     * @param run the running status
     * @param arr the arrival time
     * @param len the number of cycles this process takes to execute
     */
    public PCB(int iD, int pVal, int run, int arr, int len)
    {
        pid = iD;
        priority = pVal;
        running = run;
        arrived = arr;
        length = len;
    }

    /**
     * Gives the ID of this job.
     * @return the process ID
     */
    public int getPid()
    {
        return pid;
    }

    /**
     * Gives the priority value of this process.
     * @return the priority value of this process
     */
    public int getPriority()
    {
        return priority;
    }

    /**
     * Indicates whether this process is executing..
     * @return the execution status of this process
     */
    public boolean isExecuting()
    {
        return running == 1;
    }

    /**
     * Sets the running status of this job.
     */
    public void execute()
    {
        running = 1;
    }

    /**
     * Gives the cycle during which this process was creates
     * @return the cycle during which this process was created.
     */
    public int getArrival()
    {
        return arrived;
    }

    /**
     * Gives the number of cycles required to execute this process.
     * @return the number of cycles required to execute this process
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Gives the cycle during which this process began executing.
     * @return the cycle during which this process began executing
     */
    public int getStart()
    {
        return start;
    }

    /**
     * Sets the cycle during which the process begins executing.
     * @param startCycle the cycle during which this process begins executing.
     */
    public void setStart(int startCycle)
    {
        start = startCycle;
    }

    /**
     * Gives the number of cycles this process waited before executing.
     * @return  the number of cycles from the process creation to its execution
     */
    public int getWait()
    {
        return wait;
    }

    /**
     * Sets the wait time for this process
     * @param waitTime the number of cycles that this process waited
     */
    public void setWait(int waitTime)
    {
        wait = waitTime;
    }

    /**
     * Compares this simulated job with the specified simulated job.
     * @param another a simulated process
     * @return 0 when this simulated job is the same as the specified
     * simulated job; -1 if this job will be executed after; otherwise 1.
     */
    public int compareTo(PCB another)
    {
        if (priority < another.priority)
            return 1;
        if (priority > another.priority)
            return -1;
        return 0;
    }
}
