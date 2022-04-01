package by.jonline.pr02.array.matrix;

import java.util.Scanner;

/* Сформировать квадратную матрицу порядка N по правилу A[i,j] = sin((i^2 - j^2) / N)
 * и подсчитать количество положительных элементов в ней
 */

public class Task07 {

	public static void main(String[] args) {

		int n; // Порядок матрицы
		int num = 0; // Количество положительных элементов

		n = intFromScanner("Введите порядок матрицы n (целое неотрицательное число)", true);

		double[][] mas = new double[n][n];

		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas.length; j++) {
				mas[i][j] = Math.sin((i * i - j * j) / n);
				num += (mas[i][j] > 0) ? 1 : 0;
			}
		}

		printMatrixDouble(mas, "Сформированная матрица");

		System.out.printf("Количество положительных элементов: %d", num);
	}

	public static int intFromScanner(String message, boolean mark) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// mark - метка положительного целого ненулевого числа

		int res;
		boolean decide = false;

		do {

			System.out.print(message + " >> ");

			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.print(message + " >> ");
			}

			res = sc.nextInt();
			decide = ((mark) && (res <= 0)) ? true : false;

		} while (decide);

		return res;
	}

	public static void printMatrixDouble(double[][] mas, String message) {
		if (mas == null) {
			return;
		}

		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas.length; j++) {
				System.out.printf("%.3f; ", mas[i][j]);
			}
			System.out.println();
		}
	}

}
