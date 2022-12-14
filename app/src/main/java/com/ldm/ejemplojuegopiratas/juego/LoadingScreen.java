package com.ldm.ejemplojuegopiratas.juego;

import com.ldm.ejemplojuegopiratas.Juego;
import com.ldm.ejemplojuegopiratas.Graficos;
import com.ldm.ejemplojuegopiratas.Pantalla;
import com.ldm.ejemplojuegopiratas.Graficos.PixmapFormat;

public class LoadingScreen extends Pantalla{
    public LoadingScreen(Juego juego) {
        super(juego);
    }

    @Override
    public void update(float deltaTime) {
        Graficos g = juego.getGraphics();
        Assets.fondo = g.newPixmap("fondo.png", PixmapFormat.RGB565);
        Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444);
        Assets.menuprincipal = g.newPixmap("menuprincipal.png", PixmapFormat.ARGB4444);
        Assets.botones = g.newPixmap("botones.png", PixmapFormat.ARGB4444);
        Assets.ayuda1 = g.newPixmap("ayuda1.png", PixmapFormat.ARGB4444);
        Assets.ayuda2 = g.newPixmap("ayuda2.png", PixmapFormat.ARGB4444);
        Assets.ayuda3 = g.newPixmap("ayuda3.png", PixmapFormat.ARGB4444);
        Assets.numeros = g.newPixmap("numeros.png", PixmapFormat.ARGB4444);
        Assets.preparado = g.newPixmap("preparado.png", PixmapFormat.ARGB4444);
        Assets.menupausa = g.newPixmap("menupausa.png", PixmapFormat.ARGB4444);
        Assets.finjuego = g.newPixmap("finjuego.png", PixmapFormat.ARGB4444);
        Assets.serpientearriba = g.newPixmap("serpientearriba.png", PixmapFormat.ARGB4444);
        Assets.serpienteizquierda = g.newPixmap("serpienteizq.png", PixmapFormat.ARGB4444);
        Assets.serpienteabajo = g.newPixmap("serpienteabajo.png", PixmapFormat.ARGB4444);
        Assets.serpientederecha = g.newPixmap("serpienteder.png", PixmapFormat.ARGB4444);
        Assets.cuerpo = g.newPixmap("cuerpo.png", PixmapFormat.ARGB4444);
        Assets.comida1 = g.newPixmap("frutas1.png", PixmapFormat.ARGB4444);
        Assets.comida2 = g.newPixmap("frutas2.png", PixmapFormat.ARGB4444);
        Assets.comida3 = g.newPixmap("frutas3.png", PixmapFormat.ARGB4444);
        Assets.facil = g.newPixmap("facil.png", PixmapFormat.ARGB4444);
        Assets.dificil = g.newPixmap("dificil.png", PixmapFormat.ARGB4444);
        Assets.pulsar = juego.getAudio().nuevoSonido("pulsar.ogg");
        Assets.ataque = juego.getAudio().nuevoSonido("ataque.ogg");
        Assets.derrota = juego.getAudio().nuevoSonido("derrota.ogg");

        Configuraciones.cargar(juego.getFileIO());
        juego.setScreen(new MainMenuScreen(juego));
    }

    @Override
    public void present(float deltaTime) {

    }

    @Override
    public void pause() {

    }


    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}