/**
 * Scheduler receives information from FloorSubsystem and passes it to ElevatorSubsystem and vice versa.
 * @author Marko Simic
 *
 */
public class Scheduler implements Runnable {
	public boolean reply = true;
	public RequestInfo str;
	@Override
	public void run() {
		// Nothing to be done in run()
		
	}
	
	/**
	 * Takes in the information passed as an argument and notifies the system
	 * @param info
	 */
	public synchronized void sendInfo(RequestInfo info) {
		while(!(str == null)) {
			try {
				wait();
			}
			catch(InterruptedException e) {
				return;
			}
		}
		if(Thread.currentThread().getName().contains("Floor")) {
			reply = false;
		}
		else { 
			reply = true;
		}
		str = info;
		System.out.println("Scheduler recieved message  from : " + Thread.currentThread().getName() + " " + info.time + " " + info.floor + " " + info.direction + " "+ info.elevator);
		notifyAll();
	}
	
	/**
	 * Checks if it passing information or not, then returns the information to pass it to the other subsystems
	 * @param isReply
	 * @return
	 */
	public synchronized RequestInfo recieveInfo(boolean isReply) {
		
		while(str == null || !(isReply == reply)) {
			try {
				wait();
			}
			catch(InterruptedException e) {
				return null;
			}
		}
		RequestInfo data = str;
		str = null;
		notifyAll();
		return data;
	}
	

}
