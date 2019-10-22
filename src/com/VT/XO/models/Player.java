package com.VT.XO.models;


public class Player {

    private final String name;
    private final String surname;
    private final Figure figure;

    private Player(PlayerBuilder playerBuilder){
        this.name = playerBuilder.getName();
        this.surname = playerBuilder.getSurname();
        this.figure = playerBuilder.getFigure();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Figure getFigure() {
        return figure;
    }

    public static class PlayerBuilder{

        private String name;
        private String surname;
        private Figure figure;



        public PlayerBuilder name(final String name){
            this.name = name;
            return this;
        }

        public PlayerBuilder surname(final String surname){
            this.surname = surname;
            return this;
        }

        public PlayerBuilder figure(final Figure figure){
            this.figure = figure;
            return this;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public Figure getFigure() {
            return figure;
        }

        public Player build(){
            return new Player(this);

        }

    }

}
