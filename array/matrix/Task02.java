package by.jonline.pr02.array.matrix;

import java.util.Random;
import java.util.Scanner;

/* Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали
 */

public class Task02 {

	public static void main(String[] args) {

		int n; // Размер матрицы
		int range; // Диапазон значений

		n = intFromScanner("Введите размер матрицы (целое неотрицательное число)", true);
		range = intFromScanner("Введите диапазон значений (целое)", false);

		int[][] mas = new int[n][n];

		genMatrixInt(mas, range);
		printMatrix(mas, "Исходная матрица:");

		printDiagonal(mas, "Диагональные элементы:");

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

	public static void printDiagonal(int[][] mas, String message) {
		if (mas == null) {
			return;
		}
		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i][i] + ";\t");
		}

		System.out.println();
	}

}
