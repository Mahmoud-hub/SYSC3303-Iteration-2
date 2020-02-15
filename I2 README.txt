SYSC 3303A2 - Iteration 2
Group: 3
Members: Archit Bhatia (101065674), Ross Matthew (101079586), Marko Simic (101072986), Michael Slokar (101092632), Mahmoud Al Sous (101071213)
-----------------------------------------------------------------------------------------------------------------
Files:

+ RequestInfo.java
	-> Used by all class to represent the input information between classes
 
+ ElevatorSubsystem.java
	->Receives input information from scheduler and notifies the elevator is ready
	->Sends the information back to scheduler
	->Includes a elevator state machine implementation

+ Scheduler.java
	->Passes information received from FloorSubsystem to ElevatorSubsystem and vice versa
	->Includes a scheduler state machine implementation

+ FloorSubsystem.java
	->Reads information from text file and puts it into an instance of RequestInfo class
	->Passes the instance to scheduler using instance of scheduler 

+ Test.java
	->Creates threads for floor and elevator and starts them
	->Creates instance of scheduler
	
+ JUnit_Test.java
	->Tests the methods of the classes with different inputs
	->Tests the states of the elevator and the scheduler

+ Elevator Subsystem State Diagram
	->Models the states of the elevator in the system

+ Scheduler State Diagram
	->Models the states of the scheduler within the system
-----------------------------------------------------------------------------------------------------------------
Instruction Set-up:

1) Run Test.java
2) Check console for logs
3) Run JUnit.java
4) Check console for test logs
-----------------------------------------------------------------------------------------------------------------
Breakdown of Responsibilities:

UML class diagram: Ross Matthew, Marko Simic
README.txt: Mahmoud Al Sous
UML sequence diagram: Mahmoud Al Sous
RequestInfo.java: Ross Matthew
ElevatorSubsystem.java: Archit Bhatia
Schedular.java: Michael Slokar
Test.java: Marko Simic
FloorSubsystem.java: Mahmoud Al Sous
JUnit_Test.java: Marko Simic
Elevator Subsystem State Diagram: Mahmoud Al Sous, Marko Simic
Scheduler State Diagram: Ross Matthew
