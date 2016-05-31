package by.it.luksha.jd01_12;


import by.it.luksha.jd01_02.TaskC;
import by.it.luksha.jd01_12.tasks.taskA.TaskA1;
import by.it.luksha.jd01_12.tasks.taskA.TaskA3;
import by.it.luksha.jd01_12.tasks.taskA.taskA2.MyCollect;
import by.it.luksha.jd01_12.tasks.taskA.taskA2.TaskA2;
import by.it.luksha.jd01_12.tasks.taskB.Data;
import by.it.luksha.jd01_12.tasks.taskB.TaskB1;
import by.it.luksha.jd01_12.tasks.taskB.TaskB2;
import by.it.luksha.jd01_12.tasks.taskC.TaskC1;
import by.it.luksha.jd01_12.tasks.taskC.TaskC2.TaskC2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeMap;

public class Runner {
    public static void main(String[] args) {


        //TaskA1
        ArrayList<Integer> table = TaskA1.createTableMarks();
        ArrayList<Integer> tableGoodsMark = TaskA1.deleteBadMarks(table);
        TaskA1.printTable(table);
        TaskA1.printTable(tableGoodsMark);

        //TaskA2
        HashSet<Integer> setA = TaskA2.createSet();
        TaskA2.printSet(setA);
        HashSet<Integer> setB = TaskA2.createSet();
        TaskA2.printSet(setB);
        TaskA2.printSet(MyCollect.getCross(setA, setB));
        TaskA2.printSet(MyCollect.getUnion(setA, setB));

        //TaskA3
        ArrayList<Integer> list = TaskA3.createList();
        TaskA3.printArrayList(list);
        Collections.sort(list);
        Collections.reverse(list);
        TaskA3.printArrayList(list);

        //TaskB1
        System.out.println(Data.TEXT);
        TaskB1.printDictionary(Data.TEXT);

        //TaskB2
        TaskB2.processArray(100000);
        TaskB2.processLinked(100000);

        //TaskC1
        String text = "пегас Сова сова сова сова сова сова филин воробей соловей орел сокол ястреб Ястреб ворона коршун";
        TreeMap<Integer, HashSet<String>> cypher = TaskC1.createCypher(text);
        TaskC1.printTreeMap(cypher);

        //TaskC2
        HashSet<String> setStringA = TaskC2.createSet();
        HashSet<String> setStringB = TaskC2.createSet();
        HashSet<Integer> setIntegerA = TaskA2.createSet();
        HashSet<Integer> setIntegerB = TaskA2.createSet();
        TaskC2.printSet(by.it.luksha.jd01_12.tasks.taskC.TaskC2.MyCollect.getCross(setStringA, setStringB));
        TaskC2.printSet(by.it.luksha.jd01_12.tasks.taskC.TaskC2.MyCollect.getCross(setIntegerA, setIntegerB));
        TaskC2.printSet(by.it.luksha.jd01_12.tasks.taskC.TaskC2.MyCollect.getUnion(setStringA, setStringB));
        TaskC2.printSet(by.it.luksha.jd01_12.tasks.taskC.TaskC2.MyCollect.getUnion(setIntegerA, setIntegerB));


        //TaskC3

    }
}
