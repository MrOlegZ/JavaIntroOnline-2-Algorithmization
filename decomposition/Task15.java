package by.jonline.pr02.decomposition;

import java.util.Scanner;

/* Найти все натуральные n-значные числа, цифры в которых образуют строго
 * возрастающую последовательность (например, 1234, 5678). Для решения
 * Задачи использовать декомпозицию
 */

public class Task15 {

	public static void main(String[] args) {

		int n;

		n = intFromScanner("Введите количество цифр n натурального числа", "Positive");

		System.out.printf("Все натуральные %d-значные числа, цифры которых образуют возрастающую последовательность:\n",
				n);
		for (int i = (int) Math.pow(10, n - 1); i < Math.pow(10, n); i++) {
			if (isNumberIncreaseSequence(i)) {
				System.out.printf("%d;\t", i);
			}
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

	public static boolean isNumberIncreaseSequence(int number) {

		int n = countNumberOfDigits(number);
		// Количество цифр в числе. Т.к. изначально задается, то можно передавать в
		// метод, а не рассчитывать

		boolean result = false;
		int[] numberArray = numberToArray(number, n);

		int i = 0;
		while (i < n - 1) {
			if (numberArray[i] < numberArray[i + 1]) {
				result = true;
			} else {
				return false;
			}
			i++;
		}
		return result;
	}

	public static int countNumberOfDigits(int number) {

		int count = 0;
		while (number > 0) {
			count++;
			number /= 10;
		}
		return count;
	}

	public static int[] numberToArray(int number, int n) {
		int[] mas = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			mas[i] = number % 10;
			number /= 10;
		}
		return mas;
	}
}