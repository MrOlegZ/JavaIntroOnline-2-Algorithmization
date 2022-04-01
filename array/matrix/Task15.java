package by.jonline.pr02.array.matrix;

import java.util.Random;
import java.util.Scanner;

/* Найдите наибольший элемент матрицы, а потом заменить все нечетные
 * элементы на него
 */

public class Task15 {

	public static void main(String[] args) {

		int m; // Количество строк матрицы
		int n; // Количество столбцов матрицы
		int range; // Диапазон значений матрицы
		int max;

		m = intFromScanner("Введите количество строк матрицы", "Positive");
		n = intFromScanner("Введите количество столбцов матрицы", "Positive");
		range = intFromScanner("Диапазон значений матрицы (по модулю)", "Positive");

		int[][] mas = new int[m][n];

		genMatrixInt(mas, range);
		printMatrixInt(mas, "Исходная матрица:");

		max = matrixMaxElement(mas);
		System.out.println("Наибольший элемент матрицы равен " + max);

		changeOddElement(mas, max);
		printMatrixInt(mas, "Итоговая матрица:");

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

	public static int matrixMaxElement(int[][] mas) {
		if (mas == null) {
			return 0;
		}

		int max = mas[0][0];

		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				max = (mas[i][j] > max) ? mas[i][j] : max;
			}
		}

		return max;
	}

	public static void changeOddElement(int[][] mas, int max) {
		if (mas == null) {
			return;
		}

		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				mas[i][j] = (mas[i][j] % 2 != 0) ? max : mas[i][j];
			}
		}
	}

}
