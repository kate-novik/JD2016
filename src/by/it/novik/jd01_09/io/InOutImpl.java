package by.it.novik.jd01_09.io;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kate Novik.
 */
public class InOutImpl implements IInOut {

    @Override
    public String input() throws IOException {
        BufferedReader line= new BufferedReader(new InputStreamReader(System.in));
        String out=line.readLine();
        //line.close();
        return out;
    }

    @Override
    public void output(String value) {
        if (!value.isEmpty()) {
            System.out.println(value);
        }
    }
}
