package com.susoaltisimo.sisplanet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class DefinicionLuzInicial implements Screen {
    private PerspectiveCamera camera3D = new PerspectiveCamera();
    private Model esfera;
    private ModelInstance modelInstanceEsfera;
    private ModelBatch modelBatch;


    ModelBuilder modelBuilder = new ModelBuilder();
3




    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT|GL20.GL_DEPTH_BUFFER_BIT);
        modelBatch.begin(camera3D);
        modelBatch.render(modelInstanceEsfera);
        modelBatch.end();

    }

    @Override
    public void resize(int width, int height) {
        camera3D.fieldOfView=67;
        camera3D.viewportWidth=width;
        camera3D.viewportHeight=height;
        camera3D.position.set(0f,0f,15f);
        camera3D.lookAt(0,0,0);
        camera3D.near=1;
        camera3D.far=300f;
        camera3D.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        modelInstanceEsfera.dispose();
        modelBatch.dispose();
    }
}
