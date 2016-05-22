package by.it.makevich.jd01_06;

import java.util.Arrays;

public class B3 {
	public static void main(String[] args) {
		String[] words = Content.lukomor.toLowerCase().split("[^а-яА-ЯёЁ]+");
		int[] counterSymbols = new int[words.length];
		Arrays.sort(words);
		char symbol = 'о';
		for (int i = 0; i < words.length; i++) {
			int count = 0;
			for (int j = 0; j < words[i].length(); j++) {
				if (words[i].charAt(j) == symbol) {
					count++;
				}
				counterSymbols[i] = count;
			}
		}
		int tmp;
		for (int i = 0; i < words.length - 1; i++) {//сортировка
			for (int j = i + 1; j < counterSymbols.length; j++) {
				if (counterSymbols[i] < counterSymbols[j]) {
					tmp = counterSymbols[i];
					counterSymbols[i] = counterSymbols[j];
					counterSymbols[j] = tmp;
					String temp = words[i];
					words[i] = words[j];
					words[j] = temp;
				}
			}
		}
		System.out.println("Слова отсортированные по убыванию количества вхождений в них, буквы \""+symbol+"\"");
		for (int i=0;i<words.length;i++){
			System.out.println(words[i]);
		}
	}

}
