package by.jonline.pr02.array.linear;

import java.util.Random;
import java.util.Scanner;

/* Дана последовательность целых чисел a1, a2, ... , an.
 * Образовать новую последовательность, выбросив из исходной те члены, которые равны
 * min(a1, a2, ... , an)
 */

public class Task08 {

	public static void main(String[] args) {

		int n; // Размерность последовательности
		int range; // Диапазон значений

		n = intFromScanner("Введите размерность последовательности (целое положительное число)", true);
		int[] mas = new int[n];

		range = intFromScanner("Введите диапазон значений последовательности", false);
		genArrayInt(mas, range);

		printArrayInt(mas, "Исходная последовательность:");

		int[] masSmall = new int[n - minElementCount(mas, minElement(mas))];
		copyArrayWithoutMin(mas, masSmall, minElement(mas));

		printArrayInt(masSmall, "Итоговая последовательность:");

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

	public static int minElement(int[] mas) {
		if (mas == null) {
			return 0;
		}

		int min = mas[0];
		for (int i = 1; i < mas.length; i++) {
			if (mas[i] <= min) {
				min = mas[i];
			}
		}
		return min;
	}

	public static int minElementCount(int[] mas, int min) {
		if (mas == null) {
			return 0;
		}

		int count = 0;
		for (int i = 0; i < mas.length; i++) {
			if (mas[i] == min) {
				count++;
			}
		}
		return count;
	}

	public static void copyArrayWithoutMin(int[] initialMas, int[] resultMas, int min) {

		if ((initialMas == null) || (resultMas == null)) {
			return;
		}
		int temp = 0;
		for (int i = 0; i < initialMas.length; i++) {
			if (initialMas[i] != min) {
				resultMas[temp] = initialMas[i];
				temp++;
			}
		}
	}
}
