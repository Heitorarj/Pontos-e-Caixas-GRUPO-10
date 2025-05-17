package br.com.jogo.dotsAndBoxes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Dot extends Elements{
    private ShapeRenderer shape;

    public Dot() {
        shape = new ShapeRenderer();
    }

    public void renderDot(){
        shape.begin(ShapeType.Filled);
        shape.setColor(Color.BLACK);

        shape.circle(10, 10, 2);

        shape.end();
    }
    
    public void disposeDot(){
        shape.dispose();
    }
}
