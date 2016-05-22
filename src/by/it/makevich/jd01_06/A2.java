package by.it.makevich.jd01_06;

public class A2 {
	public static void main(String[] args) {
		String str = Content.lukomor;
		String[] arr = str.split("[^а-яА-ЯёЁ]+"); //занесли в массив все слова

		for (int i=0;i<arr.length;i++){ //перебор всех элементов массива
			if (arr[i].length()>0) {
				int count = 1;
				String n;
				for (int j = i + 1; j < arr.length; j++) {// сравниваем i с j
					if (arr[i].equals(arr[j])) {
						count++;
						arr[j] = "";
					}
				}
				if (count%10>1&&count%10<5){n="раза";}else{//делаем правильное окончание у слова "раз(а)"
					n ="раз";}
				System.out.println("слово: \"" + arr[i] + "\" встречается " + count + " "+n);
			}
		}



	}
}
