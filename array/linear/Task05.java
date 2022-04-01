package by.jonline.pr02.array.linear;

import java.util.Random;
import java.util.Scanner;

/* Даны целые числа а1, а2, ..., аn.
 * Вывести на печать только те числа, для которых аi > i.
 */

public class Task05 {

	public static void main(String[] args) {

		int n; // Размерность последовательности
		int range; // Диапазон значений последовательности (± целое)

		n = intFromScanner("Введите размерность последовательности (целое неотрицательное)", true);

		int[] mas = new int[n];

		range = intFromScanner("Введите диапазон значений последовательности (± целое)", false);

		genArrayInt(mas, range);

		printArrayInt(mas, "Исходная последовательность");

		printArrayIntSort(mas, "Итоговая последовательность, для которой ai > i");

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

	public static void genArrayInt(int[] mas, int range) {
		if (mas == null) {
			return;
		}

		Random rand = new Random();

		for (int i = 0; i < mas.length; i++) {
			mas[i] = rand.nextInt(Math.abs(range)) * 2 - range;
		}
	}

	public static void printArrayInt(int[] mas, String message) {
		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + "; ");
		}

		System.out.println();
	}

	public static void printArrayIntSort(int[] mas, String message) {
		if (mas == null) {
			return;
		}
		boolean temp = false;

		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			if (mas[i] > i) {
				temp = true;
				System.out.print(mas[i] + "; ");
			}
		}

		if (!temp) {
			System.out.println("Не существует");
		} else {
			System.out.println();
		}
	}
}
