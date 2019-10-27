package com.VT.XO.views;


import com.VT.XO.controllers.CurrentMoveController;
import com.VT.XO.controllers.MoveController;
import com.VT.XO.controllers.WinnerController;
import com.VT.XO.models.Field;
import com.VT.XO.models.Figure;
import com.VT.XO.models.Game;
import com.VT.XO.models.exceptions.AlreadyOccupiedException;
import com.VT.XO.models.exceptions.InvalidMoveException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView implements IView {

    private CurrentMoveController currentMoveController = new CurrentMoveController();

    private WinnerController winnerController = new WinnerController();

    private MoveController moveController = new MoveController();

    public void showGame(final Game game){
        System.out.println(game.getName());
    }

    @Override
    public void showField(Game game) {
        final Field field = game.getField();

        for(int i = 0; i < field.getSize(); i++){
            showLine(field, i);
            if(i != field.getSize() - 1){
                showSeparator((field.getSize()*4) - 2, '-');
            }
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
       // return new Point(askCoordinate("X") , askCoordinate("Y") );
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


    void showLine(final Field field, final int x){

        for(int y = 0; y < field.getSize(); y++){
            if(y != 0 ){
                System.out.print("|");
            }
            Figure figure = null;
            try {
                figure = field.getFigure(new Point(y, x));
               // figure = field.getFigure(new Point(x, y));
            } catch (InvalidMoveException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            if(figure != null){
                System.out.print(" " + figure + " ");
            }else{
                System.out.print(" " + " " + " ");
            }
        }
        System.out.println();


    }

    void showSeparator(final int size, final char sep){

        for(int i = 0; i < size; i++) {
            System.out.print(sep);
        }
        System.out.println();
    }
}
