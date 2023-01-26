package com.example.sb3;

public class RankingItem {
    String rank;
    String score, player;

    public RankingItem(String rank,String score, String player){
        this.rank=rank;
        this.score=score;
        this.player=player;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
}
