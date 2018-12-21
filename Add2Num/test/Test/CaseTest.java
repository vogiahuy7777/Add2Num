/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hy's PC
 */
public class CaseTest {
    
    public CaseTest() {
    }

    /**
     * Test of TestCase1 method, of class Case.
     */
    @Test
    public void testTestCase1() {
        System.out.println("TestCase1");
        Case instance = new Case();
        String expResult = "1098";
        String result = instance.TestCase1();
        assertEquals(expResult, result);
    }

    /**
     * Test of TestCase2 method, of class Case.
     */
    @Test
    public void testTestCase2() {
        System.out.println("TestCase2");
        Case instance = new Case();
        String expResult = "1998";
        String result = instance.TestCase2();
        assertEquals(expResult, result);
    }

    /**
     * Test of TestCase3 method, of class Case.
     */
    @Test
    public void testTestCase3() {
        System.out.println("TestCase3");
        Case instance = new Case();
        String expResult = "1098";
        String result = instance.TestCase3();
        assertEquals(expResult, result);
    }

    /**
     * Test of TestCase4 method, of class Case.
     */
    @Test
    public void testTestCase4() {
        System.out.println("TestCase4");
        Case instance = new Case();
        String expResult = "27";
        String result = instance.TestCase4();
        assertEquals(expResult, result);
    }

    /**
     * Test of TestCase5 method, of class Case.
     */
    @Test
    public void testTestCase5() {
        System.out.println("TestCase5");
        Case instance = new Case();
        String expResult = "187";
        String result = instance.TestCase5();
        assertEquals(expResult, result);
    }
    
}
