package br.com.jogo.dotsAndBoxes;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Dot {
    private ShapeRenderer shape;

    public Dot() {
        shape = new ShapeRenderer();
    }

    public void createDot(){
        shape.begin(ShapeType.Filled);

        shape.circle(10, 10, 2);

        shape.end();
    }
}
