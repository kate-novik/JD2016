package by.it.makevich.jd01_06;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B2 {
	public static void main(String[] args) throws IOException {
		StringBuilder str = new StringBuilder(Content.lukomor);
		Pattern pattern = Pattern.compile("[\n]");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()){
			str.replace(matcher.start(), matcher.start() + 1, " ");//заменили перенос строки на пробел
	}
		String[] sentance = str.toString().split("([^\\.][\\.]{1}\\s)|(!\\s)|\\?\\s");//создали массив из предложений
		String[] words;//массив слов в предложениях
		int[] count = new int[sentance.length];//массив
		for (int i = 0; i < sentance.length; i++) {
			words = sentance[i].trim().split("[^а-яА-ЯёЁ]+");//массив слов
			count[i] = words.length;//заносим в массив длину предложения
		}
		int count1=1;
		System.out.println("Предложения неотсортированные:");
		for (String i: sentance){
			System.out.println(count1+". "+i);
			count1++;
		}
		int temp;
		String[] out = new String[sentance.length];//массив отсортированных предложений
		for (int i = 0; i < sentance.length - 1; i++) {//цикл сортировки
			for (int j = i + 1; j < sentance.length; j++)
				if (count[i] > count[j]) {
					temp=count[i];
					count[i]=count[j];
					count[j]=temp;
					out[i] = sentance[i];
					sentance[i] = sentance[j];
					sentance[j] = out[i];
				}
		}
		System.out.println();
		System.out.println("Предложения отсортированные по возрастанию количества слов в них:");
		int count2=1;
		for (String i : sentance) {
			System.out.println(count2+". "+i);
			count2++;
		}
	}
}




