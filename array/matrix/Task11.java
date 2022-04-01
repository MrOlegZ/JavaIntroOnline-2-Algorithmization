package by.jonline.pr02.array.matrix;

import java.util.Random;

/* Матрицу 10х20 заполнить случайными числами от 0 до 15. Вывести на экран
 * саму матрицу и номера строк, в которых число 5 встречается три и более раз
 */

public class Task11 {

	public static void main(String[] args) {

		int m = 10; // Количество строк матрицы
		int n = 20; // Количество столбцов матрицы
		int range = 15; // Диапазон значений
		int k = 5; // Искомое число
		int countK = 3; // Минимальное число повторений k

		int[][] mas = new int[m][n]; // Исходная матрица

		genMatrixIntPositive(mas, range);
		printMatrixIntWithLine(mas, "Исходная матрица:");
		lineNumbers(mas, k, countK);

	}

	public static void genMatrixIntPositive(int[][] mas, int range) {
		if (mas == null) {
			return;
		}

		Random rand = new Random();

		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				mas[i][j] = rand.nextInt(Math.abs(range + 1));
			}
		}
	}

	public static void printMatrixIntWithLine(int[][] mas, String message) {
		if (mas == null) {
			return;
		}
		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			System.out.printf("%d-ая:\t", i + 1);
			for (int j = 0; j < mas[i].length; j++) {
				System.out.print(mas[i][j] + "; \t");
			}
			System.out.println();
		}
	}

	public static void lineNumbers(int[][] mas, int number, int minRepeat) {
		if (mas == null) {
			return;
		}
		int temp;
		int count = 0;

		System.out.printf("Номера строк, в которых число %d встречается %d и более раз:\n", number, minRepeat);

		for (int i = 0; i < mas.length; i++) {
			temp = 0;
			for (int j = 0; j < mas[i].length; j++) {
				temp += (mas[i][j] == 5) ? 1 : 0;
				if (temp == minRepeat) {
					System.out.printf("%d; \t", i + 1); // Выводим номер i+1 строки, т.к. считаем от 1, а в матрице
														// отсчет с 0
					count++;
					break;
				}
			}
		}
		if (count == 0) {
			System.out.print("Отсутствуют");
		}
	}

}
