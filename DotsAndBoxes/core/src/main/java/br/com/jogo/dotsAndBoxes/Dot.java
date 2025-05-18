package br.com.jogo.dotsAndBoxes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Dot extends Elements{
    private ShapeRenderer shape;
    private float radius;
    private Color color;

    public Dot() {
        shape = new ShapeRenderer();
        radius = 0f;
        color = Color.BLACK;
    }

    public void createDot(float positionX, float positionY, float radius){
        setPositionX(positionX);
        setPositionY(positionY);

        this.radius = radius;
    }

    public void renderDot(){
        shape.begin(ShapeType.Filled);
        shape.setColor(color);

        shape.circle(getPositionX(), getPositionY(), radius);

        shape.end();
    }
    
    public void disposeDot(){
        shape.dispose();
    }
}
