/**
 * Elevator Subsystem receives the input information from the scheduler and notifies that the elevator is ready
 * then sends the information back to the scheduler.
 * @author Ross Matthew
 *
 */
public class ElevatorSubsystem implements Runnable{
	private int elevatorNum;		//Declaration of class fields
	private Scheduler scheduler;
	private RequestInfo info;
	
	/**
	 * Constructor for the Elevator Subsystem class
	 * @param elevatorNum
	 * @param s
	 */
	public ElevatorSubsystem(int elevatorNum, Scheduler s) {
		this.elevatorNum = elevatorNum;
		this.scheduler = s;
	}
	
	/**
	 * run() receives the information from the scheduler, prints out a message 
	 * and sends the information back using an instance of scheduler
	 */
	public void run() {
		while(true) {
			info = scheduler.recieveInfo(false);
			System.out.println("Elevator Recieved: "+  info.time + " " + info.floor + " " + info.direction + " " + info.elevator);
			System.out.println("Elevator " + this.elevatorNum + " is ready to move.");
			scheduler.sendInfo(info);
		}
		
	}

}

