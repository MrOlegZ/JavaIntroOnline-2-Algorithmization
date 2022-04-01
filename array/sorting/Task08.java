package by.jonline.pr02.array.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/* Даны дроби p1/q1, p2/q2, .... pn/qn (pi, qi - натуральные числа).
 * Составить программу, которая приводит эти дроби к общему знаменателю и
 * упорядочивает их в порядке возрастания.
 */

public class Task08 {

	public static void main(String[] args) {

		int n; // Количество дробей
		int range; // Диапазон значений цифр дробей
		boolean[] isReady = new boolean[] { true }; // Флаг возможности выполнения

		n = intFromScanner("Введите количество дробей", "Positive");
		range = intFromScanner("Введите диапазон значений цифр дробей", "Positive");

		int[][] fractial = new int[2][n]; // n дробей занесены в массив.
		// Числители [0][n], знаменатели - [1][n]

		genProperFractialArray(fractial, range);
		printFractialArray(fractial, "Исходные дроби:", isReady);

		commonDenominatorBringing(fractial, isReady);
		printFractialArray(fractial, "Дроби, приведенные к общему знаменателю:", isReady);

		Arrays.sort(fractial[0]); // Используется встроенный алгоритм быстрой сортировки
		printFractialArray(fractial, "Дроби в порядке возрастания:", isReady);

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

	public static void genProperFractialArray(int[][] fractial, int range) {
		if ((fractial == null) || (fractial.length >= 3)) {
			return;
		}

		Random rand = new Random();

		// Генерация случайных значений дробей (могут получиться в том числе
		// неправильные дроби)
		for (int i = 0; i < fractial[0].length; i++) {
			for (int j = 0; j < fractial.length; j++) {
				fractial[j][i] = rand.nextInt(Math.abs(range)) + 1;
			}
		}

		// Приведение к правильному виду дроби (целая часть при этом отбрасывается)
		for (int i = 0; i < fractial[0].length; i++) {
			if (fractial[0][i] > fractial[1][i]) {
				if (fractial[0][i] % fractial[1][i] != 0) {
					fractial[0][i] = fractial[0][i] % fractial[1][i];
				} else {
					fractial[0][i] = fractial[0][i] / fractial[1][i]; // Просто уменьшаем
				}
			}
		}

	}

	public static void printFractialArray(int[][] fractial, String message, boolean[] isReady) {
		if ((fractial == null) || (fractial.length >= 3) || !isReady[0]) {
			return;
		}
		System.out.println(message);

		for (int i = 0; i < fractial[0].length; i++) {
			System.out.printf("%d/%d;   ", fractial[0][i], fractial[1][i]);
		}
		System.out.println();
	}

	public static int lcmTwoPositiveNumber(int a, int b) { // Least Common Multiple (НОК через НОД с помощью алгоритма
															// Евклида)

		int gcd; // Greatest Common Divisor (НОД)
		int tempA;
		gcd = a >= b ? b : a;
		tempA = a >= b ? a : b;
		int tempB = gcd;

		boolean decide = false;
		long test; // Проверка на переполнение int

		test = (long) a * (long) b;

		if (test < Integer.MAX_VALUE && test > Integer.MIN_VALUE) {
			while (!decide) {
				if ((tempA % gcd == 0) && (tempB % gcd == 0)) {
					decide = true;
				} else {
					gcd = tempA % tempB;
					tempA = tempB;
					tempB = gcd;
				}
			}
			return (a * b) / gcd;
		} else {
			return -1;
		}
	}

	public static void commonDenominatorBringing(int[][] fractial, boolean[] isReady) {
		if ((fractial == null) || (fractial.length >= 3) || !isReady[0]) {
			return;
		}
		int commonDenominator = 1; // НОК для всех знаменателей (общий знаменатель)

		// Нахождение НОК для всех знаменателей (нахождение общего знаменателя)
		for (int i = 0; i < fractial[0].length; i++) {
			commonDenominator = lcmTwoPositiveNumber(commonDenominator, fractial[1][i]);
			if (commonDenominator != -1) {
				continue;
			} else {
				System.out.println("Приведение к общему знаменателю невозможно, т.к. число превышает пределы Int");
				isReady[0] = false;
				return;
			}
		}

		// Приведение к общему знаменателю
		for (int i = 0; i < fractial[0].length; i++) {
			int temp;
			temp = commonDenominator / fractial[1][i];
			fractial[0][i] *= temp;
			fractial[1][i] = commonDenominator;
		}
	}

}