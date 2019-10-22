package com.VT.XO.models;

import org.junit.Test;

import static org.junit.Assert.*;


public class GameTest {
    @Test
    public void getName() throws Exception {

        final String gameName = "XO";
        final Game game = new Game(gameName, null, null);
        final String expectedValue = gameName;
        final String actualValue = game.getName();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getNameWhenNoGameName() throws Exception {

        final Game game = new Game(null, null, null);
        final String actualValue = game.getName();
        assertNull(actualValue);
    }

    @Test
    public void getField() throws Exception {
        final int fieldSize = 3;
        final Field gameField = new Field(fieldSize);
        final Game game = new Game(null, gameField, null);
        final Field expectedValue = gameField;
        final Field actualValue = game.getField();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getFieldWhenNoField() throws Exception {

        final Game game = new Game(null, null, null);
        final Field actualValue = game.getField();
        assertNull(actualValue);
    }

    @Test
    public void getPlayers() throws Exception {

        final Player firstPlayer = new Player.PlayerBuilder().
                name("Ivan").
                surname("Ivanov").
                figure(Figure.X).
                build();

        final Player secondPlayer = new Player.PlayerBuilder().
                name("Petr").
                surname("Petrov").
                figure(Figure.O).
                build();

        final Player[] players = {firstPlayer, secondPlayer};

        final Game gameXO = new Game(null, null, players);

        final Player[] expectedValue = players;
        final Player[] actualValue = gameXO.getPlayers();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getFieldWhenNoPlayers() throws Exception {

        final Game game = new Game(null, null, null);
        final Player[] actualValue = game.getPlayers();
        assertNull(actualValue);
    }

}