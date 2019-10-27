package com.VT.XO.controllers;


import com.VT.XO.models.Field;
import com.VT.XO.models.Figure;
import com.VT.XO.models.exceptions.InvalidMoveException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field){


        if(checkRowsColumns(field) != null){
            return  checkRowsColumns(field);
        }

        return checkDiagonals(field);

    }

    Figure checkRowsColumns(final Field field){

        for(int i = 0; i < field.getSize(); i++){
            if(checkOneRowCol(field, i) != null){
                return checkOneRowCol(field, i);
            }
        }


        return null;
    }

    Figure checkOneRowCol(final Field field, final int i){

        for(int z = 0; z < (field.getSize() - field.getCountForWin()) + 1; z++ ){


                if(checkPointOnRow(field, i, z)){
                    try {
                        return field.getFigure(new Point(i, z));
                    } catch (InvalidMoveException e) {
                        e.printStackTrace();
                    }
                }

                if(checkPointOnColumn(field, z, i)){
                    try {
                        return field.getFigure(new Point(z, i));
                    } catch (InvalidMoveException e) {
                        e.printStackTrace();
                    }
                }

        }

        return null;

    }

    private boolean checkPointOnRow(Field field, int x, int y) {

        try {
            if(field.getFigure( new Point(x , y)) == null){
                return false;
            }
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }

        int y1 = y;
        int countEqual = 0;
        for(int k = 0; k < field.getCountForWin(); k++, y1++){
            try {
                if(field.getFigure(new Point(x, y)) == field.getFigure(new Point(x, y1))){
                    countEqual++;
                }
            } catch (InvalidMoveException e) {
                e.printStackTrace();
            }
        }

        if(countEqual == field.getCountForWin()){
            return true;
        }

        return false;
    }

    private boolean checkPointOnColumn(Field field, int x, int y) {

        try {
            if(field.getFigure( new Point(x , y)) == null){
                return false;
            }
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }

        int x1 = x;
        int countEqual = 0;
        for(int k = 0; k < field.getCountForWin(); k++, x1++){
            try {
                if(field.getFigure(new Point(x, y)) == field.getFigure(new Point(x1, y))){
                    countEqual++;
                }
            } catch (InvalidMoveException e) {
                e.printStackTrace();
            }
        }

        if(countEqual == field.getCountForWin()){
            return true;
        }

        return false;
    }





    Figure checkDiagonals(final Field field){

        final int quarterDiagonals = field.getSize() - field.getCountForWin() + 1;

        for(int i = 0; i < quarterDiagonals; i++ ){
            for(int j = 0; j <= field.getSize() -  field.getCountForWin() - i; j++){

                try {

                    if(checkPointOnMainDiag(field, j, j+i)){
                            return field.getFigure(new Point(j, j+i));
                    }

                    if(checkPointOnMainDiag(field, j+i, j)){
                            return field.getFigure(new Point(j+i, j));
                    }

                    if(checkPointOnSideDiag(field, j , (field.getSize() - 1 ) - (j + i))){
                             return field.getFigure(new Point(j, (field.getSize() - 1 ) - (j + i)));
                    }

                    if(checkPointOnSideDiag(field, j + i , (field.getSize() - 1 ) - j)){
                        return field.getFigure(new Point(j + i, (field.getSize() - 1 ) - j));
                    }

                } catch (InvalidMoveException e) {
                    e.printStackTrace();
                }
            }


        }

        return null;
    }




    boolean checkPointOnMainDiag(final Field field, final int x, final int y){

        try {
            if(field.getFigure( new Point(x , y)) == null){
                return false;
            }
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }

        int countEqual = 0;
        int i = x;
        int j = y;

        for(int k = 0; k < field.getCountForWin(); k++, i++, j++){
            try {
                if(field.getFigure(new Point(x, y )) == field.getFigure(new Point(i, j ))){
                    countEqual++;
                }
            } catch (InvalidMoveException e) {
                e.printStackTrace();
            }
        }

        if(countEqual == field.getCountForWin()){
            return true;
        }
        return false;
    }

    boolean checkPointOnSideDiag(final Field field, final int x, final int y){

        try {
            if(field.getFigure( new Point(x , y)) == null){
                return false;
            }
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }

        int countEqual = 0;
        int i = x;
        int j = y;

        for(int k = 0; k < field.getCountForWin(); k++, i++, j--){
            try {
                if(field.getFigure(new Point(x, y )) == field.getFigure(new Point(i, j))){
                    countEqual++;
                }
            } catch (InvalidMoveException e) {
                e.printStackTrace();
            }
        }

        if(countEqual == field.getCountForWin()){
            return true;
        }
        return false;
    }

}
