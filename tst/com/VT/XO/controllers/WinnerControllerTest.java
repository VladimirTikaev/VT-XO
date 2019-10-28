package com.VT.XO.controllers;

import com.VT.XO.models.Field;
import com.VT.XO.models.Figure;
import com.VT.XO.models.exceptions.InvalidMoveException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class WinnerControllerTest {

    final Field field;

    final Figure figure;


    public WinnerControllerTest(WinnerTestParameter winnerTestParameter) {
        this.field = winnerTestParameter.getField();
        this.figure = winnerTestParameter.getFigure();
    }


    private static Field[] createInitField(final int size){

        final int countCase = 5;
        Field[] arrField = new Field[countCase];

        int fieldSize = size;
        for(int i = 0; i < arrField.length; i++){
            arrField[i] = new Field(fieldSize);
        }

        for(int i = 0; i < fieldSize; i++){
            try {
                arrField[1].setFigure(Figure.X, new Point(0, i));
                arrField[2].setFigure(Figure.X, new Point(i, 0));
                arrField[3].setFigure(Figure.X, new Point(i, i));
                arrField[4].setFigure(Figure.X, new Point(i, (fieldSize - i) - 1));
            } catch (InvalidMoveException e) {
                e.printStackTrace();
            }

        }

        return arrField;

    }

    @Parameterized.Parameters
    public static Collection fields(){

        ArrayList<WinnerTestParameter> parArr = new ArrayList<>();

        final Field[][] bigFieldArr = new Field[10][];

        for(int i = 0; i < 8; i++){
            bigFieldArr[i] = createInitField(i + 3);
            parArr.add(new WinnerTestParameter(bigFieldArr[i][0], null));
            parArr.add(new WinnerTestParameter(bigFieldArr[i][1], Figure.X));
            parArr.add(new WinnerTestParameter(bigFieldArr[i][2], Figure.X));
            parArr.add(new WinnerTestParameter(bigFieldArr[i][3], Figure.X));
            parArr.add(new WinnerTestParameter(bigFieldArr[i][4], Figure.X));
        }

        return parArr;

    }

    @Test
    public void getWinner() throws Exception {

        final WinnerController winnerController = new WinnerController();
        final Field testField = field;
        final Figure expectedValue = figure;
        final Figure actualValue = winnerController.getWinner(testField);
        assertEquals(expectedValue, actualValue);

    }



}