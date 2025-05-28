package br.com.jogo.dotsAndBoxes;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Map map;
    private Menu menu;
    private MenuFinal menuFinal;
    private BitmapFont font;
    private boolean menuFinalCreated = false;
    private Music music;

    private void createMusic() {
        music = Gdx.audio.newMusic(Gdx.files.internal("Juhani Junkala [Chiptune Adventures] 1. Stage 1.wav"));
        music.setLooping(true);
        music.setVolume(0.25f);
        music.play();
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        map = new Map();
        map.createMap();
        menu = new Menu();
        menu.createMenu();
        menuFinal = new MenuFinal();
        font = new BitmapFont();
        createMusic();
        initializeFont();
    }

    private void initializeFont() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Roboto-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 24;
        this.font = generator.generateFont(parameter);
        generator.dispose();

        font.setColor(Color.BROWN);
        font.getData().setScale(1f);
    }

    private void showPoints(){
        float humanPointsX = 50f;
        float humanPointsY = 500f;
        float computerPointsX = 450f;
        float computerPointsY = 500f;

        font.draw(batch, "Jogador 1 (Você): "+ map.getHumanPlayerPoints(), humanPointsX, humanPointsY);
        font.draw(batch, "Jogador 2 (Computador): "+ map.getComputerPlayerPoints(), computerPointsX, computerPointsY);
    }
    
    public void update() {
        map.updateMap();
    }
    
    @Override
    public void render() {
        ScreenUtils.clear(0.99f, 0.94f, 0.84f, 1f);
        update();
        
        if (menu.isInMenu()) {
            menu.updateMenu(menuFinal);
            menu.renderMenu(batch);
        } else if (!map.isGameOver()){
            map.renderMap();
            batch.begin();
            showPoints();
            batch.end();
        } else if (map.isGameOver()) {
            if (!menuFinalCreated) {
                menuFinal.createMenuFinal(map);
                menuFinalCreated = true;
            }
            menuFinal.updateMenuFinal(map, menu);
            menuFinal.renderMenuFinal(batch);
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        menu.disposeMenu();
        menuFinal.disposeMenuFinal();
        map.disposeMap();
        music.dispose();
    }

}
