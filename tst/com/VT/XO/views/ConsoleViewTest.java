package com.VT.XO.views;

import com.VT.XO.models.Field;
import com.VT.XO.models.Figure;
import com.VT.XO.models.Game;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class ConsoleViewTest {

    private Game testGame;

    private ConsoleView testCV;

    @Before
    public void initObj(){

        testGame = new Game("XO Game", new Field(3), null);
        testCV = new ConsoleView();
    }


    @Test
    public void generateLineWhenLineHaveNoFigures() throws Exception {

        final String expectedVal = "    |   |   ";
        final String actualVal = testCV.generateLine(testGame.getField(), 0);
        assertEquals(expectedVal, actualVal);
    }

    @Test
    public void generateLineWhenLineHaveFigures() throws Exception {

        testGame.getField().setFigure(Figure.X, new Point(0, 0));
        testGame.getField().setFigure(Figure.X, new Point(1, 0));
        final String expectedVal = "  X | X |   ";
        final String actualVal = testCV.generateLine(testGame.getField(), 0);
        assertEquals(expectedVal, actualVal);
    }


    @Test
    public void generateSeparator() throws Exception {

        final int size = 3;
        final char sep = '-';
        final String expectedVal = "---";
        final String actualVal = testCV.generateSeparator(size, sep);
        assertEquals(expectedVal, actualVal);

    }

    @Test
    public void generateSeparatorWhenSizeIsZero() throws Exception {

        final int size = 0;
        final char sep = '-';
        final String expectedVal = "";
        final String actualVal = testCV.generateSeparator(size, sep);
        assertEquals(expectedVal, actualVal);

    }


}