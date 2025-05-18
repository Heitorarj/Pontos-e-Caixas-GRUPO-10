package br.com.jogo.dotsAndBoxes;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Map map;
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        map = new Map();
        map.createMap();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.36f, 0.45f, 0.49f, 1f); //93, 115, 126
        batch.begin();
        map.renderMap();


        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        map.disposeMap();

    }
}
