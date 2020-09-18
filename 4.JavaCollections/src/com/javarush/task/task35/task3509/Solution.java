package com.javarush.task.task35.task3509;

import java.util.*;

/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> arrayList = new ArrayList<> ();
        for (int i = 0; i <elements.length ; i++) {
            arrayList.add ((T)elements[i]);
        }
        //напишите тут ваш код
        return arrayList;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> set = new HashSet<> ();
        for (int i = 0; i < elements.length ; i++) {
            set.add ((T) elements[i]);
        }
        //напишите тут ваш код
        return set;
    }

    public static <K,V> HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        HashMap<K,V> map = new HashMap<> ();
        if (keys.size ()==values.size ()) {
            int i=0;
            for (K k:keys
                 ) {
                map.put (k, values.get (i));
                i++;
            }
        } else {
            throw new IllegalArgumentException ();
        }
        //напишите тут ваш код
        return map;
    }
}
