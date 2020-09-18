package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile = 2;
    public Model() {
        this.score=0;
        this.maxTile=0;
        resetGameTiles ();

    }


    /*Метод для получения списка пустых ячеек на поле игры*/
    private List<Tile> getEmptyTiles(){
        return Arrays.stream(gameTiles).flatMap(Arrays::stream)
                .filter(Tile::isEmpty).collect(Collectors.toList());
    }
    private void addTile(){
        List<Tile> emptyTiles = getEmptyTiles();
        if(emptyTiles.size() > 0)
            emptyTiles.get((int)(emptyTiles.size() * Math.random())).value = (Math.random() < 0.9 ? 2 : 4);
    }
    public void resetGameTiles(){
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }
    private boolean compressTiles(Tile[] tiles){
        List<Tile> temp = new ArrayList<> ();
        List<Tile> nuls = new ArrayList<> ();
        boolean flag=false;
        for (int i = 0; i <tiles.length; i++) {
            if (tiles[i].value==0&&i!=tiles.length-1){
                flag=true;
            }
            if (tiles[i].value==0){
                nuls.add (tiles[i]);
            }
            else {
                temp.add (tiles[i]);
            }
        }

        if (temp.size ()!=0) {
            temp.addAll (nuls);
            for (int i = 0; i <temp.size () ; i++) {
                tiles[i]=temp.get (i);
            }
        }
       return flag;

    }
    private boolean mergeTiles(Tile[] tiles){

        compressTiles (tiles);
        Tile start = tiles[0];
        boolean flag=false;
        for (int i = 1; i <tiles.length ; i++) {
            if (start.value==tiles[i].value){
                start.value+=tiles[i].value;
                score+= start.value;
                tiles[i].value=0;
                flag=true;
                if (start.value>maxTile){
                    maxTile=start.value;
                }

            }
            else {
                start = tiles[i];
            }

        }
        compressTiles (tiles);
        return flag;
    }
    public void left(){
        for (int i = 0; i <gameTiles.length ; i++) {
          if (compressTiles (gameTiles[i])||mergeTiles (gameTiles[i]))
          {
              addTile ();
          }

        }
    }
}
