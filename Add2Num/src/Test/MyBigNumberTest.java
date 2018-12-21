/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import AddTwoNumber.IReceiver;
import AddTwoNumber.MyBigNumber;

/**
 *
 * @author Hy's PC
 */
public class MyBigNumberTest implements IReceiver {

    /**
     * Hàm main dùng để chạy các testcase Trong đó hàm main gọi lại các hàm chứa
     * test case để kiểm tra tính đúng đắng của chương trình
     */
    public static void main(String[] args) {

        // gọi các hàm chứatestcase
        TestCase1();
        TestCase2();
        TestCase3();
        TestCase4();
        TestCase5();
        TestCase6();
        TestCase7();
    }

    @Override
    public void send(String msg) {
        System.out.println(msg);
    }

    // các hàm chứa tescase
    public static void TestCase1() {
        try {
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Case 1:");
            mybignumber.sum("99", "999");
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    public static void TestCase2() {
        try {
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Case 2:");
            System.out.println("kết quả: " + mybignumber.sum("9999", "999"));
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    public static void TestCase3() {
        try {
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Case 3:");
            System.out.println(mybignumber.sum("99", "99"));
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    public static void TestCase4() {
        try {
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Case 4:");
            System.out.println(mybignumber.sum("A", "999"));
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    public static void TestCase5() {
        try {
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Case 5:");
            System.out.println(mybignumber.sum("89", "98*"));
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    public static void TestCase6() {
        try {
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Case 6:");
            System.out.println(mybignumber.sum("-1", "12"));
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    public static void TestCase7() {
        try {
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Case 7:");
            System.out.println(mybignumber.sum("", ""));
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}
