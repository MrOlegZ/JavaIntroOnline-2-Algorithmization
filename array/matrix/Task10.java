package by.jonline.pr02.array.matrix;

import java.util.Random;
import java.util.Scanner;

// Найти положительные элементы главной диагонали квадратной матрицы

public class Task10 {

	public static void main(String[] args) {

		int n; // Размерность квадратной матрицы
		int range; // Диапазон значений

		n = intFromScanner("Введите размер квадратной матрицы", "Positive");
		range = intFromScanner("Введите диапазон значений матрицы", "Positive");

		int[][] mas = new int[n][n];

		genMatrixInt(mas, range);

		printMatrixInt(mas, "Сформированная квадратная матрица:");

		System.out.println("Положительные элементы главной диагонали:");
		for (int i = 0; i < mas.length; i++) {
			if (mas[i][i] > 0) {
				System.out.print(mas[i][i] + "; \t");
			}
		}

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

}
