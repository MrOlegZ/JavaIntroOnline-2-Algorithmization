package by.jonline.pr02.array.matrix;

import java.util.Random;
import java.util.Scanner;

// Отсортировать строки матрицы по возрастанию и убыванию элементов

public class Task12 {

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

		for (int i = 0; i < mas.length; i++) {
			sortLine(mas[i], "Increase");
		}
		printMatrixInt(mas, "Матрица с отсортированными строками по возрастанию");

		for (int i = 0; i < mas.length; i++) {
			sortLine(mas[i], "Decrease");
		}
		printMatrixInt(mas, "Матрица с отсортированными строками по убыванию");

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

	public static void sortLine(int[] array, String sorting) {
		if (array == null) {
			return;
		}

		// Реализована пузырьковая сортировка

		int temp;
		int n = array.length;

		switch (sorting) {
		case "Increase":
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < n - i; j++) {
					if (array[j] > array[j + 1]) {
						temp = array[j + 1];
						array[j + 1] = array[j];
						array[j] = temp;
					}
				}
			}
			break;

		case "Decrease":
			for (int i = n; i > 1; i--) {
				for (int j = n - 1; j > 0; j--) {
					if (array[j] > array[j - 1]) {
						temp = array[j - 1];
						array[j - 1] = array[j];
						array[j] = temp;
					}
				}
			}
			break;
		}

	}
}
