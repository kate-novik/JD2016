package by.it.kushel.jd01_06;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Diomn on 15.05.2016.
 */
public class TaskA3 {
    static boolean startEndVowels(String word){
        String vowels="аиеоыуэюя";
        vowels=vowels+vowels.toUpperCase();
        char first=word.charAt(0);
        char last=word.charAt(word.length()-1);
        return (vowels.indexOf(first)>=0 && vowels.indexOf(last)>=0);
    }

    public static void main(String[ ] args) {

        StringBuilder text=new StringBuilder(Data.lukomor);
        Pattern pat=Pattern.compile("(^|[^А-яа-яЁё])([А-Яа-яЁё]++)");
        Matcher mat=pat.matcher(text);
        int counter=0;
        while (mat.find())

            if (startEndVowels(mat.group(2)))
            {
                counter++;
                System.out.println(mat.group(2));
            }

        System.out.print("Number of vowels= "+(counter));

    }
}
