package by.it.luksha.jd01_13;

/*
Вариант B. Разработать консольное приложение, в котором поместить 3 void
        процедуры, вложенные друг в друга.
        § Каждую процедуру сопроводить двумя сообщениями: в начале и в конце тела
        процедуры. Код процедуры – произвольный, но с возможным делением на ноль.
        § Проследить обработку исключений, обязательно защитить вызов каждой процедуры во
        внешнем вызывающем блоке.
        § Один тип ошибки – деление на ноль обрабатывать в процедуре, остальные ошибки
        пробрасывать и обрабатывать в main.
*/

/**
 * Created by MMauz on 09.06.2016.
 */


public class TaskB {
    protected static void run() throws Exception {
        method1();
    }

    private static void method1() throws Exception {
        System.out.printf("Начало method1\n");
        method2();
        if (Math.random()*2 > 1) {
            throw new Exception("Ошибка прилетела из method1\n");
        } else {
            try {
                int divByzero = 1 / 0;
            } catch (ArithmeticException e) {
                System.out.printf("Ошибка >>>%s<<< обработана в method1\n", e.getMessage());
            }
        }
        System.out.printf("Конец method1\n");
    }

    private static void method2() throws Exception {
        System.out.printf("Начало method2\n");
        method3();
        if (Math.random()*2 > 1) {
            throw new Exception("Ошибка прилетела из method2\n");
        } else {
            try {
                int divByzero = 1 / 0;
            } catch (ArithmeticException e) {
                System.out.printf("Ошибка >>>%s<<< обработана в method2\n", e.getMessage());
            }
        }
        System.out.printf("Конец method2\n");
    }

    private static void method3() throws Exception {
        System.out.printf("Начало method3\n");
        if (Math.random()*2 > 1) {
            throw new Exception("Ошибка прилетела из method3\n");
        } else {
            try {
                int divByzero = 1 / 0;
            } catch (ArithmeticException e) {
                System.out.printf("Ошибка >>>%s<<< обработана в method3\n", e.getMessage());
            }
        }
        System.out.printf("Конец method3\n");
    }
}
