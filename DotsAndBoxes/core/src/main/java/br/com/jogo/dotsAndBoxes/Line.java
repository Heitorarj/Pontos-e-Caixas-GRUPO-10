package br.com.jogo.dotsAndBoxes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


public class Line {
    private ShapeRenderer shape;
    private float x1, y1, x2, y2;
    private Color color;    
    
    public Line(float x1, float y1, float x2, float y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        shape = new ShapeRenderer();
        color = Color.BLACK; 
    }
    
    public void renderLine() {
        shape.begin(ShapeType.Line);
        shape.setColor(color);
        shape.line(x1, y1, x2, y2);
        shape.end();
    }
}
