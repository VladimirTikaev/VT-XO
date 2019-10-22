package com.VT.XO.models;


import com.VT.XO.models.exceptions.InvalidFieldSizeException;
import com.VT.XO.models.exceptions.InvalidMoveException;

import java.awt.*;

public class Field {

    private static final int MIN_SIZE = 3;
    private static final int MIN_COORDINATE = 0;

    private final int size;

    private final Figure[][] field;

    public Field(int size) throws InvalidFieldSizeException{
        if(size < MIN_SIZE){
            throw new InvalidFieldSizeException();
        }
        this.size = size;
        field = new Figure[size][size];
    }

    public void setFigure(final Figure figure, final Point point) throws InvalidMoveException{
        if (checkPoint(point)){
            field[point.x][point.y] = figure;
        }else {
            throw new InvalidMoveException();
        }
    }

    public Figure getFigure(final Point point) throws InvalidMoveException{
        if (checkPoint(point)){
            return field[point.x][point.y];
        }else {
            throw new InvalidMoveException();
        }
    }

    boolean checkPoint(final Point point){
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }

    boolean checkCoordinate(final int coordinate){
        return MIN_COORDINATE <= coordinate && coordinate < size;
    }
}
