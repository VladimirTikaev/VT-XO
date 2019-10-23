package com.VT.XO.controllers;


import com.VT.XO.models.Field;
import com.VT.XO.models.Figure;
import com.VT.XO.models.exceptions.InvalidMoveException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field){

        for(int i = 0; i < field.getSize(); i++){
            if (checkRowColumn(field, i)){
                try {
                    return field.getFigure(new Point(i,0));
                } catch (InvalidMoveException e) {
                    e.printStackTrace();
                }
            }
        }

        return checkDigonals(field);

    }

    boolean checkRowColumn(final Field field, final int rowCol){

        int countEqualInRow = 0;
        int countEqualInColumn = 0;

        for(int j = 0; j < field.getSize(); j++ ){
            try {
                if(field.getFigure(new Point(rowCol, 0)) == field.getFigure(new Point(rowCol,j))){
                    countEqualInRow ++;
                }
                if(field.getFigure(new Point(0, rowCol)) == field.getFigure(new Point(j,rowCol))){
                    countEqualInColumn ++;
                }
            } catch (InvalidMoveException e) {
                e.printStackTrace();
            }
        }

        if(countEqualInRow == field.getSize() || countEqualInColumn == field.getSize() ) {
            return true;
        }
        return false;
    }

    Figure checkDigonals(final Field field){

        int countEqualMainDiog = 0;
        int countEqualSideDiog = 0;
        for(int i = 0; i < field.getSize(); i++){
            try {
                if(field.getFigure(new Point(0,0)) == field.getFigure(new Point(i,i))){
                    countEqualMainDiog ++;
                }

                if(field.getFigure(new Point(0,field.getSize())) == field.getFigure(new Point(i,field.getSize() - i))){
                    countEqualSideDiog ++;
                }
            } catch (InvalidMoveException e) {
                e.printStackTrace();
            }
        }

        if(countEqualMainDiog == field.getSize()){
            try {
                return field.getFigure(new Point(0,0));
            } catch (InvalidMoveException e) {
                e.printStackTrace();
            }
        }

        if(countEqualSideDiog == field.getSize()){
            try {
                return field.getFigure(new Point(0,field.getSize()));
            } catch (InvalidMoveException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
