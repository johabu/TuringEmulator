import java.util.ArrayList;


public class Simulation {

	public static void main(String[] args) {
		ArrayList<String> test = new ArrayList<String>();
		test.add("hello");
		test.add("bye");
		/*TuringBand testband = new TuringBand(test);
		TuringState states = new TuringState(test, 2);
		states.addState(0, w, dir, n);
		states.calcNext("bye", 0);*/
		
		TuringMachine machine = new TuringMachine(test, test, 1, 0);
		String[] write = {"bye", "hello"};
		Integer[] dir = {1, 1};
		Integer[] st = {0, 0};
		
		machine.addStateFunction(0, write, dir, st);
		while (!machine.isTerminated()) {
			System.out.println(machine.printBand());
			machine.simulateStep();
			
		}		
		/*System.out.println(testband.printBand());
		testband.moveHead(1);
		System.out.println(testband.printBand());
		testband.moveHead(1);
		System.out.println(testband.printBand());
		testband.moveHead(-1);
		testband.moveHead(-1);
		testband.writeHead("test");
		System.out.println(testband.printBand());*/
	}
}
