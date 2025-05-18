package br.com.jogo.dotsAndBoxes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Menu {
    private String title, startText;
    private BitmapFont font;
    private float titleX, titleY, startTextX, startTextY;
    private boolean inMenu;

    public Menu() {
        this.title = "";
        this.startText = "";
        this.titleX = 0f;
        this.titleY = 0f;
        this.startTextX = 0f;
        this.startTextY = 0f;
        this.inMenu = true;
    }

    public void createMenu() {
        this.title = "Dots And Boxes";
        this.startText = "Pressione Enter para iniciar o jogo";
        this.titleX = 100f;
        this.titleY = 300f;
        this.startTextX = 100f;
        this.startTextY = 250f;

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Roboto-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 24;
        this.font = generator.generateFont(parameter);
        generator.dispose();
    }

    public void updateMenu() {
        if (inMenu && Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            inMenu = false;
        }
    }

    public void renderMenu(SpriteBatch batch) {
        if (inMenu) {
            batch.begin();
            font.setColor(Color.WHITE);
            font.getData().setScale(2);
            font.draw(batch, title, titleX, titleY);
            font.getData().setScale(1);
            font.draw(batch, startText, startTextX, startTextY);
            batch.end();
        }
    }

    public boolean isInMenu() {
        return inMenu;
    }

    public void disposeMenu() {
        font.dispose();
    }
}
