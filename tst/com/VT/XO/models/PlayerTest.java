package com.VT.XO.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getName() throws Exception {

        final String testValue = "Ivan";
        final Player testPlayer =  new Player.PlayerBuilder().name(testValue).build();
        final String expectedValue = testValue;
        final String actualValue = testPlayer.getName();
        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void getSurname() throws Exception {

        final String testValue = "Ivanov";
        final Player testPlayer =  new Player.PlayerBuilder().surname(testValue).build();
        final String expectedValue = testValue;
        final String actualValue = testPlayer.getSurname();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getFigure() throws Exception {

        final Figure testValue = Figure.X;
        final Player testPlayer =  new Player.PlayerBuilder().figure(testValue).build();
        final Figure expectedValue = testValue;
        final Figure actualValue = testPlayer.getFigure();
        assertEquals(expectedValue, actualValue);
    }

}