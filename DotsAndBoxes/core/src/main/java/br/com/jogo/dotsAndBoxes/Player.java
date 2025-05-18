package br.com.jogo.dotsAndBoxes;

public class Player {
    private int id, points;
    private boolean canPlay;

    public Player() {
        this.id = 0;
        this.points = 0;
        this.canPlay = true;
    }

    public Player(int id, int points, boolean canPlay) {
        this.id = id;
        this.points = points;
        this.canPlay = canPlay;
    }

    public int getId(){
        return id;
    }

    public int getPoints(){
        return points;
    }

    public void setCanPlay(boolean canPlay){
        this.canPlay = canPlay;
    }

    public boolean getCanPlay(){
        return canPlay;
    }

    public void sumPoints(){
        points += 1;
    }
}
