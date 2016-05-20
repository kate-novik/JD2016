package by.it.kushel.jd01_06;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Diomn on 14.05.2016.
 */
public class CustomStringComparator implements Comparator<String> {


            char ch;
    CustomStringComparator(char symbol){
        ch = symbol;
    }
    public int compare(String s1, String s2) {
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            if (ch1 == ch) {
                count1 = count1 + 1;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == ch) {
                count2 = count2 + 1;
            }
        }
        if (count1 > count2) {
            return 1;
        } else if (count1 < count2) {
            return -1;
        }

        return s1.compareToIgnoreCase(s2);


    }

    public static String createString(String[] masStr) {
        String str1 = "";
        for (int i = 0; i < masStr.length; i++) {
            str1 = str1 + "'" + masStr[i] + "',";
        }
        str1 = "[" + str1.substring(0, str1.length() - 1) + "]";
        return str1;
    }

    public static void main(String[] args) {
        String str=new String(Data.lukomor);
        String[] masStr =str.split("[^а-яА-ЯёЁ]+");
                Arrays.sort(masStr, new CustomStringComparator('a'));
        System.out.println(createString(masStr));

    }
}
