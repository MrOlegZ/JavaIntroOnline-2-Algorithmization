package by.jonline.pr02.decomposition;

// Написать метод (методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9

public class Task07 {

	public static void main(String[] args) {

		long sum = 0;
		int num = 9; // Последнее нечетное число в условии задачи

		for (int i = 1; i <= num;) {
			sum += factorial(i);
			i += 2;
		}

		System.out.printf("Сумма факториалов всех нечетных чисел от 1 до 9 равна %d", sum);
	}

	public static long factorial(int number) {

		long result = 1L;

		if (number >= 1) {
			for (int i = 1; i <= number; i++) {
				result *= (long) i;
			}
		} else if (number == 0) {
			result = 1L;
		} else {
			result = 0L;
		}
		return result;
	}
}
