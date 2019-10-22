package com.VT.XO.controllers;


import com.VT.XO.models.Field;
import com.VT.XO.models.Figure;
import com.VT.XO.models.exceptions.InvalidMoveException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field){
        int countFigure = 0;

        for (int i = 0; i < field.getSize(); i++){
             countFigure += countFigureInRow(field, i);
        }

        if(countFigure == field.getSize() * field.getSize()){
            return null;
        }

        if(countFigure == 0 | countFigure % 2 == 0){
            return Figure.X;
        }

        return Figure.O;
    }

    int countFigureInRow(final Field field, final int row) {
        int countInRow = 0;
        for (int j = 0; j < field.getSize(); j++) {
            try {
                if (field.getFigure(new Point(row, j)) != null) {
                    countInRow++;
                }
            } catch (InvalidMoveException e) {
                e.printStackTrace();
            }
        }
        return countInRow;
    }

}
