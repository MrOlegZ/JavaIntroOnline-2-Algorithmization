package by.jonline.pr02.array.matrix;

import java.util.Random;
import java.util.Scanner;

/* Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце.
 * Определить, какой столбец содержит максимальную сумму
 */

public class Task09 {

	public static void main(String[] args) {

		int m; // Количество строк матрицы
		int n; // Количество столбцов матрицы
		int range; // Диапазон значений матрицы
		int num; // Номер столбца с максимальным значением суммы

		m = intFromScanner("Введите количество строк матрицы", "Positive");
		n = intFromScanner("Введите количество столбцов матрицы", "Positive");
		range = intFromScanner("Введите диапазон значений матрицы", "Positive");

		int[][] mas = new int[m][n]; // Исходная матрица
		int[] sumArray = new int[n]; // Массив, содержащий суммы столбцов

		genMatrixIntPositive(mas, range);

		printMatrixInt(mas, "Исходная матрица:");

		sumColumnMatrix(mas, sumArray);

		printArray(sumArray, "Суммы столбцов:");

		num = columnMaxSum(sumArray);

		System.out.printf("Столбец %d (%d с точки зрения исчисления матрицы) имеет максимальную сумму элементов",
				num + 1, num);
	}

	public static int intFromScanner(String message, String numberSign) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		int res;
		boolean decide;

		System.out.print(message + " >> ");

		do {
			decide = false;
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.print("Введено не целое число. ");
				System.out.print(message + " >> ");
			}

			res = sc.nextInt();

			if (res == 0) {
				decide = true;
				System.out.print("Введен нуль. ");
				System.out.print(message + " >> ");
			} else {

				switch (numberSign) {
				case "Positive":
					if (res < 0) {
						decide = true;
						System.out.print("Введено отрицательное число. ");
						System.out.print(message + " >> ");
					}
					break;

				case "Negative":
					if (res > 0) {
						decide = true;
						System.out.print("Введено положительное число. ");
						System.out.print(message + " >> ");
					}
					break;

				default:
					decide = false;
				}
			}

		} while (decide);

		return res;
	}

	public static void genMatrixIntPositive(int[][] mas, int range) {
		if (mas == null) {
			return;
		}

		Random rand = new Random();

		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				mas[i][j] = rand.nextInt(Math.abs(range + 1));
			}
		}
	}

	public static void sumColumnMatrix(int[][] mas, int[] sumArray) {
		if ((mas == null) || (sumArray == null)) {
			return;
		}

		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				sumArray[j] += mas[i][j];
			}
		}
	}

	public static void printMatrixInt(int[][] mas, String message) {
		if (mas == null) {
			return;
		}
		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				System.out.print(mas[i][j] + "; \t");
			}
			System.out.println();
		}
	}

	public static void printArray(int[] mas, String message) {
		if (mas == null) {
			return;
		}
		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + "; \t");
		}
		System.out.println();
	}

	public static int columnMaxSum(int[] mas) {
		if (mas == null) {
			return 0;
		}

		int res = 0;
		int max = mas[0];

		for (int i = 1; i < mas.length; i++) {
			if (mas[i] > max) {
				max = mas[i];
				res = i;
			}
		}

		return res;
	}
}