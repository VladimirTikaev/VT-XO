package com.VT.XO.controllers;

import com.VT.XO.models.Field;
import com.VT.XO.models.Figure;
import com.VT.XO.models.exceptions.AlreadyOccupiedException;
import com.VT.XO.models.exceptions.InvalidMoveException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class MoveControllerTest {
    @Test
    public void applyFigureWhenValidPoint() throws Exception {

        final MoveController testMoveController = new MoveController();
        final Field  testField = new Field(3);
        final Figure testFigure = Figure.X;
        final Point testPoint = new Point(1,1);
        testMoveController.applyFigure(testField,testFigure, testPoint);
        final Figure expectedValue = testFigure;
        final Figure actualValue = testField.getFigure(testPoint);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void applyFigureWhenInvalidPoint() throws Exception {

        final MoveController testMoveController = new MoveController();
        final Field  testField = new Field(3);
        final Figure testFigure = Figure.X;
        final Point testPoint = new Point(-1,1);
        try {
            testMoveController.applyFigure(testField,testFigure, testPoint);
            fail();
        }catch (InvalidMoveException e){}
    }

    @Test
    public void applyFigureWhenOccupiedPoint() throws Exception {

        final MoveController testMoveController = new MoveController();
        final Field  testField = new Field(3);
        final Figure testFigure = Figure.X;
        final Point testPoint = new Point(1,1);
        testField.setFigure(testFigure, testPoint);
        try {
            testMoveController.applyFigure(testField,testFigure, testPoint);
            fail();
        }catch (AlreadyOccupiedException e){}
    }

}