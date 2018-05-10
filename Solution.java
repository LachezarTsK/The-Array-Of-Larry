import java.util.*;

public class LarryArrayForTest {
	public static String getResults(LinkedList<Integer> allElements) {
		String result;

		for (int i = 0; i < allElements.size() - 2; i++) {

			int currentIndex = allElements.indexOf(i + 1);
			if (currentIndex != i) {

				if (currentIndex == allElements.size() - 1) {

					int prevPrevElement = allElements.get(currentIndex - 2);
					int prevElement = allElements.get(currentIndex - 1);
					allElements.set(currentIndex - 2, prevElement);
					allElements.set(currentIndex - 1, i + 1);
					allElements.set(currentIndex, prevPrevElement);
					currentIndex = allElements.indexOf(i + 1);
				}

				int element = allElements.get(currentIndex);
				int nextElement = allElements.get(currentIndex + 1);
				allElements.remove(currentIndex);
				allElements.remove(currentIndex);

				allElements.add(i, element);
				allElements.add(i + 1, nextElement);

			}

		}
		if (allElements.get(allElements.size() - 2) < allElements.get(allElements.size() - 1)) {
			result = "YES";
		} else {
			result = "NO";
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int cases = reader.nextInt();
		String[] results = new String[cases];

		for (int i = 0; i < cases; i++) {
			int numberOfElements = reader.nextInt();
			LinkedList<Integer> allElements = new LinkedList<Integer>();
			for (int j = 0; j < numberOfElements; j++) {
				int element = reader.nextInt();
				allElements.add(element);
			}

			results[i] = getResults(allElements);
		}

		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i]);
		}
	}
}
