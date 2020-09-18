package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //testing data
   static int score=0;
    static int maxTile=0;
    public static void main (String[] args) {
       Tile[] mass = {new Tile (4),new Tile (0),new Tile (4),new Tile (2)};
        Tile[] mass1 = {new Tile (8),new Tile (4),new Tile (4),new Tile (0)};
        Tile[] mass2 = {new Tile (4),new Tile (4),new Tile (4),new Tile (0)};
        rec (mass);
       rec (mass1);
        rec (mass2);

    }
   private static void rec(Tile[] tiles){
       compress (tiles);
        Tile start = tiles[0];
        for (int i = 1; i <tiles.length ; i++) {
            if (start.value==tiles[i].value){
                start.value+=tiles[i].value;
                score+= start.value;
                tiles[i].value=0;
                if (start.value>maxTile){
                    maxTile=start.value;
                }

            }
            else {
                start = tiles[i];
            }

        }
       compress (tiles);
        System.out.println ("!!!!!!"+start.value);
        for (int i = 0; i <tiles.length ; i++) {
            System.out.print (tiles[i].value+" ");
        }
        System.out.println ();
        System.out.println ("---"+score);
        System.out.println ("=="+maxTile);

    }
    private static void compress(Tile[] tiles){
        List<Tile> temp = new ArrayList<> ();
        List<Tile> nuls = new ArrayList<> ();
        for (int i = 0; i <tiles.length; i++) {
            if (tiles[i].value==0){
                nuls.add (tiles[i]);
            }
            else {
                temp.add (tiles[i]);
            }
        }
        for (int i = 0; i <temp.size () ; i++) {
            tiles[i]=temp.get (i);
        }
        for (int i = 0; i <nuls.size () ; i++) {
            tiles[temp.size ()+i]=nuls.get (i);
        }
    }
}
