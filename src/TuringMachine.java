import java.util.ArrayList;
import java.util.Arrays;


public class TuringMachine {
	private TuringBand band;
	private TuringState states;
	
	private int currentState;
	private boolean terminated;
	
	public TuringMachine(ArrayList<String> initialBand, ArrayList<String> alphabet, int numberOfStates, int startState) {
		band = new TuringBand(initialBand);
		states = new TuringState(alphabet, numberOfStates);
		currentState = startState;
		terminated = false;
	}
	
	public void addStateFunction(int state, String[] write, Integer[] dir, Integer[] newStates) {
		ArrayList<String> w = new ArrayList<String>(Arrays.asList(write));
		ArrayList<Integer> d = new ArrayList<Integer>(Arrays.asList(dir));
		ArrayList<Integer> n = new ArrayList<Integer>(Arrays.asList(newStates));

		states.addState(state, w, d, n);
	}
	
	public void simulateStep() {
		String read = band.readHead();
		Object[] result = states.calcNext(read, currentState);
		if (result != null) {
			currentState = (int) result[2];
			band.writeHead((String) result[0]);
			band.moveHead((int) result[1]);
		} else {
			terminated = true;
		}
	}
	
	public String printBand() {
		return band.printBand();
	}
	
	public boolean isTerminated() {
		return terminated;
	}
	
}
