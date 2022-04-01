package by.jonline.pr02.decomposition;

import java.util.Scanner;

/* Написать программу, определяющую сумму n-значных чисел, содержащих только нечетные цифры.
 * Определить также, сколько четных цифр в найденной сумме. Для решения
 * задачи использовать декомпозицию.
 */
public class Task16 {

	public static void main(String[] args) {

		int n;
		n = intFromScanner("Введите количество цифр в числе", "Positive");
		long sumOnlyOdd = 0;
		sumOnlyOdd = sumNumberWithOnlyOddDigit(n);
		if (sumOnlyOdd != -1) {
			System.out.printf("Сумма %d-значных чисел, содержащих только нечетные цифры равна %d\n", n, sumOnlyOdd);
			System.out.printf("Количество четных цифр в сумме равно %d", numberEvenDigit(sumOnlyOdd));
		} else {
			System.out.println("Числа в данном диапазоне превышают диапазон значений типа long");
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

	public static boolean isOnlyOddDigit(long number) {
		// Метод проверяет, являются ли все цифры числа нечетными
		long reminder;

		while (number > 0) {
			reminder = number % 10;
			if (reminder % 2 == 0) {
				return false;
			}
			number /= 10;
		}
		return true; // Все цифры числа четные, т.к. в противном случае будет выход из цикла
	}

	public static long sumNumberWithOnlyOddDigit(int numberOfDigit) {
		// Метод суммирует все numberOfDigit - значные числа, содержащие только нечетные
		// цифры, возвращает -1, если имеется переполнение long
		long sumOnlyOdd = 0L;
		long maxValue = 0L;
		long i = 0L;
		if (Math.pow(10, numberOfDigit) < Long.MAX_VALUE) {
			maxValue = (long) Math.pow(10, numberOfDigit);
			i = (long) Math.pow(10, numberOfDigit - 1);
			while (i < maxValue) {
				if (isOnlyOddDigit(i) && (sumOnlyOdd <= Long.MAX_VALUE - i)) {
					sumOnlyOdd += i;
				} else if ((isOnlyOddDigit(i) && (sumOnlyOdd > Long.MAX_VALUE - i))) {
					return -1;
				}
				i++;
			}
		} else {
			return -1;
		}
		return sumOnlyOdd;
	}

	public static int numberEvenDigit(long number) {
		// Метод считает количество четных цифр в числе
		long reminder;
		int sum = 0;
		while (number > 0) {
			reminder = number % 10;
			sum += (reminder % 2 == 0 && reminder != 0) ? 1 : 0;
			number /= 10;
		}
		return sum;
	}
}
