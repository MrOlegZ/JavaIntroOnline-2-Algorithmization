package by.jonline.pr02.array.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/* Даны 2 последовательности a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bm.
 * Образовать из них новую последовательность чисел так, чтобы она тоже была неубывающей.
 * Примечание. Дополнительный массив не использовать
 */

public class Task02 {

	public static void main(String[] args) {

		int n; // Размер первой последовательности
		int m; // Размер второй последовательности
		int range; // Диапазон значений

		n = intFromScanner("Введите размер первой последовательности", "Positive");
		m = intFromScanner("Введите размер второй последовательности", "Positive");
		range = intFromScanner("Введите диапазон значений", "");

		int[] sequenceA = new int[n];
		int[] sequenceB = new int[m];

		genArrayInt(sequenceA, range);
		Arrays.sort(sequenceA);
		printArrayInt(sequenceA, "Первая последовательность");

		genArrayInt(sequenceB, range);
		Arrays.sort(sequenceB);
		printArrayInt(sequenceB, "Вторая последовательность");

		sequenceA = Arrays.copyOf(sequenceA, n + m);
		for (int i = n; i < sequenceA.length; i++) {
			sequenceA[i] = sequenceB[i - n];
		}

		Arrays.sort(sequenceA);
		printArrayInt(sequenceA, "Итоговая неубывающая последовательность");
	}

	public static int intFromScanner(String message, String numberSign) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		int res;
		boolean decide; // Число удовлетворяет условиям

		System.out.print(message + " >> ");

		do {
			decide = false;
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.print("Введено не целое число. ");
				System.out.print(message + " >> ");
			}

			res = sc.nextInt();

			switch (numberSign) {
			case "Positive":
				if (res > 0) {
					decide = true;
				} else if (res == 0) {
					decide = false;
					System.out.print("Введен нуль. ");
					System.out.print(message + " >> ");
				} else {
					decide = false;
					System.out.print("Введено отрицательное число. ");
					System.out.print(message + " >> ");
				}
				break;

			case "Negative":
				if (res < 0) {
					decide = true;
				} else if (res == 0) {
					decide = false;
					System.out.print("Введен нуль. ");
					System.out.print(message + " >> ");
				} else {
					decide = false;
					System.out.print("Введено положительное число. ");
					System.out.print(message + " >> ");
				}
				break;

			default:
				decide = true;
			}

		} while (!decide);

		return res;
	}

	public static void genArrayInt(int[] mas, int range) {
		if (mas == null) {
			return;
		}

		Random rand = new Random();

		for (int i = 0; i < mas.length; i++) {
			mas[i] = rand.nextInt(2 * Math.abs(range) + 1) - Math.abs(range);
		}
	}

	public static void printArrayInt(int[] mas, String message) {
		if (mas == null) {
			return;
		}

		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + ";\t");
		}

		System.out.println();
	}
}
