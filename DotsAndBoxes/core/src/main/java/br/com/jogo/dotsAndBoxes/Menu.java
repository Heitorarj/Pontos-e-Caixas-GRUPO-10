package br.com.jogo.dotsAndBoxes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Menu {
    private String title = "Dots and Boxes";
    private String startText = "Pressione Enter para iniciar o jogo";
    private float titleX = 100;
    private float titleY = 300;
    private float startTextX = 100;
    private float startTextY = 250;

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(50, 200, 400, 200);
        shapeRenderer.end();
    }

    public void renderText(com.badlogic.gdx.graphics.g2d.BitmapFont font, com.badlogic.gdx.graphics.g2d.SpriteBatch batch) {
        batch.begin();
        font.setColor(Color.WHITE);
        font.getData().setScale(2);
        font.draw(batch, title, titleX, titleY);
        font.getData().setScale(1);
        font.draw(batch, startText, startTextX, startTextY);
        batch.end();
    }
}//
