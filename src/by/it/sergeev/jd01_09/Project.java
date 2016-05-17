package by.it.sergeev.jd01_09;

/**
 * Created by user_2 on 16.05.2016.
 */
public class Project {
    public static void main(String[] args) {
        Variable one = new Variable("2.2");
        Variable two = new Variable("3.3");
        Variable res = one.add(two);
        System.out.println(res);
    }
}
