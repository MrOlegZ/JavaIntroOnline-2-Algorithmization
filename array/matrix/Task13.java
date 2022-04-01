package by.jonline.pr02.array.matrix;

import java.util.Random;
import java.util.Scanner;

// Отсортировать столбцы матрицы по возрастанию и убыванию элементов

public class Task13 {

	public static void main(String[] args) {

		int m; // Количество строк матрицы
		int n; // Количество столбцов матрицы
		int range; // Диапазон значений элементов матрицы

		m = intFromScanner("Введите количество строк матрицы", "Positive");
		n = intFromScanner("Введите количество столбцов матрицы", "Positive");
		range = intFromScanner("Диапазон значений элементов матрицы", "Positive");

		int[][] mas = new int[m][n];

		genMatrixInt(mas, range);
		printMatrixInt(mas, "Исходная матрица");

		for (int i = 0; i < n; i++) {
			sortColumn(mas, i, "Increase");
		}

		printMatrixInt(mas, "Матрица с отсортированными столбцами по возрастанию");

		for (int i = 0; i < n; i++) {
			sortColumn(mas, i, "Decrease");
		}

		printMatrixInt(mas, "Матрица с отсортированными столбцами по убыванию");
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

	public static void sortColumn(int[][] mas, int numColumn, String sorting) {
		if (mas == null) {
			return;
		}

		// Реализована пузырьковая сортировка

		int temp;
		int n = mas.length;

		switch (sorting) {
		default:
		case "Increase":
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < n - i; j++) {
					if (mas[j][numColumn] > mas[j + 1][numColumn]) {
						temp = mas[j + 1][numColumn];
						mas[j + 1][numColumn] = mas[j][numColumn];
						mas[j][numColumn] = temp;
					}
				}
			}
			break;

		case "Decrease":
			for (int i = n; i > 1; i--) {
				for (int j = n - 1; j > 0; j--) {
					if (mas[j][numColumn] > mas[j - 1][numColumn]) {
						temp = mas[j - 1][numColumn];
						mas[j - 1][numColumn] = mas[j][numColumn];
						mas[j][numColumn] = temp;
					}
				}
			}
			break;
		}

	}
}
