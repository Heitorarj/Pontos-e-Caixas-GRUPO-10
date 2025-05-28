package br.com.jogo.dotsAndBoxes;

public class Player {
    private int id, points;
    private boolean canPlay, scored;

    public Player() {
        this.id = 0;
        this.points = 0;
        this.canPlay = true;
        this.scored = false;
    }

    public Player(int id, int points, boolean canPlay) {
        this.id = id;
        this.points = points;
        this.canPlay = canPlay;
        this.scored = false;
    }

    public int getId() {
        return id;
    }

    public int getPoints() {
        return points;
    }

    public void setCanPlay(boolean canPlay) {
        this.canPlay = canPlay;
    }

    public boolean getCanPlay() {
        return canPlay;
    }

    public void addPoint() {
        points += 1;
    }

    public boolean isScored() {
        return scored;
    }

    public void setScored(boolean scored) {
        this.scored = scored;
    }

    public boolean getScored() {
        return scored;
    }

    public void resetPlayer(int id, boolean canPlay) {
        this.id = id;
        this.points = 0;
        this.canPlay = canPlay;
        this.scored = false;
    }
}
