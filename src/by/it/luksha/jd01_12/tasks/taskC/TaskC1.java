package by.it.luksha.jd01_12.tasks.taskC;

import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class TaskC1 {
    /**
     * Преобразует строку в мапу с хэшэм в key и множеством set слов (уникальных) в value
     * @param text строка
     * @return TreeMap
     */
    public static TreeMap<Integer, HashSet<String>> createCypher(String text) {
        String[] arrayWords = text.split(" ");
        TreeMap<Integer, HashSet<String>> cypher = new TreeMap<>();
        for (String word: arrayWords) {
            int hash = word.hashCode();
            if (!cypher.containsKey(hash)) {
                HashSet<String> set = new HashSet<>();
                set.add(word);
                cypher.put(hash, set);
            }
            else {
                cypher.get(hash).add(word);
            }
        }
        return cypher;
    }

    /**
     * Выводит TreeMap в консоль
     * @param treeMap
     */
    public static void printTreeMap(TreeMap<Integer, HashSet<String>> treeMap) {
        for (Map.Entry<Integer, HashSet<String>> pair: treeMap.entrySet()) {
            System.out.printf("Шифру %s соответствуют слова: ", pair.getKey());
            for (String word: pair.getValue()) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}
