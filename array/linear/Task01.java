package by.jonline.pr02.array.linear;

import java.util.Random;
import java.util.Scanner;

/* В массив A[N] занесены натуральные числа.
 * Найти сумму тех элементов, которые кратны данному K
 */

public class Task01 {

	public static void main(String[] args) {

		int n; // Размерность массива
		int k; // Введенное число
		int sum = 0; // Сумма

		n = intFromScanner("Введите размерность массива (целое положительное число)", true);
		k = intFromScanner("Введите целое число k", false);

		int[] mas = new int[n];

		genArray(mas);

		for (int i = 0; i < mas.length; i++) {
			if ((k != 0) && (mas[i] % k == 0)) {
				sum += mas[i];
			}
		}

		printArray(mas);

		System.out.print("Сумма элементов массива, кратных " + k + " = " + sum);
		
	}
	
	public static int intFromScanner(String message, boolean mark) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		// mark - метка положительного целого ненулевого числа
		
		int res;
		boolean decide = false;
		
		do {
			
			System.out.print(message + " >> ");
			
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.print(message + " >> ");
			}
			
			res = sc.nextInt();
			decide = ((mark) && (res <= 0)) ? true : false;
			
		} while (decide);
		
		return res;
	}
	
	public static void genArray(int[] mas) {
		if (mas == null) {
			return;
		}
		
		Random rand = new Random();
		
		for (int i = 0; i < mas.length; i++) {
			mas[i] = rand.nextInt(100);
		}
		
	}
	
	public static void printArray(int[] mas) {
		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + "; ");
		}
		System.out.println();
	}

}