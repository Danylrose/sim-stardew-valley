# Project 2: Stardew Valley

* Author: Daniel Rosales-Rodriguez
* Class: CS321 Section #4001
* Semester: Fall 2023

## Overview

Project 2 implements and uses a priority abstract data type to simulate the game "Stardew Valley" utilizing a maxheap
data structure in which it generates priority-based tasks. Each node in the maxheap array holds a task object and are
comparable based on their priority and hour creation to assert which task ought to be completed first in the
scheduling algorithm. The task objects are generated based on probability, which are then rearranged and shuffled in via
MaxHeap.java and MyPriorityQueue.java to produce the scheduling system in the program. 

## Included Files

* MyLifeInStardew.java - source file
* StardewDailyClock.java - source file
* MaxHeap.java - source file
* MaxHeapTest.java - source file
* Task.java - source file
* TaskInterface.java - source file
* TaskGenerator.java - source file
* TaskGeneratorInterface.java - source file
* MyPriorityQueue.java - source file
* PriorityQueueInterface.java - source file
* HeapException.java - source file 
* run-tests.sh - test script (provided - Do not modify!)
* README.md - this file

## Reflection

The project itself was a challenge to write and implement, but I had a lot of fun in the process of completing it. A lot
of the backend development gave me trouble such as debugging MaxHeap to ensure it ran properly. Specifically, insert and
increaseKey were the methods that were the most difficult to get working. After completing all the required files to get
MyLifeInStardewValley compiled and running, I ran into a lot of nullpointer exceptions. This goes back to MaxHeap's
insert and increaseKey methods where I failed to properly initialize the current task to their respective task array
objects. After the debugging process I was able to write up JUnit tests to continue development. Shortly after, I ran
into issues regarding Task.java and MyPriorityQueue. This project had me learning how to interpret and translate various
pseudocodes in which I made simple errors such as having forgot to write in a line of logic to properly get the function
the method needed to execute properly.

These minor issues had me resorting for extra input on how to resolve the problem via the tutors. Fortunately, it didn't
take much to correct my mistakes since an extra pair of eyes and opinions led me to my success in completing Stardew.
This project taught me to think a bit further ahead in terms of understanding on how to implement algorithms and learn
to understand and write pseudocode. This project is what exposed me most to writing my own JUnit tests. In previous
projects I learned to write testers using lambda functions, but after reading and learning how to write my own tests I 
very much prefer JUnit testing. I found it to be a lot more intuitive and simple writing and running each separate test
method. The one issue I faced was figuring out how to work the tests and what values are to be expected and returned 
within the program. My expected and actual values were asserted using the assert methods JUnit already provides and led
me to successfully debug any exceptional and logical errors the arose in this project. 

Despite the difficulties I endured in writing Stardew valley I ought to say that this was the most interesting project
I've written so far and I am proud to have gotten this project to compile, run, and successfully match the test-script
outputs. 
    

## Compiling and Using

From the directory containing all the source files, compile the classes:
* $ javac MaxHeap.java MyLifeInStardew.java MyPriorityQueue.java PriorityQueueInterface.java StardewDailyClock.java Task.java TaskGenerator.java TaskGeneratorInterface.java TaskInterface.java

Run MyLifeInStardew.java, the output will display how to run it.
* $ java MyLifeInStardew

Output: java MyLifeInStardew Usage: 

* $ java MyLifeInStardew  [max-priority]   [time-to-increment-priority]  [total simulation-time in days]  [task-generation-probability]   [<seed>]

Run MyLifeInStardew.java with arguments <5> <1> <1> <0.5> <123>:
* $ java MyLifeInStardew 5 1 1 0.5 123

Outputs MyLifeInStardewValley Simulation:

+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
DAY: 1	LUCK: 0.76
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
6:00AM
7:00AM
NEW TASK: FISHING in the River at Hour: 2:00
8:00AM	     Fishing in the River at 200 energy points (Priority:0)
9:00AM	     Fishing in the River at 180 energy points (Priority:0)
10:00AM	     Fishing in the River at 160 energy points (Priority:0)
11:00AM	     Fishing in the River at 140 energy points (Priority:0)
12:00PM	     Fishing in the River at 120 energy points (Priority:0)
NEW TASK: FISHING in the Lake at Hour: 7:00
1:00PM	     Fishing in the River at 100 energy points (Priority:0)
2:00PM	     Fishing in the Lake at 80 energy points (Priority:1)
3:00PM	     Fishing in the River at 60 energy points (Priority:1)
4:00PM	     Fishing in the Lake at 40 energy points (Priority:1)
NEW TASK: FORAGING for Berries at Hour: 11:00
5:00PM	     Fishing in the River at 20 energy points (Priority:1)
6:00PM	     Fishing in the Lake at 0 energy points (Priority:1)
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
THE DAY IS OVER
Energy sufficiently depleted!
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Cash made today: +1650$
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

--- Simulation completed ---
Simulation time: 1 days
Total Tasks generated: 3
Total Simulation hours: 13 hours
Total Money made: 1650$
Total deaths/passouts: 0

Run dos2unix run-test.sh test-cases/* to convert text files to Linux Format:
$ dos2unix run-test.sh test-cases/*

Run chmod +x run-tests.sh on Onyx server to execute permission to run tests:
$ chmod +x run-tests.sh

Run ./run-tests.sh to run test-scripts:
$ ./run-tests.sh

Output:

===============================================================================
Running Test 1: java MyLifeInStardew 5 1 1 0.5 123
---- Test 1 output matches! ----
===============================================================================
Running Test 2: java MyLifeInStardew 10 1 5 0.5 1234
---- Test 2 output matches! ----
===============================================================================
Running Test 3: java MyLifeInStardew 10 1 5 0.75 -1234
---- Test 3 output matches! ----
===============================================================================
Running Test 4: java MyLifeInStardew 10 5 5 0.75 1
---- Test 4 output matches! ----
===============================================================================
Running Test 5: java MyLifeInStardew 100 1 10 0.9 123456789
---- Test 5 output matches! ----
===============================================================================
Running Test 6: java MyLifeInStardew 100 5 10 0.99 -12345
---- Test 6 output matches! ----
===============================================================================


## Results

Refer to compiling and using segment.

## Sources used

- https://github.com/BoiseState/CS321-resources.git
- https://docs.oracle.com/javase/8/docs/api/
- https://www.codesdope.com/blog/article/to-check-if-an-array-represents-min-or-max-heap/
- https://github.com/BoiseState/CS321-resources
- Boise State's CS321 Tutors
- Introductions to Algorithms 4th Edition

## Notes
