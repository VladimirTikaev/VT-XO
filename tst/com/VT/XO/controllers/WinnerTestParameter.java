package com.VT.XO.controllers;


import com.VT.XO.models.Field;
import com.VT.XO.models.Figure;

public class WinnerTestParameter {

    final private Field field;

    final private Figure figure;

    public WinnerTestParameter(Field field, Figure figure) {
        this.field = field;
        this.figure = figure;
    }

    public Field getField() {
        return field;
    }

    public Figure getFigure() {
        return figure;
    }


}
