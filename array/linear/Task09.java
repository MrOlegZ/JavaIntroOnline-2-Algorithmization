package by.jonline.pr02.array.linear;

import java.util.Random;
import java.util.Scanner;

/* В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число.
 * Если таких чисел несколько, то определить наименьшее из них.
 */

public class Task09 {

	public static void main(String[] args) {

		int n; // Размерность массива
		int range; // Диапазон значений

		n = intFromScanner("Введите размерность массива (целое неотрицательное)", true);
		range = intFromScanner("Введите диапазон значений (± целое)", false);

		int[] mas = new int[n];
		genArrayInt(mas, range);

		printArrayInt(mas, "Исходный сформированный массив:");

		System.out.printf("Наиболее часто встречающееся число (или минимальное из нескольких) %d",
				mostFrequentNumber(mas));

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
		if (mas == null) {
			return;
		}
		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + "; ");
		}

		System.out.println();
	}

	public static int mostFrequentNumber(int[] mas) {
		if (mas == null) {
			return 0;
		}

		int maxCount = countFrequent(mas, mas[0]);
		int mostFrequentNumber = mas[0];

		for (int i = 1; i < mas.length; i++) {
			if (countFrequent(mas, mas[i]) > maxCount) {
				mostFrequentNumber = mas[i];
				maxCount = countFrequent(mas, mas[i]);
			}
			if (countFrequent(mas, mas[i]) == maxCount) {
				maxCount = countFrequent(mas, mas[i]);
				if (mas[i] <= mostFrequentNumber) {
					mostFrequentNumber = mas[i];
				}
			}
		}

		return mostFrequentNumber;
	}

	public static int countFrequent(int[] mas, int number) {
		if (mas == null) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < mas.length; i++) {
			if (mas[i] == number) {
				count++;
			}
		}
		return count;
	}
}
