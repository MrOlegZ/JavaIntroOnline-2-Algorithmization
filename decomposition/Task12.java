package by.jonline.pr02.decomposition;

import java.util.Scanner;

/* Даны натуральные числа K и N. Написать метод (методы) формирования массива A, 
 * элементами которого являются числа, сумма цифр которых равна K и которые не больше N
 */

public class Task12 {

	public static void main(String[] args) {

		int k;
		int n;

		k = intFromScanner("Введите натуральное число k", "Positive");
		n = intFromScanner("Введите натуральное число n", "Positive");

		int[] mas = formArray(k, n);

		if (mas.length != 0) {
			printArrayInt(mas, "Сформированный массив");
		} else {
			System.out.println("Невозможно сформировать массив по входным данным");
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

	public static int sumDigitInNumber(int number) {
		// Возвращает сумма цифр числа
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

	public static int[] formArray(int k, int n) {

		int[] tempMas = new int[n + 1];
		// Временный массив. Т.к. максимальное число n, то
		// гипотетически, максимальная длина массива n + 1
		int j = -1; // Счетчик позиций формируемого массива
		for (int i = 0; i < n; i++) {
			int temp = sumDigitInNumber(i);
			if (temp == k && i <= n) {
				j++;
				tempMas[j] = i;
			}
		}
		int[] resultMas = new int[j + 1];
		for (int i = 0; i < resultMas.length; i++) {
			resultMas[i] = tempMas[i];
		}

		return resultMas;
	}

	public static void printArrayInt(int[] mas, String message) {
		if (mas == null) {
			return;
		}
		System.out.println(message);
		for (int i : mas) {
			System.out.printf("%d;\t", i);
		}
	}
}