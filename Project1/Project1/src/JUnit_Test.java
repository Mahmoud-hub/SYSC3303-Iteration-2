import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.*;


import org.junit.jupiter.api.Test;

class JUnit_Test {
	Thread myFloor;
	Thread myScheduler;
	Thread myElevator;
	Scheduler sch = new Scheduler();
	int num = 1;	
	public LocalTime time;
	
	@Test
	//Test floor thread  creation
	public void Test1() {
		myFloor = new Thread(new FloorSubsystem(sch), "Floor");
		String str = new String("Floor");
		assertEquals(str, this.myFloor.getName(),"Thread name is 'Floor'");
		assertNotEquals("Nothing", this.myFloor.getName());
	}
	@Test
	//Test scheduler thread creation
	public void Test2() {
		myScheduler = new Thread(sch, "Scheduler");
		assertEquals("Scheduler", this.myScheduler.getName(), "Thread name is 'Scheduler'");
		assertNotEquals("Nothing", this.myScheduler.getName());
	}
	@Test
	//Test elevator thread creation
	public void Test3() {
		myElevator = new Thread(new ElevatorSubsystem(num, sch), "Elevator");
		assertEquals("Elevator", this.myElevator.getName(), "Thread name is 'Elevator'");
		assertNotEquals("Nothing", this.myElevator.getName());
	}
	
	@Test
	//Test scheduler put method
	public void Test4() {
		RequestInfo temp = new RequestInfo("Up", 3, num, time.now());
		sch.sendInfo(temp);
		assertEquals(temp, sch.str, "NICE!");
		assertNotEquals(null, sch.str);
	}
	
	@Test
	//Test scheduler get method
	public void Test5() {
		RequestInfo temp = new RequestInfo("Up", 3, num, time.now());
		sch.sendInfo(temp);
		RequestInfo temp2 = sch.recieveInfo(true);
		assertEquals(null, sch.str, "NICE!");
		assertNotEquals(temp, sch.str);
		assertEquals(temp, temp2, "NICE!");	
		assertNotEquals(null, temp);
	}
	
	@Test
	//Test Struct class constructor
	public void Test6() {
		LocalTime timeTest = time.now();
		RequestInfo test = new RequestInfo("Up",2,3, timeTest);
		assertEquals("Up", test.direction, "NICE!");
		assertNotEquals(10, test.direction);
		assertEquals(2, test.floor, "NICE!");
		assertNotEquals(20, test.floor);
		assertEquals(3, test.elevator, "NICE!");
		assertNotEquals(30, test.elevator);
		assertEquals(timeTest, test.time, "NICE!");
		assertNotEquals(time.NOON, test.time);  //Assuming test is not run at NOON :)
		
	}
	
	@Test
	//Test FloorSubsystem's readInput method
	public void Test7() {
		Scheduler schedule = new Scheduler();
		FloorSubsystem testFloor = new FloorSubsystem(schedule);
		testFloor.readInput();
		LocalTime timeTest = LocalTime.parse(testFloor.tokens[0]);
		String direction = testFloor.tokens[2];
		int elevator = Integer.parseInt(testFloor.tokens[3]);
		int floor = Integer.parseInt(testFloor.tokens[1]);
		
		RequestInfo testInfo = new RequestInfo("Up",2,4, timeTest);
		
		assertEquals(testInfo.direction, direction, "NICE!");
		assertNotEquals("Invalid", direction);
		assertEquals(testInfo.floor, floor, "NICE!");
		assertNotEquals(20, floor);
		assertEquals(testInfo.elevator, elevator, "NICE!");
		assertNotEquals(30, elevator);
		assertEquals(testInfo.time, timeTest, "NICE!");
		assertNotEquals(time.NOON, timeTest); //Assuming test is not run at NOON :)
	}
	
}