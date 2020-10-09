package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        Annotation[] annotations = c.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(PrepareMyTest.class)) {
                PrepareMyTest my = (PrepareMyTest) annotation;
                String[] fullyQualifiedNames = my.fullyQualifiedNames();
                for (String fullyQualifiedName : fullyQualifiedNames) {
                    System.out.println(fullyQualifiedName);
                }
                 Class[] value=my.value();
                for (Class aClass : value) {
                    System.out.println(aClass.getSimpleName());
                }


                return true;
            }


        }

        return false;


    }

    public static boolean printValues(Class c) {
        Annotation[] annotations = c.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(PrepareMyTest.class)) {
                PrepareMyTest my = (PrepareMyTest) annotation;
                String[] fullyQualifiedNames = my.fullyQualifiedNames();
                for (String fullyQualifiedName : fullyQualifiedNames) {
                    System.out.println(fullyQualifiedName);
                }
                Class[] value=my.value();
                for (Class aClass : value) {
                    System.out.println(aClass.getSimpleName());
                }


                return true;
            }


        }

        return false;
    }
}
