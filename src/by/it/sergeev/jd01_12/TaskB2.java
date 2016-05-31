package by.it.sergeev.jd01_12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TaskB2 {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(r.readLine());
        Timer t = new Timer();
        ArrayList<Integer> arraylist = new ArrayList<>();
        LinkedList<Integer> linkedlist = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            arraylist.add(i);
            linkedlist.add(i);
        }
        int arraycount = 0; //круг
        while (arraylist.size() != 1) {
            for (int i = 0; i < arraylist.size(); ) {
                if (arraylist.size() % 2 == 0) {
                    int al = arraylist.get(arraylist.size() - 1);//переменной присваивается значение последней строки
                    arraylist.remove(arraylist.size() - 1);//удаление значения из последняя строки
                    arraylist.add(0, al); // присваивание в нулевой ячейке(первой строке)
                    arraylist.remove(i);
                    i += 2;
                } else if (arraylist.size() % 2 != 0) {
                    arraylist.remove(i);
                    i += 2;
                }
            }
            arraycount++;
            System.out.println(arraycount + " круг метода ArrayList" + arraylist);
        }
        int linkedcount = 0;//круг
        while (linkedlist.size() != 1) {
            for (int i = 0; i < linkedlist.size(); ) {
                if (linkedlist.size() % 2 == 0) {
                    int al = linkedlist.get(linkedlist.size() - 1);//переменной присваивается значение последней строки
                    linkedlist.remove(linkedlist.size() - 1);//удаление значения из последняя строки
                    linkedlist.add(0, al); // присваивание в нулевой ячейке(первой строке)
                    linkedlist.remove(i);
                    i += 2;
                } else if (linkedlist.size() % 2 != 0) {
                    linkedlist.remove(i);
                    i += 2;
                }
            }
            linkedcount++;
            System.out.println(linkedcount + " круг метода LinkedList" +linkedlist);
        }
        System.out.println("Метод ArrayList. " + t + arraylist);
        System.out.println("Метод LinkedList. " + t + linkedlist);
    }


    public static class Timer{
        private  long iniTime;
        private  Double Delta;
        public Timer(){
            iniTime=System.nanoTime();
        }
        public  String toString(){
            Delta=(double)(System.nanoTime()-iniTime)/1000;
            iniTime=System.nanoTime();
            return "Прошло "+Delta.toString()+" микросекунд.";
        }
    }
}

