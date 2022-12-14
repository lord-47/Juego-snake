package com.ldm.ejemplojuegopiratas.juego;

import java.util.Random;

public class Mundo {
    static final int MUNDO_ANCHO = 10;
    static final int MUNDO_ALTO = 13;
    static final int INCREMENTO_PUNTUACION = 10;
    static final float TICK_INICIAL = 0.5f;
    static final float TICK_DECREMENTO = 0.05f;
    boolean dif =true;

    public void setDif(boolean dif) {
        this.dif = dif;
    }

    public ekans ekans;
    public Comida comida;
    public boolean finalJuego = false;
    public int puntuacion = 0;

    boolean campos[][] = new boolean[MUNDO_ANCHO][MUNDO_ALTO];
    Random random = new Random();
    float tiempoTick = 0;
    static float tick = TICK_INICIAL;

    public Mundo() {
        ekans = new ekans();
        colocarComida();
    }

    private void colocarComida() {
        for (int x = 0; x < MUNDO_ANCHO; x++) {
            for (int y = 0; y < MUNDO_ALTO; y++) {
                campos[x][y] = false;
            }
        }

        int len = ekans.partes.size();
        for (int i = 0; i < len; i++) {
            Cuerposerpiente parte = ekans.partes.get(i);
            campos[parte.x][parte.y] = true;
        }

        int comidaX = random.nextInt(MUNDO_ANCHO);
        int comidaY = random.nextInt(MUNDO_ALTO);
        while (true) {
            if (campos[comidaX][comidaY] == false)
                break;
            comidaX += 1;
            if (comidaX >= MUNDO_ANCHO) {
                comidaX = 0;
                comidaY += 1;
                if (comidaY >= MUNDO_ALTO) {
                    comidaY = 0;
                }
            }
        }
        comida = new Comida(comidaX, comidaY, random.nextInt(3));
    }

    public void update(float deltaTime) {
        if (finalJuego)

            return;

        tiempoTick += deltaTime;

        while (tiempoTick > tick) {
            tiempoTick -= tick;
            ekans.avance();
            if (ekans.comprobarChoque()) {
                finalJuego = true;
                return;
            }

            Cuerposerpiente head = ekans.partes.get(0);
            if (head.x == comida.x && head.y == comida.y) {
                puntuacion += INCREMENTO_PUNTUACION;
                ekans.comer();
                if (dif){
                    ekans.comer();
                }
                if (ekans.partes.size() == MUNDO_ANCHO * MUNDO_ALTO) {
                    finalJuego = true;
                    return;
                } else {
                    colocarComida();
                }

                if (puntuacion % 100 == 0 && tick - TICK_DECREMENTO > 0) {
                    tick -= TICK_DECREMENTO;
                }
            }
        }
    }
}

