package by.it.luksha.jd01_12.tasks.taskC.TaskC2;


import java.util.HashSet;

public class MyCollect {
    /**
     * Ищет пересечение двух множест с произвольным типом данных
     * @param setA первое множество
     * @param setB второе множество
     * @param <T> тип наследуется от Object
     * @return результат пересечения двух множеств
     */
    public static <T extends Object> HashSet<T> getCross(HashSet<T> setA, HashSet<T> setB) {
        HashSet<T> cross = new HashSet<T>(setA);
        cross.retainAll(setB);
        return cross;
    }

    /**
     * Ищет объединение двух множест с произвольным типом данных
     * @param setA первое множество
     * @param setB второе множество
     * @param <T> тип наследуется от Object
     * @return результат объединения двух множеств
     */
    public static <T extends Object> HashSet<T> getUnion(HashSet<T> setA, HashSet<T> setB) {
        HashSet<T> union = new HashSet<T>(setA);
        union.addAll(setB);
        return union;
    }
}
