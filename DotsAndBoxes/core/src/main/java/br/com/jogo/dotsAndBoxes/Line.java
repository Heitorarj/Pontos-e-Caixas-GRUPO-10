package br.com.jogo.dotsAndBoxes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


public class Line extends Elements {
    private ShapeRenderer shape;
    private float keepPositionX, keepPositionY;
    private Color color;    
    
    public Line() {
        shape = new ShapeRenderer();
        keepPositionY = 0f;
        keepPositionX = 0f;
        color = Color.WHITE; 
    }

    public void createLine(float positionX, float positionX2, float positionY, float positionY2){
        setPositionX(positionX);
        keepPositionX = getPositionX();
        setPositionY(positionY);
        keepPositionY = getPositionY();

        setPositionX(positionX2);
        setPositionY(positionY2);
    }
    
    public void renderLine() {
        shape.begin(ShapeType.Line);
        shape.setColor(color);
        shape.line(keepPositionX, keepPositionY, getPositionX(), getPositionY());
        shape.end();
    }

    public void disposeLine(){
        shape.dispose();
    }
}
