package by.it.drachyova.jd01_09.Variables;

import org.junit.Test;

import static org.junit.Assert.*;


public class VariableDoubleTest {
    @Test
    public void addition() {
        AbstractVariable var1 = new VariableDouble("1");
        AbstractVariable var2 = new VariableDouble("2");
        AbstractVariable varExpected = new VariableDouble("3");
        AbstractVariable result = var1.addition(var2);
        assertEquals(varExpected, result);
    }

    @Test
    public void subtraction() {
        AbstractVariable var1 = new VariableDouble("3");
        AbstractVariable var2 = new VariableDouble("2");
        AbstractVariable varExpected = new VariableDouble("1");
        AbstractVariable result = var1.subtraction(var2);
        assertEquals(varExpected, result);
    }

    @Test
    public void multiplication() {
        AbstractVariable var1 = new VariableDouble("3");
        AbstractVariable var2 = new VariableDouble("2");
        AbstractVariable varExpected = new VariableDouble("6");
        AbstractVariable result = var1.multiplication(var2);
        assertEquals(varExpected, result);
    }

    @Test
    public void division() {
        AbstractVariable var1 = new VariableDouble("6");
        AbstractVariable var2 = new VariableDouble("3");
        AbstractVariable varExpected = new VariableDouble("2");
        AbstractVariable result = var1.division(var2);
        assertEquals(varExpected, result);

    }

}