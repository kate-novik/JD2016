package by.it.luksha.jd01_09.operations;


import by.it.luksha.jd01_09.vars.Var;

import java.util.HashMap;

public final class Bind {
    private static HashMap<String, Var> variables = new HashMap<String, Var>();

    private Bind() {
    }

    /**
     * Присваивает переменной значение
     * @param key переменная
     * @param var значение
     */
    public static void bind(String key, Var var) {
        variables.put(key, var);
    }

    public static HashMap<String, Var> getVariables() {
        return variables;
    }

    /**
     * Считает значения переменных
     */
    public static void calc() {
        //TODO: считает все выражения var
    }

    /**
     * Печатает все значения переменных
     */
    public static void printVars() {
        for (HashMap.Entry<String, Var> pair: variables.entrySet()) {
            System.out.println(pair.getKey() + "=" + pair.getValue());
        }
    }
}
