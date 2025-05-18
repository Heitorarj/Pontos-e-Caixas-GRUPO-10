package br.com.jogo.dotsAndBoxes;

public class Square {
    private Line top, bottom, left, right;
    private boolean completed;

    Square() {
        this.top = null;
        this.bottom = null;
        this.right = null;
        this.left = null;
        this.completed = false;
    }

    Square(Line top, Line bottom, Line left, Line right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    public boolean isCompleted() {
        return top.getClicked() && bottom.getClicked() && left.getClicked() && right.getClicked();
    }

    public boolean updateSquare() {
        if (!completed && isCompleted()) {
            completed = true;
            return true;
        }

        return false;
    }

    public void render() {
        if (completed) {
            
        }
    }
}