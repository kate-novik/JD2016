package by.it.luksha.jd01_12.tasks.taskA.taskA2;


import java.util.HashSet;

public class MyCollect {
    /**
     * Находит пересечение двух множеств 1 и 2
     * @param setA множество 1
     * @param setB множество 2
     * @return множество-пересечение
     */
    public static HashSet<Integer> getCross(HashSet<Integer> setA, HashSet<Integer> setB) {
        HashSet<Integer> cross = new HashSet<Integer>(setA);
        cross.retainAll(setB);
        return cross;
    }

    /**
     * Находит объединение двух множеств 1 и 2
     * @param setA множество 1
     * @param setB множество 2
     * @return множество-объединение
     */
    public static HashSet<Integer> getUnion(HashSet<Integer> setA, HashSet<Integer> setB) {
        HashSet<Integer> union = new HashSet<Integer>(setA);
        union.addAll(setB);
        return union;
    }
}
