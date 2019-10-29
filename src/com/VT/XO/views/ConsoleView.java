package com.VT.XO.views;


import com.VT.XO.controllers.CurrentMoveController;
import com.VT.XO.controllers.MoveController;
import com.VT.XO.controllers.WinnerController;
import com.VT.XO.models.Field;
import com.VT.XO.models.Figure;
import com.VT.XO.models.Game;
import com.VT.XO.models.Player;
import com.VT.XO.models.exceptions.AlreadyOccupiedException;
import com.VT.XO.models.exceptions.InvalidMoveException;

import javax.xml.soap.SAAJResult;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView implements IView {

    private CurrentMoveController currentMoveController = new CurrentMoveController();

    private WinnerController winnerController = new WinnerController();

    private MoveController moveController = new MoveController();

    private final int INDENT_LENGTH = 50;

    private final int HALF_INDENT_LENGTH = INDENT_LENGTH / 2;

    private final String HYPHEN_VIEW = " -- ";


    public void showGame(final Game game){
        System.out.println(game.getName());
    }

    @Override
    public void show(Game game) {

        final Player player1 = game.getPlayers()[0];
        final Player player2 = game.getPlayers()[1];

        final Field field = game.getField();
        final int separatorLength = (field.getSize()*4) - 2;
        final char separator = '-';

        System.out.format("%" + INDENT_LENGTH + "s\n", "Game name:" + game.getName());

        System.out.format("%"
                        + (HALF_INDENT_LENGTH
                        - separatorLength
                        + player2.getName().length()
                        + HYPHEN_VIEW.length()
                        + player2.getFigure().toString().length())
                        + "s %"
                        + (HALF_INDENT_LENGTH
                        + separatorLength
                        + HALF_INDENT_LENGTH
                        - player2.getName().length()
                        - HYPHEN_VIEW.length()
                        - player2.getFigure().toString().length())
                        + "s",
                player1.getName() + HYPHEN_VIEW + player1.getFigure(),
                player2.getName() + HYPHEN_VIEW + player2.getFigure() + "\n");


        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0) {
                System.out.format("%" + INDENT_LENGTH + "s\n", generateSeparator(separatorLength, separator));
            }
            System.out.format("%" + INDENT_LENGTH + "s\n", generateLine(field, y));
        }

    }


        public boolean makeMove(final Game game){

        CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = game.getField();
        final Figure currentFigure = currentMoveController.currentMove(field);

        WinnerController winnerController = new WinnerController();

        if(winnerController.getWinner(field) != null){
            System.out.println("Game over. Winner is " + winnerController.getWinner(field));
            return false;
        }

        if(currentFigure == null){
            System.out.println("Game over. No Winner, no move");
            return false;
        }

        System.out.println("Figure " + currentFigure + ". Input yor point");
        final Point point = askPoint();



        MoveController moveController = new MoveController();
        try {
            moveController.applyFigure(field, currentFigure, point);
        } catch (InvalidMoveException e) {
            System.out.println("Invalid point");
        }catch (AlreadyOccupiedException e){
            System.out.println("Point already occupied");
        }

        return true;
    }

    Point askPoint() {

            return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinate) {

        System.out.println("Input " + coordinate +": ");
        Scanner sc = new Scanner(System.in);

        try {
            return sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Please input digital");
            return askCoordinate(coordinate);
        }
    }


    String generateLine(final Field field, final int x){

        String resultLine = "";

        for(int y = 0; y < field.getSize(); y++){

            Figure figure = null;
            try {
                figure = field.getFigure(new Point(y, x));
            } catch (InvalidMoveException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            String leftFigureWall = (y != 0 ? "|" : "");
            String figureSymbol = String.format("%s", figure != null ? figure : " ");
            String figureCell = String.format("%s%2s ", leftFigureWall, figureSymbol);
            resultLine = resultLine.concat(figureCell);
        }

        return resultLine;
    }

    String generateSeparator(final int size, final char sep){

        String resultString = "";
        for(int i = 0; i < size; i++) {
            resultString += sep;
        }

        return resultString;
    }
}
