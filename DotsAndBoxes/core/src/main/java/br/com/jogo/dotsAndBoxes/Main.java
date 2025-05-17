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
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
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
