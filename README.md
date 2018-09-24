# PriorityQueueADT
A Two-Mode Single-Core Non-Preemptive CPU Scheduling Simulator

# Learning Objectives
• To implement a priority queue ADT using the heap

• Manipulating an extensible array

• Simulating and Modeling a Queuing System

CPU scheduling is the basis of multiprogramming. Whenever a computer
CPU becomes idle, the operating system must select a process in the ready
queue to be executed. One application of priority queues in operating systems
is scheduling jobs on a CPU. In this project, you will write a program that
schedules simulated CPU jobs on a single-core processor. Your program
should run in a loop, each iteration of which corresponds to a time slice, one
CPU cycle. Each job is assigned a priority, which is a random integer between
-20 (highest priority) and 19 (lowest priority), inclusive. From among all
jobs waiting to be processed in a time slice, the CPU must work on a job
with the highest priority. When two jobs have the same priority the one
created earliest will be processed. In this simulation each job comes with
a length value, which is a random integer between 1 and 100, inclusive,
indicating the number of time slices that are needed to complete this job.
For simplicity, we will assume that the CPU is non-preemptive; that is, once
a job is scheduled on the CPU, a job runs for a number of time slices equal to
its length without being interrupted. Also, each process will have a process
identification number 1 . . . n, where n is the number of simulated processes
created.

# Modes of Operations of the Simulator
The simulator runs in two modes: random, denoted by the command line
argument -r or -R, or file, denoted by the command line argument -f or -F.
In either mode, the simulator runs with three command line arguments. In
either mode, the first command argument is a positive integer representing
the number of CPU cycles for the simulation. In random mode the remaining
command line arguments are the -r or -R flag followed a positive real number
less than or equal to 1.0 representing the probability that a process is created
during a CPU cycle. In file mode the remaining command line arguments are
the -f or -F flag followed by the file name of the file containing information
about the simulated jobs.

# simulatedjobsoutput.txt
Command Line Arguments for Given Result: 1000 -r .01
