import java.lang.reflect.MalformedParametersException;
import java.util.ArrayList;

public class TuringState {
	
	private ArrayList<String> alphabet;
	private Object[][][] function;
	
	public TuringState(ArrayList<String> a, int stateNumber) {
		alphabet = a;
		function = new Object[stateNumber][alphabet.size()][3];
	}
	
	public void addState(int id, ArrayList<String> writeSymbols, ArrayList<Integer> directions, ArrayList<Integer> newStates) {
		if (writeSymbols.size() == directions.size() && writeSymbols.size() == newStates.size() && writeSymbols.size() == alphabet.size() ) {
			for (int i = 0; i < alphabet.size(); i++) {
				if (directions.get(i) != null && newStates.get(i) != null) {
					function[id][i][0] = writeSymbols.get(i);
					function[id][i][1] = directions.get(i);
					function[id][i][2] = newStates.get(i);
				} else {
					function[id][i] = null;
				}
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public Object[] calcNext(String read, int state) {
		if (alphabet.indexOf(read) < 0) {
			return null;
		}
		Object[] n = function[state][alphabet.indexOf(read)];
		return n;
	}
}
