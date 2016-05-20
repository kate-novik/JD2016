package by.it.kushel.jd01_08;

/**
 * Created by Diomn on 17.05.2016.
 */
import static java.lang.Math.*;

public class Project {
    public static void main(String[] args) {
Variable one = new Variable("2.2");
        Variable two = new Variable("3.3");
        Variable res1=one.add(two);
        System.out.println(one+"+"+two+"="+res1);
        Variable res2=one.sub(two);
        System.out.println(one+"-"+two+"="+res2);
        Variable res3=one.mul(two);
        System.out.println(one+"*"+two+"="+res3);
        Variable res4=one.div(two);
        System.out.println(one+":"+two+"="+res4);
    }
}
