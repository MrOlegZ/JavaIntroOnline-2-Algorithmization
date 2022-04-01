package by.jonline.pr02.array.sorting;

import java.util.Random;
import java.util.Scanner;

/* Сортировка обменами (пузырьком).
 * Дана последовательность чисел a1, a2, ..., an.
 * Требуется переставить числа в порядке возрастания.
 * Для этого сравниваются два соседних числа ai и a(i+1). Если ai > a(i+1),
 * то делается перестановка. Так продолжается до тех пор, пока все элементы
 * не станут расположены в порядке возрастания.
 * Составить алгоритм сортировки, подсчитывая при этом количество перестановок.
 */

public class Task04 {

	public static void main(String[] args) {

		int n; // Размерность последовательности
		int range; // Диапазон значений последовательности
		int[] count = new int[1]; // Количество перестановок

		n = intFromScanner("Введите размер последовательности", "Positive");
		range = intFromScanner("Введите диапазон значений последовательности", "");

		int[] sequenceA = new int[n];

		genArrayInt(sequenceA, range);
		printArrayInt(sequenceA, "Исходная последовательность");

		bubbleSortIncreasing(sequenceA, count);
		printArrayInt(sequenceA, "Отсортированная по убыванию последовательность");
		System.out.printf("Количество перестановок - %d", count[0]);
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

	public static void bubbleSortIncreasing(int[] mas, int[] count) {
		if (mas == null) {
			return;
		}

		int temp;
		int pass = 0;
		boolean decide;

		do {

			for (int i = 0; i < mas.length - 1 - pass; i++) {
				if (mas[i] > mas[i + 1]) {
					count[0]++;
					temp = mas[i + 1];
					mas[i + 1] = mas[i];
					mas[i] = temp;
				}
			}

			pass++;
			decide = pass == mas.length - 2 ? true : false;

		} while (!decide);
	}
}
