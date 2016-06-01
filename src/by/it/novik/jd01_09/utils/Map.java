package by.it.novik.jd01_09.utils;

import by.it.novik.jd01_09.entity.Variable;

import java.util.HashMap;

/**
 * Created by Kate Novik.
 */
public class Map {
    // Создание одного объекта в классе Singleton Map
    private static java.util.Map<String,Variable> instance = new HashMap<>();

    private Map() {}

    /**
     * Получение единственного экземпляра класса Map
     * @return Экземпляр класса Map
     */
    public static java.util.Map getInstance () {
        return Map.instance;
    }
}
