UTEID: kah3287;
FIRSTNAME: Kevin;
LASTNAME: Hwang;
CSACCOUNT: kh1994;
EMAIL: khwang1994@yahoo.com;

[Program 1]
[Description]

SecureSystem.java
    A representation of the system. Contains the main function. 
ReferenceMonitor.java
    The ReferenceMonitor class serves as the parition for information flow 
    between a subject and an object. Utilizes BLP when a valid READ or 
    WRITE instruction occurs in order to determine the effect on the system.
ObjectManager.java
    The ObjectManager class represents an object in the system.
Subject.java
    The Subject class represents a subject in the system.
SecurityLevel.java
    The SecurityLevel class stores the linear security level information for 
    the given system.
InstructionObject.java 
    The InstructionObject class takes the instruction as a String and stores
    the information about the instruction.
    
Compile this program with:
> javac SecureSystem.java

Run the test "instructionList" withi:
> java SecureSystem instructionList

[Finish]
As far as I know, I completed all the requirements for this project. 

[Test Cases]
[Input of test_l]
read lyle lobj
write lyle hobj 1000
read lyle hobj
there is a house in new orleans
write lyle lobj 525600
write hal lobj 15
they call the rising sun
write hal lobj
and it's been written for many a poor boy

[Output of test 1]
Reading from file: test_1

lyle reads lobj
The current state is:
        lobj has value: 0
        hobj has value: 0
        lyle has recently read: 0
        hal has recently read: 0

lyle writes value 1000 to hobj
The current state is:
        lobj has value: 0
        hobj has value: 1000
        lyle has recently read: 0
        hal has recently read: 0

lyle reads hobj
The current state is:
        lobj has value: 0
        hobj has value: 1000
        lyle has recently read: 0
        hal has recently read: 0

Bad Instruction
The current state is:
        lobj has value: 0
        hobj has value: 1000
        lyle has recently read: 0
        hal has recently read: 0

lyle writes value 525600 to lobj
The current state is:
        lobj has value: 525600
        hobj has value: 1000
        lyle has recently read: 0
        hal has recently read: 0

hal writes value 15 to lobj
The current state is:
        lobj has value: 525600
        hobj has value: 1000
        lyle has recently read: 0
        hal has recently read: 0

Bad Instruction
The current state is:
        lobj has value: 525600
        hobj has value: 1000
        lyle has recently read: 0
        hal has recently read: 0

Bad Instruction
The current state is:
        lobj has value: 525600
        hobj has value: 1000
        lyle has recently read: 0
        hal has recently read: 0

Bad Instruction
The current state is:
        lobj has value: 525600
        hobj has value: 1000
        lyle has recently read: 0
        hal has recently read: 0


[Input of test_2]
write lyle hobj 10
hello world
write hal lobj 1500
read hal lobj l
the end.

[Output of test 2]
Reading from file: test_2

lyle writes value 10 to hobj
The current state is:
        lobj has value: 0
        hobj has value: 10
        lyle has recently read: 0
        hal has recently read: 0

Bad Instruction
The current state is:
        lobj has value: 0
        hobj has value: 10
        lyle has recently read: 0
        hal has recently read: 0

hal writes value 1500 to lobj
The current state is:
        lobj has value: 0
        hobj has value: 10
        lyle has recently read: 0
        hal has recently read: 0

Bad Instruction
The current state is:
        lobj has value: 0
        hobj has value: 10
        lyle has recently read: 0
        hal has recently read: 0

Bad Instruction
The current state is:
        lobj has value: 0
        hobj has value: 10
        lyle has recently read: 0
        hal has recently read: 0

[Input of test_3]
write hal hobj 
write lyle lobj 10
write lyle hobj 20
foo lyle lobj
Hello, it's me
read hal
The missile launch code is 24601
read hal lobj 

[Output of test 3]
Reading from file: test_3

Bad Instruction
The current state is:
        lobj has value: 0
        hobj has value: 0
        lyle has recently read: 0
        hal has recently read: 0

lyle writes value 10 to lobj
The current state is:
        lobj has value: 10
        hobj has value: 0
        lyle has recently read: 0
        hal has recently read: 0

lyle writes value 20 to hobj
The current state is:
        lobj has value: 10
        hobj has value: 20
        lyle has recently read: 0
        hal has recently read: 0

Bad Instruction
The current state is:
        lobj has value: 10
        hobj has value: 20
        lyle has recently read: 0
        hal has recently read: 0

Bad Instruction
The current state is:
        lobj has value: 10
        hobj has value: 20
        lyle has recently read: 0
        hal has recently read: 0

Bad Instruction
The current state is:
        lobj has value: 10
        hobj has value: 20
        lyle has recently read: 0
        hal has recently read: 0

Bad Instruction
The current state is:
        lobj has value: 10
        hobj has value: 20
        lyle has recently read: 0
        hal has recently read: 0

hal reads lobj
The current state is:
        lobj has value: 10
        hobj has value: 20
        lyle has recently read: 0
        hal has recently read: 10

[Input of test 4]
write hal hobj 
write lyle hobj 20
foo lyle lobj
Hello from the other side
read hal
I must have called 1009324 times
read hal lobj 
write lyle lobj 10
read this file

[Output of test 4]
Reading from file: test_4

Bad Instruction
The current state is:
        lobj has value: 0
        hobj has value: 0
        lyle has recently read: 0
        hal has recently read: 0

lyle writes value 20 to hobj
The current state is:
        lobj has value: 0
        hobj has value: 20
        lyle has recently read: 0
        hal has recently read: 0

Bad Instruction
The current state is:
        lobj has value: 0
        hobj has value: 20
        lyle has recently read: 0
        hal has recently read: 0

Bad Instruction
The current state is:
        lobj has value: 0
        hobj has value: 20
        lyle has recently read: 0
        hal has recently read: 0

Bad Instruction
The current state is:
        lobj has value: 0
        hobj has value: 20
        lyle has recently read: 0
        hal has recently read: 0

Bad Instruction
The current state is:
        lobj has value: 0
        hobj has value: 20
        lyle has recently read: 0
        hal has recently read: 0

hal reads lobj
The current state is:
        lobj has value: 0
        hobj has value: 20
        lyle has recently read: 0
        hal has recently read: 0

lyle writes value 10 to lobj
The current state is:
        lobj has value: 10
        hobj has value: 20
        lyle has recently read: 0
        hal has recently read: 0

Bad Instruction
The current state is:
        lobj has value: 10
        hobj has value: 20
        lyle has recently read: 0
        hal has recently read: 0
