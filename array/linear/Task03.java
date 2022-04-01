package by.jonline.pr02.array.linear;

import java.util.Random;
import java.util.Scanner;

/* Дан массив действительных чисел, размерность которого N.
 * Подсчитать, сколько в нем отрицательных, положительных и нулевых элементов.
 */

public class Task03 {

	public static void main(String[] args) {

		int n; // Размерность массива
		int range; // Диапазон значений массива

		n = intFromScanner("Введите размерность массива", true);

		double[] mas = new double[n];

		range = intFromScanner("Введите диапазон значений массива (± целое)", true);

		genArrayDouble(mas, range);

		printArray("Исходный массив", mas, "%.03f; ");

		System.out.println("Количество положительных элементов: " + countElementOfArray(mas, "P"));
		System.out.println("Количество отрицательных элементов: " + countElementOfArray(mas, "N"));
		System.out.println("Количество нулевых элементов: " + countElementOfArray(mas, "Z"));

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

	public static void genArrayDouble(double[] mas, int range) {
		if (mas == null) {
			return;
		}

		Random rand = new Random();

		for (int i = 0; i < mas.length; i++) {
			mas[i] = range * (rand.nextDouble() * 2d - 1d);
		}
	}

	public static void printArray(String message, double[] mas, String format) {
		if (mas == null) {
			return;
		}

		System.out.println(message);
		for (int i = 0; i < mas.length; i++) {
			System.out.printf(format, mas[i]);
		}
		System.out.println();
	}

	public static int countElementOfArray(double[] mas, String mark) {
		if (mas == null) {
			return 0;
		}

		int res = 0;

		switch (mark) {
		case "Z":
			for (int i = 0; i < mas.length; i++) {
				res += (mas[i] == 0) ? 1 : 0;
			}
			break;

		case "P":
			for (int i = 0; i < mas.length; i++) {
				res += (mas[i] > 0) ? 1 : 0;
			}
			break;

		case "N":
			for (int i = 0; i < mas.length; i++) {
				res += (mas[i] < 0) ? 1 : 0;
			}
			break;

		}
		return res;

	}

}
