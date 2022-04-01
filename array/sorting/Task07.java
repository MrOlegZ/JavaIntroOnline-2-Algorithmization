package by.jonline.pr02.array.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/* Пусть даны две неубывающие последовательности действительных чисел a1 <= a2 <= ... <= an и
 * b1 <= b2 <= ... <= bm. Требуется указать те места, на которые нужно вставлять элементы
 * последовательности b1 <= b2 <= ... <= bm в первую последовательность так, чтобы
 * новая последовательность оказалась возрастающей.
 */

public class Task07 {

	public static void main(String[] args) {

		int n; // Размерность последовательности a
		int m; // Размерность последовательности b
		int range; // Диапазон значений последовательностей

		n = intFromScanner("Введите размер последовательности a", "Positive");
		m = intFromScanner("Введите размер последовательности b", "Positive");
		range = intFromScanner("Введите диапазон значений последовательностей", "");

		int[] sequenseA = new int[n];
		int[] sequenseB = new int[m];

		genArrayInt(sequenseA, range);
		genArrayInt(sequenseB, range);

		Arrays.sort(sequenseA); // Создание неубывающей последовательности A
		Arrays.sort(sequenseB); // Создание неубывающей последовательности B

		printArrayInt(sequenseA, "Последовательность A:");
		printArrayInt(sequenseB, "Последовательность B:");

		insertPlace(sequenseA, sequenseB);
//		printArrayInt(sequenseA, "Новая последовательность:");

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

	public static void insertPlace(int[] sequenceA, int[] sequenceB) {
		if (sequenceA == null || sequenceB == null) {
			return;
		}

		int n = sequenceA.length;
		int m = sequenceB.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ((i == 0) && (sequenceB[j] <= sequenceA[i])) {
					System.out.printf("%d эл-т последовательности B вставляется до %d эл-та A\n", j, i);
				} else if (i >= 0 && i < n - 1 && (sequenceB[j] >= sequenceA[i])
						&& (sequenceB[j] <= sequenceA[i + 1])) {
					System.out.printf("%d эл-т последовательности B вставляется между %d и %d эл-тами A\n", j, i,
							i + 1);
				} else if ((i == n - 1) && (sequenceB[j] >= sequenceA[i])) {
					System.out.printf("%d эл-т последовательности B вставляется после %d эл-та A\n", j, i);
				}
			}
		}

	}
}
