/**
 * @author Marko Simic
 *
 */
public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Thread floor;
		Thread elevator;
		
		Scheduler sch = new Scheduler();
		
		floor = new Thread(new FloorSubsystem(sch), "Floor");
		elevator = new Thread(new ElevatorSubsystem(1, sch),"Elevator1");
		floor.start();
		elevator.start();
	}
}

