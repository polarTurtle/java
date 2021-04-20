import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MovingTotal {
    
	ArrayList<Integer> list = new ArrayList<>();
	Set<Integer> set = new HashSet<>();
	
    public void append(int[] list) {
		for (int i : list) {
			appendSingle(i);
		}
	}

	public void appendSingle(int value) {
		list.add(value);
		if (list.size() > 3) {
			list.remove(0);
		}
		if (list.size() == 3) {
			int sum = 0;
			for (int i : list)
				sum += i;
			set.add(sum);
		}
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {
		return set.contains(total);
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[] { 1, 2, 3 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));

        movingTotal.append(new int[] { 4 });

        System.out.println(movingTotal.contains(9));
    }
}