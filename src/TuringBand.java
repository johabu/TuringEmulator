import java.util.ArrayList;


public class TuringBand {
	private TupleElement firstElement;
	private TupleElement lastElement;
	
	private TupleElement head;
	
	public TuringBand(ArrayList<String> initialBand) {
		lastElement = null;
		firstElement = lastElement;
		
		for (String str: initialBand) {
			insert(str);
		}
		head = firstElement;
	}
	
	public void insert(String str) {
		TupleElement newLast = new TupleElement(str, lastElement, null);
		if (firstElement == null) {
			firstElement = newLast;
		} else {
			lastElement.next = newLast;
		}
		lastElement = newLast;
	}
	
	public String readHead() {
		return head.content;
	}
	
	public void writeHead(String newContent) {
		head.content = newContent;
	}
	
	public void moveHead(int direction) {
		if (direction > 0) {
			if (head.next == null) {
				insert(null);
			}
			head = head.next;
		} else if (direction < 0) {
			if (head.previous == null) {
				TupleElement newFirstElement = new TupleElement(null, null, firstElement);
				firstElement = newFirstElement;
			}
			head = head.previous;
		} else {
			throw new IllegalArgumentException("invalid move");
		}
	}
	
	public String printBand() {
		String str = "";
		TupleElement iterator;
		iterator = firstElement;
		while (iterator != null) {
			if (iterator == head) {
				str += "[[HEAD]]";
			}
			if (iterator.content == null) {
				str += "NULL";
			} else {
				str += iterator.content + " ";
			}
			iterator = iterator.next;
		}
		return str;
	}
	
    private class TupleElement {
        TupleElement previous;
        TupleElement next;
        String content;

        TupleElement(String value, TupleElement pElement, TupleElement nElement) {
            content = value;
            previous = pElement;
            next = nElement;
        }
    }
}
