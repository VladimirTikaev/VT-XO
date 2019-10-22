package com.VT.XO.models;

import com.VT.XO.models.exceptions.InvalidFieldSizeException;
import com.VT.XO.models.exceptions.InvalidMoveException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class FieldTest {

    @Test
    public void createFieldWithNormalSize() throws Exception {
        final int size = 3;
        final Field field = new Field(size);
        assertNotNull(field);
    }

    @Test
    public void createFieldWithSizeLessThenMinSize() throws Exception {
        final int minSize = 3;
        try {
            final Field field = new Field(minSize - 1);
            fail();
        }catch (InvalidFieldSizeException e){}

    }

    @Test
    public void setFigureWhenPointIsLegal() throws Exception {
        final int size = 3;
        final Field field = new Field(size);
        final Point testPoint = new Point(1,1);
        final Figure testFigure = Figure.X;
        field.setFigure(testFigure, testPoint);
        final Figure excpectedValue = testFigure;
        final Figure actualValue = field.getFigure(testPoint);
        assertEquals(excpectedValue, actualValue);

    }

    @Test
    public void setFigureWhenXCoordinateLessMinValue() throws Exception {
        final int size = 3;
        final int minValue = 0;
        final Field field = new Field(size);
        final Point testPoint = new Point(minValue - 1,1);
        final Figure testFigure = Figure.X;
        try {
            field.setFigure(testFigure, testPoint);
            fail();
        }catch (InvalidMoveException e){}

    }

    @Test
    public void setFigureWhenYCoordinateLessMinValue() throws Exception {
        final int size = 3;
        final int minValue = 0;
        final Field field = new Field(size);
        final Point testPoint = new Point(0,minValue - 1);
        final Figure testFigure = Figure.X;
        try {
            field.setFigure(testFigure, testPoint);
            fail();
        }catch (InvalidMoveException e){}

    }

    @Test
    public void setFigureWhenXAndYCoordinateLessMinValue() throws Exception {
        final int size = 3;
        final int minValue = 0;
        final Field field = new Field(size);
        final Point testPoint = new Point(minValue - 1,minValue - 1);
        final Figure testFigure = Figure.X;
        try {
            field.setFigure(testFigure, testPoint);
            fail();
        }catch (InvalidMoveException e){}

    }

    @Test
    public void setFigureWhenXCoordinateMoreMaxValue() throws Exception {
        final int size = 3;
        final int maxValue = size - 1;
        final Field field = new Field(size);
        final Point testPoint = new Point(maxValue + 1,0);
        final Figure testFigure = Figure.X;
        try {
            field.setFigure(testFigure, testPoint);
            fail();
        }catch (InvalidMoveException e){}

    }

    @Test
    public void setFigureWhenYCoordinateMoreMaxValue() throws Exception {
        final int size = 3;
        final int maxValue = size - 1;
        final Field field = new Field(size);
        final Point testPoint = new Point( 1,maxValue + 1);
        final Figure testFigure = Figure.X;
        try {
            field.setFigure(testFigure, testPoint);
            fail();
        }catch (InvalidMoveException e){}

    }

    @Test
    public void setFigureWhenYAndXCoordinateMoreMaxValue() throws Exception {
        final int size = 3;
        final int maxValue = size - 1;
        final Field field = new Field(size);
        final Point testPoint = new Point( maxValue + 1,maxValue + 1);
        final Figure testFigure = Figure.X;
        try {
            field.setFigure(testFigure, testPoint);
            fail();
        }catch (InvalidMoveException e){}

    }

    @Test
    public void getFigureWithNormalCoordinate() throws Exception {

        final int size = 3;
        final Field field = new Field(size);
        final Point point = new Point(1,1);
        final Figure actualValue = field.getFigure(point);
        assertNull(actualValue);

    }

    @Test
    public void getFigureWhenXLessMinSize() throws Exception {

        final int minSize = 0;
        final int size = 3;
        final Field field = new Field(size);
        final Point point = new Point(minSize - 1,1);
        try {
            final Figure actualValue = field.getFigure(point);
            fail();
        }catch (InvalidMoveException e){}
    }

    @Test
    public void getFigureWhenYLessMinSize() throws Exception {

        final int minSize = 0;
        final int size = 3;
        final Field field = new Field(size);
        final Point point = new Point( 1,minSize - 1);
        try {
            final Figure actualValue = field.getFigure(point);
            fail();
        }catch (InvalidMoveException e){}
    }

    @Test
    public void getFigureWhenXandYLessMinSize() throws Exception {

        final int minSize = 0;
        final int size = 3;
        final Field field = new Field(size);
        final Point point = new Point( minSize - 1,minSize - 1);
        try {
            final Figure actualValue = field.getFigure(point);
            fail();
        }catch (InvalidMoveException e){}
    }

    @Test
    public void getFigureWhenXMoreMaxSize() throws Exception {

        final int size = 3;
        final Field field = new Field(size);
        final int maxSize = size - 1;
        final Point point = new Point(maxSize + 1,1);
        try {
            final Figure actualValue = field.getFigure(point);
            fail();
        }catch (InvalidMoveException e){}
    }

    @Test
    public void getFigureWhenYMoreMaxSize() throws Exception {

        final int size = 3;
        final Field field = new Field(size);
        final int maxSize = size - 1;
        final Point point = new Point( 1,maxSize + 1);
        try {
            final Figure actualValue = field.getFigure(point);
            fail();
        }catch (InvalidMoveException e){}
    }

    @Test
    public void getFigureWhenXandYMoreMaxSize() throws Exception {

        final int size = 3;
        final Field field = new Field(size);
        final int maxSize = size - 1;
        final Point point = new Point( maxSize + 1,maxSize + 1);
        try {
            final Figure actualValue = field.getFigure(point);
            fail();
        }catch (InvalidMoveException e){}
    }


    @Test
    public void checkCoordinateWhenCoordinateValid() throws Exception {

        final int size = 3;
        final Field field = new Field(size);
        final int testCoordinate = size - 1;
        final boolean expectedValue = true;
        final boolean actualValue = field.checkCoordinate(testCoordinate);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkCoordinateWhenCoordinateLessMinCoordinate() throws Exception {

        final int size = 3;
        final int minValue = 0;
        final Field field = new Field(size);
        final int testCoordinate = minValue - 1;
        final boolean expectedValue = false;
        final boolean actualValue = field.checkCoordinate(testCoordinate);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkCoordinateWhenCoordinateMoreMaxCoordinate() throws Exception {

        final int size = 3;
        final int maxValue = size - 1;
        final Field field = new Field(size);
        final int testCoordinate = maxValue + 1;
        final boolean expectedValue = false;
        final boolean actualValue = field.checkCoordinate(testCoordinate);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkPointWhenPointValid() throws Exception {
        final int size = 3;
        final Field field = new Field(size);
        final Point testPoint = new Point(1,1);
        final boolean expectedValue = true;
        final boolean actualValue = field.checkPoint(testPoint);
        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void checkPointWhenPointNoValid() throws Exception {
        final int size = 3;
        final Field field = new Field(size);
        final Point testPoint = new Point(-1,3);
        final boolean expectedValue = false;
        final boolean actualValue = field.checkPoint(testPoint);
        assertEquals(expectedValue, actualValue);

    }

}