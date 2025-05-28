package br.com.jogo.dotsAndBoxes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class MenuFinal {
    private String title, restartText, winner;
    private BitmapFont font;
    private float titleX, titleY, restartTextX, restartTextY, winnerX, winnerY;
    private boolean inMenuFinal;

    public MenuFinal() {
        this.title = "";
        this.restartText = "";
        this.titleX = 0f;
        this.titleY = 0f;
        this.restartTextX = 0f;
        this.restartTextY = 0f;
        this.winnerX = 0f;
        this.winnerY = 0f;
        this.inMenuFinal = true;
    }

    public String getWinner(int winnerId) {
        if (winnerId == 1) {
            return "Você venceu! Parabéns!";
        } else if (winnerId == 2) {
            return "O computador venceu! Tente novamente!";
        } else {
            return "Empate! Ninguém venceu!";
        }
    }

    public void createMenuFinal(Map map) {
        this.title = "FIM DE JOGO!";
        this.restartText = "Pressione 'R' para reiniciar o jogo.";
        this.winner = getWinner(map.getWinnerId());
        this.titleX = 100f;
        this.titleY = 400f;
        this.restartTextX = 100f;
        this.restartTextY = 200f;
        this.winnerX = 100f;
        this.winnerY = 300f;

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Roboto-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 24;
        this.font = generator.generateFont(parameter);
        generator.dispose();
    }

    public void updateMenuFinal(Map map, Menu menu) {
        if (inMenuFinal && Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            map.resetMap();
            menu.setInMenu(true);
            inMenuFinal = false;
        }
    }

    public void renderMenuFinal(SpriteBatch batch) {
        if (inMenuFinal) {
            batch.begin();
            font.setColor(Color.BROWN);
            font.getData().setScale(3f);
            font.draw(batch, title, titleX, titleY);
            font.getData().setScale(1.5f);
            font.draw(batch, winner, winnerX, winnerY);
            font.getData().setScale(1f);
            font.draw(batch, restartText, restartTextX, restartTextY);
            batch.end();
        }
    }

    public void setInMenuFinal(boolean inMenuFinal) {
        this.inMenuFinal = inMenuFinal;
    }

    public boolean isInMenuFinal() {
        return inMenuFinal;
    }

    public void disposeMenuFinal() {
        font.dispose();
    }
}
