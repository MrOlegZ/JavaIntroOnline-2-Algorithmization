package by.jonline.pr02.array.matrix;

import java.util.Random;
import java.util.Scanner;

/* В числовой матрице поменять два любых столбца местами, т.е. все элементы одного
 * столбца поставить на соответствующие им позиции другого столбца, а элементы второго
 * переместить на соответствующие им позиции первого. Номера столбцов пользователь вводит
 * с клавиатуры
 */

public class Task08 {

	public static void main(String[] args) {

		int m; // Количество строк матрицы
		int n; // Количество столбцов матрицы
		int range; // Диапазон значений матрицы
		int column1; // Номер первого столбца
		int column2; // Номер второго столбца

		m = intFromScanner("Введите количество строк матрицы (целое положительное число)", "Positive");
		n = intFromScanner("Введите количество столбцов матрицы (целое положительное число)", "Positive");
		range = intFromScanner("Введите диапазон значений матрицы (по модулю)", "Positive");

		int mas[][] = new int[m][n];

		genMatrixInt(mas, range);

		printMatrixInt(mas, "Исходная матрица");

		column1 = intFromRange("Введите номер первого столбца", "Positive", 1, n);
		column2 = intFromRange("Введите номер второго столбца", "Positive", 1, n);

		swapMatrixColumn(mas, column1, column2);

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

	public static int intFromRange(String message, String numberSign, int limitLow, int limitHigh) {

		int res;
		boolean decide = false;

		do {
			res = intFromScanner(message, numberSign);
			if ((res > limitHigh) || (res < limitLow)) {
				decide = true;
				System.out.printf("Введите число из диапазона [%d, %d]: ", limitLow, limitHigh);
			} else {
				decide = false;
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
		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				System.out.print(mas[i][j] + "; \t");
			}
			System.out.println();
		}
	}

	public static void swapMatrixColumn(int[][] mas, int numColumn1, int numColumn2) {
		if (mas == null) {
			return;
		}

		int temp;

		if (numColumn1 != numColumn2) {
			for (int i = 0; i < mas.length; i++) {
				temp = mas[i][numColumn1 - 1];
				mas[i][numColumn1 - 1] = mas[i][numColumn2 - 1];
				mas[i][numColumn2 - 1] = temp;
			}
		} else {
			System.out.println("Введены одинаковые номера столбцов");
		}
	}

}
