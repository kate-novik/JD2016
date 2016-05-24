package by.it.luksha.jd01_12.tasks.taskB;


import java.util.HashMap;

public class TaskB1 {
    /**
     * Выводит в консоль слово и частоту его встречаемости в тексте data
     * @param data текст
     */
    public static void printDictionary(String data) {
        HashMap<String, Integer> dictionary = createDictionary(data);
        for (HashMap.Entry<String, Integer> pair: dictionary.entrySet()) {
            System.out.println("Word: " + pair.getKey() + "; count: " + pair.getValue());
        }
    }

    /**
     * Создает словарь HashMap из слов и их кол-ва в тексте data
     * @param data текст
     * @return словарь HashMap
     */
    private static HashMap<String, Integer> createDictionary(String data) {
        HashMap<String, Integer> dict = new HashMap<>();
        String[] arrayWords = data.split("\\s|[,\\.\\?!:;]\\s|\\.{3}\\s");
        for (int i = 0; i < arrayWords.length; i++) {
            if (dict.containsKey(arrayWords[i])) {
                dict.put(arrayWords[i], dict.get(arrayWords[i])+1);
            }
            else {
                dict.put(arrayWords[i], 1);
            }
        }
        return dict;
    }
}
