
/**
 * A struct like class used to take in the information read from the text file as a struct to pass it around the system
 * @author Ross Matthew
 *
 */

import java.time.LocalTime;

public class RequestInfo {
	public String direction;
	public int floor;
	public int elevator;
	public LocalTime time;
	
	public RequestInfo(String direction, int floor, int elevator, LocalTime time) {
		this.direction = direction;
		this.floor = floor;
		this.elevator = elevator;
		this.time = time;
	}
}
