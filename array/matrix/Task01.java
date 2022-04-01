package by.jonline.pr02.array.matrix;

import java.util.Random;
import java.util.Scanner;

/* Дана матрица. Вывести на экран все нечетные столбцы,
 * у которых первый элемент больше последнего.
 */

public class Task01 {

	public static void main(String[] args) {

		int n; // Размер матрицы
		int range; // Диапазон значений

		n = intFromScanner("Введите размер матрицы (целое неотрицательное число)", true);
		range = intFromScanner("Введите диапазон значений (целое)", false);

		int[][] mas = new int[n][n];

		genMatrixInt(mas, range);
		printMatrix(mas, "Исходная матрица:");

		printColumn(mas, "Итоговые столбцы:");
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

	public static void genMatrixInt(int[][] mas, int range) {
		if (mas == null) {
			return;
		}
		Random rand = new Random();

		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				mas[i][j] = rand.nextInt(2 * Math.abs(range) + 1) - range;
			}
		}
	}

	public static void printMatrix(int[][] mas, String message) {
		if (mas == null) {
			return;
		}

		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				System.out.print(mas[i][j] + ";\t");
			}
			System.out.println();
		}

		System.out.println();
	}

	public static void printColumn(int[][] mas, String message) {
		if (mas == null) {
			return;
		}
		boolean decide = false;

		System.out.println(message);

		for (int j = 0; j < mas[0].length; j++) {
			if ((j % 2 == 0) && (mas[0][j] > mas[mas.length - 1][j])) {
				for (int i = 0; i < mas.length; i++) {
					System.out.println(mas[i][j]);
					decide = true;
				}
			}
		}
		if (!decide) {
			System.out.println("отсутствуют");
		}
	}
}
