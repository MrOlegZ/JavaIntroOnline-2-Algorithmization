package by.jonline.pr02.array.sorting;

import java.util.Random;
import java.util.Scanner;

/* Сортировка выбором.
 * Дана последовательность чисел a1, a2, ..., an.
 * Требуется переставить элементы так, чтобы они были расположены по убыванию.
 * Для этого в массиве, начиная с первого, выбирается наибольший элемент и ставится
 * на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта
 * процедура повторяется. Написать алгоритм сортировки выбором.
 */

public class Task03 {

	public static void main(String[] args) {

		int n; // Размерность последовательности
		int range; // Диапазон значений последовательности

		n = intFromScanner("Введите размер последовательности", "Positive");
		range = intFromScanner("Введите диапазон значений последовательности", "");

		int[] sequenceA = new int[n];

		genArrayInt(sequenceA, range);
		printArrayInt(sequenceA, "Исходная последовательность");

		selectionSortDecreasing(sequenceA);
		printArrayInt(sequenceA, "Отсортированная по убыванию последовательность");
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

	public static void selectionSortDecreasing(int[] mas) {
		if (mas == null) {
			return;
		}

		int maxPosition;
		int temp;

		for (int i = 0; i < mas.length - 1; i++) {
			maxPosition = i;
			for (int j = i + 1; j < mas.length; j++) {
				maxPosition = mas[j] > mas[maxPosition] ? j : maxPosition;
			}
			temp = mas[maxPosition];
			mas[maxPosition] = mas[i];
			mas[i] = temp;
		}
	}
}
