package by.jonline.pr02.array.linear;

import java.util.Random;
import java.util.Scanner;

/* Дана последовательность действительных чисел а1, а2, ..., аn и число Z.
 * Заменить все ее члены, большие данного Z, этим числом.
 * Подсчитать количество замен.
 */

public class Task02 {

	public static void main(String[] args) {

		int n;
		int range;
		double z;

		n = intFromScanner("Введите длину последовательности (натуральное число)", true);
		range = intFromScanner("Введите диапазон значений последовательности ±", false);

		double[] a = new double[n];

		genArrayDouble(a, range);
		printArray(a, "Исходная последовательность");

		z = doubleFromScanner("Введите действительное число Z");

		System.out.println("Количество замен " + changeArrayElement(a, z));
		printArray(a, "Итоговая последовательность");

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

	public static double doubleFromScanner(String message) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print(message + " >> ");

		while (!sc.hasNextDouble()) {
			sc.nextLine();
			System.out.print(message + " >> ");
		}
		return sc.nextDouble();
	}

	public static void genArrayDouble(double[] mas, int range) {
		if (mas == null) {
			return;
		}

		Random rand = new Random();

		for (int i = 0; i < mas.length; i++) {
			mas[i] = range * (rand.nextDouble() * 2d - 1d);
		}

	}

	public static int changeArrayElement(double[] mas, double z) {
		if (mas == null) {
			return 0;
		}

		int count = 0;

		for (int i = 0; i < mas.length; i++) {
			if (mas[i] > z) {
				mas[i] = z;
				count++;
			}
		}
		return count;
	}

	public static void printArray(double[] mas, String message) {
		if (mas == null) {
			return;
		}

		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			// System.out.print(mas[i] + "; ");
			System.out.printf("%.03f; ", mas[i]);
		}
		System.out.println();
	}

}
