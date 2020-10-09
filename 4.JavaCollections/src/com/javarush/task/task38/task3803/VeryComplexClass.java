package com.javarush.task.task38.task3803;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() throws ClassCastException {
        Object ob = new Object();
        ArrayList list=(ArrayList) ob;



    }

    public void methodThrowsNullPointerException() throws NullPointerException {
        ArrayList a=null;
       a.add(new Object());
    }

    public static void main(String[] args) {

    }
}
