package br.com.jogo.dotsAndBoxes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Square {
    private Line top, bottom, left, right;
    private boolean completed;

    Square() {
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

    public void render(ShapeRenderer shape) {
        if (completed) {
            shape.begin(ShapeType.Filled);
            shape.setColor(Color.BLACK);
            shape.rect(left.getPositionX(), bottom.getPositionY(), 70, 50);
            shape.end();
        }
    }

}