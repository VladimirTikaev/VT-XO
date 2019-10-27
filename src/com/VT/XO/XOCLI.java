package com.VT.XO;


import com.VT.XO.models.Field;
import com.VT.XO.models.Figure;
import com.VT.XO.models.Game;
import com.VT.XO.models.Player;
import com.VT.XO.views.ConsoleView;

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
                figure(Figure.X).
                build();
        final Player[] players = {firstPlayer, secondPlayer};

        final Game game = new Game("XO", new Field(4), players);
        final ConsoleView consoleView = new ConsoleView();
        consoleView.showGame(game);

        while (consoleView.makeMove(game)){
            consoleView.showField(game);
        }

    }

}
