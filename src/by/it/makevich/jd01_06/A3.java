package by.it.makevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A3 {
	static boolean Glasnaya(String word){
		String oae="яыуаиеоюэЯЫУАИЕОЮЭ";
		char first=word.charAt(0);
		char last=word.charAt(word.length()-1);
		return (oae.indexOf(first)>=0 && oae.indexOf(last)>=0);
	}
	public static void main(String[] args) {


		StringBuilder content= new StringBuilder(Content.lukomor);
		Pattern pattern=Pattern.compile("[а-яА-ЯёЁ]+");
		Matcher matcher=pattern.matcher(content);
		int counter=0;
		while (matcher.find())
			if (Glasnaya(matcher.group()))
			{
				counter++;
			}

		System.out.print("Количество слов начинающихся и заканчивающихся на гласную: "+counter);

	}
}
