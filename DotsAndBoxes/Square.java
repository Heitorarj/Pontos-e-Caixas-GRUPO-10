package br.com.jogo.dotsAndBoxes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Square {
    private Line top, bottom, left, right;
    private boolean completed;
    private int ownerId;

    public Square(Line top, Line bottom, Line left, Line right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    public boolean isCompleted() {
        return top.getClicked() && bottom.getClicked() && left.getClicked() && right.getClicked();
    }

    public boolean updateSquare(Player humanPlayer, Player computerPlayer) {
        if (!completed && isCompleted()) {
            completed = true;
            if (computerPlayer.getCanPlay()) {
                computerPlayer.addPoint();
                computerPlayer.setScored(true);
                ownerId = computerPlayer.getId();
            } else if (humanPlayer.getCanPlay()) {
                humanPlayer.addPoint();
                humanPlayer.setScored(true);
                ownerId = humanPlayer.getId();
            }
            return true;
        }
        return false;
    }

    public void render(ShapeRenderer shape) {
        if (completed) {
            float positionX = left.getPositionX() + 10f;
            float positionY = bottom.getPositionY() + 5f;
            float width = right.getPositionX() - left.getPositionX() - 20f;
            float height = top.getPositionY() - bottom.getPositionY() - 20f;

            shape.begin(ShapeType.Filled);
            if (ownerId == 1) {
                shape.setColor(Color.BLUE);
            } else if (ownerId == 2) {
                shape.setColor(Color.RED);
            } else {
                shape.setColor(Color.GRAY);
            }
            shape.rect(positionX, positionY, width, height);
            shape.end();
        }
    }
}
