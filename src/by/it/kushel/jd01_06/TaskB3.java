package by.it.kushel.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Diomn on 14.05.2016.
 */
public class TaskB3 {

    public static void main(String[] arg) {
        char symbol='у';
        Pattern pat;
        Matcher mat;
        boolean found;
        int count=0;
        String str = new String(Data.lukomor);
        pat = Pattern.compile("(^|[^А-яа-яЁё])([А-Яа-яЁё]++)");
        mat = pat.matcher(str);
        String[] words = str.split("[^а-яА-ЯёЁ]+");
        CustomStringComparator compor = new CustomStringComparator('а');

        for (int i=0; i<words.length; i++) {
            words[i]=words[i].toLowerCase();
            for (int j=i+1; j<words.length; j++) {

            if(compor.compare(words[i],words[j])<0){
                String temp = words[i];
                words[i]=words[j];
                words[j]=temp;
            }

            }
            System.out.println(words[i]);
        }


    }
}
