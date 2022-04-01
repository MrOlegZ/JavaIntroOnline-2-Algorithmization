package by.jonline.pr02.decomposition;

import java.util.Scanner;

/* Натуральное число, в записи которого n цифр, называется числом Армстронга, если
 * сумма его цифр, возведенных в степень n, равна самому числу. Найти все числа Армстронга
 * от 1 до k. Для решения задачи использовать декомпозицию.
 */

public class Task14 {

	public static void main(String[] args) {

		int k;
		k = intFromScanner("Введите натуральное число, до которого выводить числа Армстронга", "Positive");

		System.out.printf("Числа Армстронга в диапазоне от 1 до %d\n", k);

		for (int i = 1; i <= k; i++) {
			if (isArmstrongNumber(i)) {
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

	public static int countNumberOfDigits(int number) {

		int count = 0;
		while (number > 0) {
			count++;
			number /= 10;
		}
		return count;
	}

	public static boolean isArmstrongNumber(int number) {

		int n = countNumberOfDigits(number);
		int temp = number;
		int sum = 0;

		while (temp > 0) {
			sum += (int) Math.pow((temp % 10), n);
			temp /= 10;
		}
		if (sum == number) {
			return true;
		} else {
			return false;
		}
	}
}