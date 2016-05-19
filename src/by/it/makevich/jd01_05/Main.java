<<<<<<< Updated upstream
package by.it.makevich.jd01_05;

import static java.lang.Math.pow;

public class Main {
	public static void main(String[] args) {
		/**
		 * Задание 1
		 */
		System.out.println("Task 1 (А): y=" + Task1.optionA(0.4,-4.17));
		System.out.println("Task 1 (B): y="+Task1.optionB(0.4,-4.17));

		/**
		 * Задание 2 -  значения х и f заданы изначально. Вывод значения y.
		 */
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();
		System.out.println("Задание 2: x=2.57*10^3, f=0.873");
		System.out.println("Решить уравнение y=(sin(pow(PI/8-f,2))+pow(3+pow(x,2),1/4))/2");
		System.out.println("y="+Task2.calculate(2.57*pow(10,3),0.873));
		/**
		 * Задание 2 - ввод значений х и f с консоли и вывод значения y вместе с самим уравнением
		 */

		System.out.println("Задание 2: значения x и f вводятся с клавиатуры");
		System.out.println("Решить уравнение y=(sin(pow(PI/8-f,2))+pow(3+pow(x,2),1/4))/2\nВведите значения \"x\" и \"f\":");
        double[]xF=Task2.in();//ввод x и f с консоли
		System.out.println("\nУравнение решено:");
		System.out.println(Task2.calculate(xF[0],xF[1])+"=(sin(pow(PI/8-"+xF[1]+",2))+pow(3+pow("+xF[1]+",2),1/4))/2");

		/**
		 * Задание 3
		 */
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		Task3.printTable();

		/**
		 * Задание 4
		 */
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("Task 4");
		System.out.println(Task4.calculate(2.408));

		/**
		 * Задание 5
		 */
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("Task 5");
		Task5.calculate();

		/**
		 * Задание 6
		 */
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("Task 6");
		double[] array=Task6.getArray();
		Task6.printArray(array,"testname");
		int count=Task6.count(array);
		double[] newArray=Task6.newArray(array, count);
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		Task6.printArray(newArray,"Новый массив чисел имеющих нечетный индекс в массиве testname");
		double increase=Task6.toIncrease(newArray);
		System.out.println("Произведение всех чисел массива: "+increase);

		/**
		 * Задание 7
		 */
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("Task 7");
		double[] arrayM=Task7.getRandomArray();
		int counterArrayKlenth=Task7.count(arrayM);
		double[] arrayK=Task7.getArrayKFromArrayM(arrayM,counterArrayKlenth);
		Task7.printArrayM(arrayM);
		System.out.println();
		Task7.printArrayK(arrayK);

	}
}
=======
package by.it.makevich.jd01_05;

import static java.lang.Math.pow;

public class Main {
	public static void main(String[] args) {
		/**
		 * Задание 1
		 */
		System.out.println("Задание 1 (А): y=" + Task1.optionA(0.4,-4.17));
		System.out.println("Задание 1 (B): y="+Task1.optionB(0.4,-4.17));

		/**
		 * Задание 2 -  значения х и f заданы изначально. Вывод значения y.
		 */
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();
		System.out.println("Задание 2: x=2.57*10^3, f=0.873");
		System.out.println("Решить уравнение y=(sin(pow(PI/8-f,2))+pow(3+pow(x,2),1/4))/2");
		System.out.println("y="+Task2.calculate(2.57*pow(10,3),0.873));
		/**
		 * Задание 2 - ввод значений х и f с консоли и вывод значения y вместе с самим уравнением
		 */

		System.out.println("Задание 2: значения x и f вводятся с клавиатуры");
		System.out.println("Решить уравнение y=(sin(pow(PI/8-f,2))+pow(3+pow(x,2),1/4))/2\nВведите значения \"x\" и \"f\":");
        double[]xF=Task2.in();//ввод x и f с консоли
		System.out.println("\nУравнение решено:");
		System.out.println(Task2.calculate(xF[0],xF[1])+"=(sin(pow(PI/8-"+xF[1]+",2))+pow(3+pow("+xF[1]+",2),1/4))/2");

		/**
		 * Задание 3
		 */
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		Task3.printTable();

		/**
		 * Задание 4
		 */
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("Задание 4:");
		System.out.println(Task4.calculate(2.408));

		/**
		 * Задание 5
		 */
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("Задание 5");
		Task5.calculate();

		/**
		 * Задание 6
		 */
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("Задание 6");
		double[] array=Task6.getArray();
		Task6.printArray(array,"testname");
		int count=Task6.count(array);
		double[] newArray=Task6.newArray(array, count);
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		Task6.printArray(newArray,"Новый массив чисел имеющих нечетный индекс в массиве testname");
		double increase=Task6.toIncrease(newArray);
		System.out.println("Произведение всех чисел массива: "+increase);
	}
}
>>>>>>> Stashed changes
