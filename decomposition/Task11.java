package by.jonline.pr02.decomposition;

import java.util.Scanner;

/* Написать метод (методы), определяющий, в каком из данных двух чисел больше цифр
 */

public class Task11 {

	public static void main(String[] args) {

		String number1;
		String number2;

		number1 = numberFromScanner("Введите число 1");
		number2 = numberFromScanner("Введите число 2");

		if (countNumber(number1) > countNumber(number2)) {
			System.out.println("В первом числе больше цифр");
		} else if ((countNumber(number1) < countNumber(number2))) {
			System.out.println("Во втором числе больше цифр");
		} else {
			System.out.println("В обоих числах равное количество цифр");
		}

	}

	public static String numberFromScanner(String message) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String res = "";
		boolean decide = false;

		System.out.print(message + " >> ");

		while (!decide) {

//			if (sc.hasNextLong()) {
//				res = "l;" + sc.nextLong();
//				decide = true;
//			} else if (sc.hasNextDouble()) {
//				res = "d;" + sc.nextDouble();
//				decide = true;
//			} else if (isNumberForm(res = sc.nextLine())) {
//				decide = true;
//			} else {
//				System.out.print("Введено не число. ");
//				System.out.print(message + " >> ");
//				decide = false;
//			}

			if (isNumberForm(res = sc.nextLine())) {
				decide = true;
			} else {
				System.out.print("Введено не число. ");
				System.out.print(message + " >> ");
				decide = false;
			}

		}

		return res;
	}

	public static boolean isNumberForm(String checkLine) {
		String control = "0123456789"; // Контрольная строка цифр
		String delimer = ".,"; // Разделитель десятичной части
		char now = ' '; // Текущий символ
		int pointCount = 0; // Количество точек
		boolean result = true; // Результат проверки на число
		int i = 0;

		while ((i < checkLine.length()) && (result)) {
			now = checkLine.charAt(i);
			if (control.indexOf(now) != -1) {
				result = true;
			} else {
				if ((i > 0) && (delimer.indexOf(now) != -1) && (pointCount == 0)) {
					pointCount++;
					result = true;
				} else {
					result = false;
				}
			}
			i++;
		}
		return result;
	}

	public static int countNumber(String number) {
		char delimerPoint = '.';
		char delimerComma = ',';

		if ((number.indexOf(delimerPoint) != -1) || (number.indexOf(delimerComma) != -1)) {
			return number.length() - 1;
		} else {
			return number.length();
		}

	}
}