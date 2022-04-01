package by.jonline.pr02.array.matrix;

import java.util.Random;
import java.util.Scanner;

/* Сформировать случайную матрицу m x n, состоящую из 0 и 1, причем в каждом
 * столбце число единиц равно номеру столбца
 */

public class Task14 {

	public static void main(String[] args) {

		int m; // Количество строк матрицы
		int n; // Количество столбцов матрицы

		m = intFromScanner("Введите количество строк матрицы", "Positive");
		n = intFromScanner("Введите количество столбцов матрицы", "Positive");

		int[][] mas = new int[m][n];

		if (n > mas.length + 1) {
			System.out.print("При таком числе строк и столбцов невозможно сформировать"
					+ " матрицу, состоящую из 0 и 1, причем в каждом столбце число единиц "
					+ "было бы равно номеру столбца");
		} else {
			genMatrixNullOne(mas);
			printMatrixInt(mas, "Сформированный массив");
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

	public static void genMatrixNullOne(int[][] mas) {
		if (mas == null) {
			return;
		}

		Random rand = new Random();
		int numCell = 0;
		int sum = 0;

		for (int i = 1; i < mas[0].length; i++) { // В i = 0 столбце все значения 0, нет смысла его заполнять
			do {
				numCell = rand.nextInt(mas.length); // Выбираем номер ячейки случайным образом
				if (mas[numCell][i] == 0) {
					mas[numCell][i] = 1; // Заполняем выбранную ячейку 1, если она "пустая"
					sum++;
				} else {
					sum += 0;
				}
			} while (sum < i);
			sum = 0;
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
