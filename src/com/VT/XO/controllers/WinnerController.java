package com.VT.XO.controllers;


import com.VT.XO.models.Field;
import com.VT.XO.models.Figure;
import com.VT.XO.models.exceptions.InvalidMoveException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field){

        for(int i = 0; i < field.getSize(); i++){
            if (checkRowColumn(field, i) != null){
                return checkRowColumn(field,i);
            }
        }

        return checkDiagonals(field);

    }

    Figure checkRowColumn(final Field field, final int rowCol){

        for(int z = 0; z <= field.getSize() - field.getCountForWin(); z++){

                if(checkPointOnRowCol(field, rowCol, z)){
                    try {
                        return field.getFigure(new Point(rowCol, z));
                    } catch (InvalidMoveException e) {
                        e.printStackTrace();
                    }
                }

            if(checkPointOnRowCol(field, z, rowCol)){
                try {
                    return field.getFigure(new Point(z, rowCol));
                } catch (InvalidMoveException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    Figure checkDiagonals(final Field field){

        final int halfDiog = field.getSize() - field.getCountForWin() + 1;

        for(int i = 0; i < halfDiog; i++ ){
            for(int j = 0; j <= field.getSize() -  field.getCountForWin(); j++){

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



    boolean checkPointOnRowCol(final  Field field, final int i, final int j ){

        try {
            if(field.getFigure( new Point(i , j)) == null){
                return false;
            }
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }

        int countEqual = 0;
        for(int k = j; k < field.getCountForWin(); k++){
            try {
                if(field.getFigure(new Point(i, j )) == field.getFigure(new Point(i, k))){
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

        for(int k = 0; k < field.getSize(); k++, i++, j++){
            try {
                if(field.getFigure(new Point(i, j )) == field.getFigure(new Point(i + 1, j + 1))){
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

        for(int k = 0; k < field.getSize(); k++, i++, j--){
            try {
                if(field.getFigure(new Point(i, j )) == field.getFigure(new Point(i + 1, j - 1))){
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
