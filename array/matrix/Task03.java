package by.jonline.pr02.array.matrix;

import java.util.Random;
import java.util.Scanner;

// Дана матрица. Вывести на экран k-ую строку и p-ый столбец матрицы

public class Task03 {

	public static void main(String[] args) {

		int n; // Размер матрицы
		int range; // Диапазон значений
		int k; // Номер необходимой строки
		int p; // Номер необходимого столбца

		n = intFromScanner("Введите размер матрицы (целое неотрицательное число)", true);
		range = intFromScanner("Введите диапазон значений (целое)", false);

		int[][] mas = new int[n][n];

		genMatrixInt(mas, range);
		printMatrixElement(mas, "", n);

		k = inputAndCheck(n, "Введите номер строки матрицы");
		printMatrixElement(mas, "line", k);

		p = inputAndCheck(n, "Введите номер столбца матрицы");
		printMatrixElement(mas, "column", p);
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
				System.out.print("Вы ввели неверный номер. " + message + " >> ");
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

	public static void printMatrixElement(int[][] mas, String typeOfElement, int n) {
		if (mas == null) {
			return;
		}

		switch (typeOfElement) {

		case "line":
			System.out.println(n + "-ая строка:");
			for (int i = 0; i < mas.length; i++) {
				System.out.print(mas[n - 1][i] + ";\t");
			}
			System.out.println();
			break;
		case "column":
			System.out.println(n + "-ый столбец:");
			for (int i = 0; i < mas.length; i++) {
				System.out.print(mas[i][n - 1] + ";\t");
			}
			System.out.println();
			break;
		default:
			System.out.println("Матрица:");
			for (int i = 0; i < mas.length; i++) {
				for (int j = 0; j < mas[i].length; j++) {
					System.out.print(mas[i][j] + ";\t");
				}
				System.out.println();
			}
		}
	}

	public static int inputAndCheck(int n, String message) {

		int k;

		do {
			k = intFromScanner(message, true);
			if (k > n) {
				System.out.println("Вы ввели неверный номер, введите целое число в диапазоне от 1 до " + n);
			}

		} while ((k > n) || (k < 1));

		return k;

	}

}
