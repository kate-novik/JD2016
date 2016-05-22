package by.it.makevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B1 {
	protected static boolean consonant(String word) {
		String bcd = "бвгджзйклмнпрстфхцчшщ";
		bcd = bcd + bcd.toUpperCase();
		char first = word.charAt(0);
		return bcd.indexOf(first) >= 0;
	}

	public static void main(String[] args) {
		StringBuilder str = new StringBuilder(Content.lukomor);//создали объект StringBuilder с исходным текстом
		Pattern pattern = Pattern.compile("[а-яА-яёЁ]+");//собрали все слова паттерном
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			if (consonant(matcher.group()) && matcher.group().length() == 5) {
				str.delete(matcher.start(), matcher.end());
				matcher.reset();
			}
		}
		System.out.println("Из текста удалить все слова длины 5, начинающиеся на согласную букву.");
		System.out.println(str);

	}
}