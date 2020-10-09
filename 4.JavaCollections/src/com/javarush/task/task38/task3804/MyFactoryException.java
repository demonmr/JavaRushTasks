package com.javarush.task.task38.task3804;

import java.lang.reflect.Type;

public class MyFactoryException {
    Exception exception;
    public MyFactoryException(Exception exception)
    {
        this.exception = exception;
    }

    public static Throwable  createException(Enum type)
    {
        String messsge;
        if (type instanceof ApplicationExceptionMessage) {
            messsge=ApplicationExceptionMessage.valueOf(type.name()).name().toLowerCase().replaceAll("_"," ");
            String result = messsge.substring(0,1).toUpperCase()+messsge.substring(1);
            System.out.println(result);
                new Exception(result);
        }
        if (type instanceof DatabaseExceptionMessage)
        {

                new RuntimeException(DatabaseExceptionMessage.valueOf(type.name().replace("_", " ").toLowerCase().substring(0,1).toUpperCase()).toString());
        }

        if (type instanceof UserExceptionMessage)
        {
            new Error(DatabaseExceptionMessage.valueOf(type.name().replace("_", " ").toLowerCase()).toString());
        }

        return new IllegalArgumentException();

    }

}
