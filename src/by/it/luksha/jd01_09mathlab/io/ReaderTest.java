package by.it.luksha.jd01_09mathlab.io;

import org.junit.Test;

import static by.it.luksha.jd01_09mathlab.io.Reader.calc;
import static org.junit.Assert.*;

/**
 * Created by MMauz on 19.06.2016.
 */
public class ReaderTest {

    @Test
    public void testCalc() throws Exception {
        String res = calc("7 + 3"); //парсинг строки
        assertEquals("10.0", res); //вывод строки

        res = calc("7 - 3");
        assertEquals("4.0", res);

        res = calc("7 * 3");
        assertEquals("21.0", res);

        res = calc("7 / 3");
        assertEquals("2.3", res);
    }
}