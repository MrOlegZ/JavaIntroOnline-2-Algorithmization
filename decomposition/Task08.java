package by.jonline.pr02.decomposition;

import java.util.Random;
import java.util.Scanner;

/* Задан массив D. Определить следующие суммы: D[1] + D[2] + D[3];
 * D[3] + D[4] + D[5]; D[4] + D[5] + D[6]. Пояснение. Составить метод (методы)
 * для вычисления суммы трех последовательно расположенных элементов массива
 * с номерами от k до m.
 */

public class Task08 {

	public static void main(String[] args) {

		int n;
		int range;

		n = intFromScanner("Введите размерность массива", "Positive");
		range = intFromScanner("Введите диапазон значений массива", "Positive");

		int[] D = new int[n];
		generateIntArray(D, range);
		printIntArray(D, "Исходный массив");

		int k;
		k = intFromScanner("Введите номер первого элемента, от которого складывать", "");

		int sum = summOfThree(D, k);
		if (sum != Integer.MIN_VALUE) {
			System.out.printf("Сумма трех последовательно расположенных элементов, начиная с %d, равна %d", k, sum);
		} else {
			System.out.printf(
					"Нельзя вычислить сумму трех последовательно расположенных элементов, начиная с %d, т.к. некоторых элементов не существует",
					k);
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

	public static void generateIntArray(int[] mas, int range) {
		if (mas == null) {
			return;
		}

		Random rand = new Random();

		for (int i = 0; i < mas.length; i++) {
			mas[i] = rand.nextInt(2 * Math.abs(range) + 1) - Math.abs(range);
		}
	}

	public static void printIntArray(int[] mas, String message) {
		if (mas == null) {
			return;
		}

		System.out.println(message);

		for (int i : mas) {
			System.out.printf("%d;\t", i);
		}

		System.out.println();
	}

	public static int summOfThree(int[] mas, int k) {
		if ((mas == null) || (k > mas.length - 3)) {
			return Integer.MIN_VALUE;
		}

		int sum = 0;
		for (int i = k; i < k + 3; i++) {
			sum += mas[i];
		}

		return sum;
	}
}
