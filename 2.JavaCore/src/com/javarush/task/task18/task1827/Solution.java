package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.String.format;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String line = "";
        String newLine;
        int nextId = 0;
        if (args.length != 0 && args[0].equals("-c")) {
            BufferedReader fr = new BufferedReader(new FileReader(fileName));

            while ((line = fr.readLine()) != null)
                if (Integer.parseInt(line.substring(0,8).trim()) > nextId) nextId = Integer.parseInt(line.substring(0,8).trim())+1;

            newLine = format("%1$-8.8s%2$-30.30s%3$-8.8s%4$-4.4s",nextId,args[1],args[2],args[3]);
            BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName,true), "Cp1251"));
            fw.newLine();
            fw.write(newLine);
            fr.close();
            fw.close();
        }
    }
}
