public class Rower {
	static String explore(CoordinatesPair destination, CoordinatesPair mcrCurrent) {
		String result = "";
		int i = mcrCurrent.x;
		int j = mcrCurrent.y;

		while (i < destination.x) {
			i++;
			result += "Right (" + i + ", " + mcrCurrent.y + ")\n";
		}
		while (i > destination.x) {
			i--;
			result += "Left (" + i + ", " + mcrCurrent.y + ")\n";
		}

		while (j < destination.y) {
			j++;
			result += "Up (" + destination.x + ", " + j + ")\n";
		}
		while (j > destination.y) {
			j--;
			result += "Down (" + destination.x + ", " + j + ")\n";
		}

		return result.trim();
	}

	public static void main(String[] args) {

		System.out.println(explore(new CoordinatesPair(2, 2), new CoordinatesPair(1, 1)));
	}
}