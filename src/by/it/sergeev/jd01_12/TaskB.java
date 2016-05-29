package by.it.sergeev.jd01_12;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;


public class TaskB {
    public static void createHashMap() {
        StringBuilder text = new StringBuilder(Text.getString());
        HashMap<String,Integer> hm = new HashMap<String, Integer>();
        Pattern word= Pattern.compile("[a-zA-Z]+");
        Matcher m =word.matcher(text);
        while (m.find()){
            String key = text.substring(m.start(),m.end());
            if(hm.containsKey(key)){
                int value=hm.get(key);
                value++;
                hm.put(key,value);
            }
            else hm.put(key,1);
        }

        for (Map.Entry entry : hm.entrySet()) {
            System.out.println("\"" + entry.getKey() +"\" повторяется "+entry.getValue()+" раз(а)" );
            }
        }
    }