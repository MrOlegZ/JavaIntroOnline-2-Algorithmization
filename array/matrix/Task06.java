package by.jonline.pr02.array.matrix;

import java.util.Scanner;

/* Сформировать квадратную матрицу порядка n (n - четное) по образцу
 *	1	1	1	.	1	1	1
 *	0	1	1	.	1	1	0
 *	0	0	1	.	1	0	0
 *	.	.	.	.	.	.	.
 *	0	0	1	.	1	0	0
 *	0	1	1	.	1	1	0
 *	1	1	1	.	1	1	1
 */

public class Task06 {

	public static void main(String[] args) {

		int n; // Порядок матрицы

		n = intEvenPositiveFromScanner("Введите целое четное положительное число: ");

		int[][] mas = new int[n][n];

		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas.length; j++) {
				if (i < mas.length / 2) {
					if ((j >= i) && (j < mas.length - i)) {
						mas[i][j] = 1;
					}
				} else {
					if ((j <= i) && (j >= (mas.length - 1) - i)) {
						mas[i][j] = 1;
					}
				}
			}
		}

		printMatrix(mas, "Итоговая матрица:");
	}

	public static int intEvenPositiveFromScanner(String message) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		int res;
		boolean decide = false;

		do {

			System.out.print(message + " >> ");

			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.print(message + " >> ");
			}

			res = sc.nextInt();
			decide = ((res > 0) & (res % 2 == 0)) ? false : true;

		} while (decide);

		return res;
	}

	public static void printMatrix(int[][] mas, String message) {
		if (mas == null) {
			return;
		}

		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas.length; j++) {
				System.out.print(mas[i][j] + "; \t");
			}
			System.out.println();
		}
	}

}
