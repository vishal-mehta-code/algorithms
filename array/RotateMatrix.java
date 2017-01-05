package array;

public class RotateMatrix {

	private static int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

	public static void main(String[] args) {
		 rotateMatrixClockWise();
		 rotateMatrixByNinetyDegree();
	}

	private static void rotateMatrixByNinetyDegree() {
		int n = array.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int tmp = array[i][j];
				array[i][j] = array[j][n - i - 1];
				array[j][n - i - 1] = array[n - i - 1][n - j - 1];
				array[n - i - 1][n - j - 1] = array[n - j - 1][i];
				array[n - j - 1][i] = tmp;
			}
		}
		printMatrix(array);
	}

	private static void printMatrix(int[][] array) {
		int rows = array.length;
		int cols = array[0].length;
		StringBuilder stringBuilder = new StringBuilder();
		for (int i  = 0 ; i < rows ; i++){
			for (int j = 0 ; j < cols ; j ++){
				stringBuilder.append(array[i][j]).append(" ");
			}
			stringBuilder.append("\r\n");
		}
		System.out.println(stringBuilder.toString());
	}

	private static void rotateMatrixClockWise() {
		int startX = 0;
		int startY = 0;
		int endX = array.length - 1;
		int endY = array[0].length - 1;
		
		int prev = 0;
		int curr = 0;

		while (startX < endX && startY < endY) {

			prev = array[startX + 1][startY];

			for (int i = startY; i <= endY; i++) {
				curr = array[startX][i];
				array[startX][i] = prev;
				prev = curr;
			}
			startX++;

			for (int i = startX; i <= endX; i++) {
				curr = array[i][endY];
				array[i][endY] = prev;
				prev = curr;
			}
			endY--;

			for (int i = endY; i >= startY; i--) {
				curr = array[endX][i];
				array[endX][i] = prev;
				prev = curr;
			}
			endX--;

			for (int i = endX; i >= startX; i--) {
				curr = array[i][startY];
				array[i][startY] = prev;
				prev = curr;
			}
			startY++;
		}

		printMatrix(array);
	}
}
