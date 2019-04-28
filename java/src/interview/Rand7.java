package interview;

import java.util.Random;

public class Rand7 {
	// get random number between [1, 7]
	// this can run forever in the worst case
	public int rand7() {
		int[][] vals = { { 1, 2, 3, 4, 5 }, { 6, 7, 1, 2, 3 }, { 4, 5, 6, 7, 1 }, { 2, 3, 4, 5, 6 },
				{ 7, 0, 0, 0, 0 } };

		int result = 0;
		while (result == 0) {
			int i = rand5();
			int j = rand5();
			result = vals[i - 1][j - 1];
		}
		return result;
	}

	// return random integer between [1, 5]
	private int rand5() {
		Random random = new Random();
		return random.nextInt(5) + 1;
	}
}
