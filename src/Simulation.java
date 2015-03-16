
public class Simulation {

	public static void main(String[] args) {
		String in = "abab";
		String[] input = new String[in.length()];
		int l = in.length();
		for (int i = 0; i < l; i++) {
			String chr = in.substring(0, 1);
			input[i] = chr;
			in = in.substring(1);
		}
		
		String[] alphabet = {"a", "b", null};
		TuringMachine machine = new TuringMachine(input, alphabet, 5, 0);
		
		String[] write0 = {"a", "b", null};
		String[] write1 = {"b", "b", null};
		String[] write2 = {null, "a", null};
		String[] write3 = {"b", "b", null};
		String[] write4 = {"a", "b", null};
		
		Integer[] dir0 = {1, 1, null};
		Integer[] dir1 = {-1, 1, null};
		Integer[] dir2 = {null, 1, null};
		Integer[] dir3 = {-1, 1, -1};
		Integer[] dir4 = {-1, -1, 1};
		
		Integer[] st0 = {0, 1, 0};
		Integer[] st1 = {2, 1, 0};
		Integer[] st2 = {0, 3, 0};
		Integer[] st3 = {2, 3, 4};
		Integer[] st4 = {4, 4, 0};
		
		machine.addStateFunction(0, write0, dir0, st0);
		machine.addStateFunction(1, write1, dir1, st1);
		machine.addStateFunction(2, write2, dir2, st2);
		machine.addStateFunction(3, write3, dir3, st3);
		machine.addStateFunction(4, write4, dir4, st4);
		
		while (!machine.isTerminated()) {
			System.out.println(machine.printBand());
			machine.simulateStep();
		}
		System.out.println("\nSteps needed:\n" + machine.steps());
	}
}
