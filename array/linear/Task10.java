package by.jonline.pr02.array.linear;

import java.util.Random;
import java.util.Scanner;

/* Дан целочисленный массив с количеством элементов n.
 * Сжать массив, выбросив из него каждый второй элемент (освободившиеся элементы заполнить нулями).
 * Примечание. Дополнительный массив не использовать
 */

public class Task10 {

	public static void main(String[] args) {

		int n; // Размерность массива
		int range; // Диапазон значений

		n = intFromScanner("Введите размерность массива (целое неотрицательное)", true);
		range = intFromScanner("Введите диапазон значений (целое)", false);

		int[] mas = new int[n];

		genArrayInt(mas, range);

		printArrayInt(mas, "Исходный массив: ");

		arrayCompression(mas);

		printArrayInt(mas, "Итоговый массив: ");

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

	public static void arrayCompression(int[] mas) {
		if (mas == null) {
			return;
		}

		for (int i = 1; i < mas.length; i++) {
			if (i <= mas.length / 2) {
				mas[i] = mas[i * 2];
			} else {
				mas[i] = 0;
			}
		}
	}
}
