package by.it.sergeev.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTestTest {

    @Test
    public void testAdd() throws Exception {
        int res = CalcTest.add(4, 6);
        assertEquals(10, res, 0.001);
    }

    @Test
    public void testSub() throws Exception {
        int res = CalcTest.sub(8, 3);
        assertEquals(5, res, 0.001);
    }

    @Test
    public void testMul() throws Exception {
        int res = CalcTest.mul(4, 5);
        assertEquals(20, res, 0.001);
    }

    @Test
    public void testDiv() throws Exception {
        int res = CalcTest.div(15, 5);
        assertEquals(3, res, 0.001);
    }
}