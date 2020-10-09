package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
      return  MyFactoryException.class;
    }

    public static void main(String[] args) {

      Throwable exception =  MyFactoryException.createException(ApplicationExceptionMessage.SOCKET_IS_CLOSED);
        System.out.println(exception.getMessage());

    }
}