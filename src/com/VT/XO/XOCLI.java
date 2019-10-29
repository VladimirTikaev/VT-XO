package com.VT.XO;


import com.VT.XO.models.Field;
import com.VT.XO.models.Figure;
import com.VT.XO.models.Game;
import com.VT.XO.models.Player;
import com.VT.XO.views.ConsoleView;

import java.util.Scanner;

public class XOCLI{

    public static void main(String[] args) {


        final Player firstPlayer = new Player.
                PlayerBuilder().
                name("Ivan").
                surname("Ivanov").
                figure(Figure.X).
                build();

        final Player secondPlayer = new Player.
                PlayerBuilder().
                name("Petr").
                surname("Petrov").
                figure(Figure.O).
                build();
        final Player[] players = {firstPlayer, secondPlayer};

        System.out.println("Input field size:");
        Scanner sc = new Scanner(System.in);
        final int fieldSize = sc.nextInt();

        final Game game = new Game("XO", new Field(fieldSize), players);
        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
        while (consoleView.makeMove(game)){
            consoleView.show(game);
        }

    }

}
