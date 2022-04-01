package by.jonline.pr02.array.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/* Заданы два одномерных массива с различным количеством элементов и натуральное число k.
 * Объединить их в один массив, включив второй массив между k-м и (k + 1)-м элементами
 * первого, при этом, не используя дополнительный массив
 */

public class Task01 {

	public static void main(String[] args) {

		int m; // Размер первого массива
		int n; // Размер второго массива
		int k; // Натуральное число
		int range; // Диапазон значений

		m = intFromScanner("Введите размер первого массива", "Positive");
		n = intFromScanner("Введите размер второго массива", "Positive");
		range = intFromScanner("Введите диапазон значений", "");
		k = intFromScanner("Введите натуральное число k", "");

		int[] mas1 = new int[m];
		int[] mas2 = new int[n];

		genArrayInt(mas1, range);
		genArrayInt(mas2, range);

		printArrayInt(mas1, "Первый массив");
		printArrayInt(mas2, "Второй массив");

		if (k >= 0 && k < mas1.length) {
			mas1 = Arrays.copyOf(mas1, m + n); // Расширяем 1 массив на величину второго

			for (int i = mas1.length - 1; i > k; i--) {
				if (i > k + mas2.length) {
					mas1[i] = mas1[i - mas2.length]; // Переносим значения 1 массива с (k+1)-ого элемента в конец
				} else {
					mas1[i] = mas2[i - k - 1]; // Вставляем значения массива 2
				}
			}

			printArrayInt(mas1, "Объединенный массив");
		} else {
			System.out.printf("Введенное натуральное число %d выходит за границы первого массива.\n", k);
			System.out.print("Объединение не возможно");
		}
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
