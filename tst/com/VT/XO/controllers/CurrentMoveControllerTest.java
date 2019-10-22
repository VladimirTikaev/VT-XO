package com.VT.XO.controllers;

import com.VT.XO.models.Field;
import com.VT.XO.models.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {
    @Test
    public void currentMoveWhenFieldEmpty() throws Exception {
        final Field field = new Field(3);
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Figure expectedValue = Figure.X;
        final Figure actualValue = currentMoveController.currentMove(field);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void currentMoveWhenFieldFull() throws Exception {
        final Field field = new Field(3);
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for(int i = 0; i < field.getSize(); i++){
            field.setFigure(Figure.X, new Point(i, 0));
            field.setFigure(Figure.O, new Point(i, 1));
            field.setFigure(Figure.X, new Point(i, 2));
        }
        final Figure actualValue = currentMoveController.currentMove(field);
        assertNull(actualValue);
    }

    @Test
    public void currentMoveWhenXTurn() throws Exception {
        final Field field = new Field(3);
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        field.setFigure(Figure.X, new Point( 1,1));
        field.setFigure(Figure.O, new Point( 1,2));
        final Figure expectedValue = Figure.X;
        final Figure actualValue = currentMoveController.currentMove(field);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void currentMoveWhenOTurn() throws Exception {
        final Field field = new Field(3);
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        field.setFigure(Figure.X, new Point( 1,1));
        field.setFigure(Figure.O, new Point( 1,2));
        field.setFigure(Figure.O, new Point( 1,0));
        final Figure expectedValue = Figure.O;
        final Figure actualValue = currentMoveController.currentMove(field);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void countFigureInRow() throws Exception {
        final Field field = new Field(3);
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        field.setFigure(Figure.X, new Point( 1,1));
        field.setFigure(Figure.O, new Point( 1,2));
        field.setFigure(Figure.O, new Point( 1,0));
        final int expectedValue = 3;
        final int actualValue = currentMoveController.countFigureInRow(field,1);
        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void countFigureInRowWhenNoFigure() throws Exception {
        final Field field = new Field(3);
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        field.setFigure(Figure.X, new Point( 1,1));
        field.setFigure(Figure.O, new Point( 1,2));
        field.setFigure(Figure.O, new Point( 1,0));
        final int expectedValue = 0;
        final int actualValue = currentMoveController.countFigureInRow(field,0);
        assertEquals(expectedValue, actualValue);

    }

}