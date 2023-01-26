package com.example.sb3;

public class ScoreItem {
    String date;
    String game;
    String player1, player2;
    String player1Score, player2Score;

    public ScoreItem(String date, String game, String player1, String player2, String player1Score, String player2Score) {
        this.date = date;
        this.game = game;
        this.player1 = player1;
        this.player2 = player2;
        this.player1Score = player1Score;
        this.player2Score = player2Score;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(String player1Score) {
        this.player1Score = player1Score;
    }

    public String getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(String player2Score) {
        this.player2Score = player2Score;
    }
}
