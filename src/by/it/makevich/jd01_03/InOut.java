package by.it.makevich.jd01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InOut {
	static String consoleReadLine() throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String rLine = bufferedReader.readLine();//записали введенные с консоли данные в строку rline
		bufferedReader.close();
		return rLine;
	}

	static Double[]getArrayDoubleFromRline(String line){//метод создания массива типа Double из введенной строки
		line = line.trim();//удаляем пробелы вначале и в конце
		String[] array = line.split(" "); //создали массив из строки
		int count = array.length; //узнали длину массива
		Double[] doubleArray = new Double[array.length]; //создали массив типа Double
		for (int i=0; i<count; i++ )
			doubleArray[i] = Double.parseDouble(array[i]); //занесли все значения из массива array в mas
		return doubleArray;
	}

	public static void printDoubleArray(Double[] array){//метод выведения на экран массива
		for (int i=0; i<array.length;i++) {System.out.print(array[i] + " ");}
	}

}
