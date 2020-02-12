/**
 * FloorSubsystem reads information in from a text file, puts the information into an instance of RequestInfo class 
 * and passes that instance to the scheduler using an instance of scheduler
 * @author Mahmoud Al Sous
 *
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;

public class FloorSubsystem implements Runnable {
	public String[] tokens;
	public ArrayList <RequestInfo> requests = new ArrayList<>(); 
	private Scheduler scheduler;
	private String direction;
	private int elevator;
	private int floor;
	private LocalTime time;
	
	/**
	 * Constructor for FloorSubsystem
	 * @param scheduler
	 */
	public FloorSubsystem(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
	
	/**
	 * Locates the file, accesses it and uses a scanner to read the file line by line.
	 * The scanner splits the line of input using spaces as separators and puts each of the inputs separated into a string array
	 * @return type: RequestInfo
	 */
	public ArrayList<RequestInfo> readInput() {
	File textFile = new File("InputFile.txt");
	
		Scanner scanner;
		try {
			scanner = new Scanner(textFile);
			
			while(scanner.hasNextLine()) {
				tokens = scanner.nextLine().split(" ");
				
				time = LocalTime.parse(tokens[0]);
				floor = Integer.parseInt(tokens[1]);
				direction = tokens[2];
				elevator = Integer.parseInt(tokens[3]);
			
				RequestInfo input = new RequestInfo(direction, floor, elevator, time);
				requests.add(input);
			}
			scanner.close();
			return requests;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * run() calls the readInput() method to return the info read into an instance variable and displays the information as a message
	 * as well as passes the information returned to the scheduler
	 */
	@Override
	public void run() {
		ArrayList <RequestInfo> input;
		input = readInput();
		for(RequestInfo i: input) {
			System.out.println("Floor requested at: " + " " + i.time + " " + i.floor + " " +i.direction + " " + i.elevator);
			scheduler.sendInfo(i);

			RequestInfo response = scheduler.recieveInfo(true);
			System.out.println("Elevator has arrived at floor : " + response.time + " "+ response.floor  + " "+response.direction + " "+ response.elevator + "\n");
		}
		
	}
}

