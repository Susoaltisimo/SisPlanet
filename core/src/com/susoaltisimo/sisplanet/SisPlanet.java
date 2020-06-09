package com.susoaltisimo.sisplanet;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;

import static com.badlogic.gdx.graphics.VertexAttributes.*;
import static com.badlogic.gdx.graphics.VertexAttributes.Usage.Normal;

public class SisPlanet extends ApplicationAdapter implements InputProcessor {
    //SpriteBatch batch;
    //Texture img;
    private PerspectiveCamera camera;
    private ModelBatch modelBatch;
    private ModelBuilder modelBuilder;
    private Model esfera;
    private ModelInstance modelInstance;
    private Environment environment;

    @Override
    public void create () {
        camera = new PerspectiveCamera(100,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.position.set(0f, 0f,5f);
        camera.lookAt(0f,0f,0f);
        camera.near = 0.1f;
        camera.far = 1000f;


        modelBatch = new  ModelBatch();
        modelBuilder = new ModelBuilder();
        esfera = modelBuilder.createSphere(2f, 2f, 2f, 50, 50,
                new Material(ColorAttribute.createDiffuse(Color.YELLOW)),
                Usage.Position | Normal);

        modelInstance = new ModelInstance(esfera,0,0,0);
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.8f,0.8f,0.8f,1f));

    }

    @Override
    public void resize(int width, int height) {

    }


    @Override
    public void render () {
        Gdx.gl.glViewport(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        camera.update();
        modelBatch.begin(camera);
        modelBatch.render(modelInstance, environment);
        modelBatch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose () {
        //batch.dispose();
        //img.dispose();
        modelBatch.dispose();


    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.LEFT)
            camera.rotateAround(new Vector3(0f,0f,0f),new Vector3(0f,1f,0f), 1f);
        if (keycode == Input.Keys.RIGHT)
            camera.rotateAround(new Vector3(0f,0f,0f),new Vector3(0f,1f,0f), -1f);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}