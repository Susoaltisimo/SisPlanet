package com.susoaltisimo.sisplanet;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class SisPlanet extends Game {

    private DefinicionLuz pantallaJuego;

    @Override
    public void create() {
        pantallaJuego = new DefinicionLuz();
        setScreen(pantallaJuego);
    }

    @Override
    public void dispose (){
        super.dispose();
        pantallaJuego.dispose();
    }
}
