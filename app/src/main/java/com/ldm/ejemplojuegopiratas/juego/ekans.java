package com.ldm.ejemplojuegopiratas.juego;

import java.util.ArrayList;
import java.util.List;

public class ekans {
    public static final int ARRIBA = 0;
    public static final int IZQUIERDA= 1;
    public static final int ABAJO = 2;
    public static final int DERECHA = 3;

    public List<Cuerposerpiente> partes = new ArrayList<Cuerposerpiente>();
    public int direccion;

    public ekans() {
        direccion = ARRIBA;
        partes.add(new Cuerposerpiente(5, 6));
        partes.add(new Cuerposerpiente(5, 7));
        partes.add(new Cuerposerpiente(5, 8));
    }

    public void girarIzquierda() {
        direccion += 1;
        if(direccion > DERECHA)
            direccion = ARRIBA;
    }

    public void girarDerecha() {
        direccion -= 1;
        if(direccion < ARRIBA)
            direccion = DERECHA;
    }

    public void comer() {
        Cuerposerpiente end = partes.get(partes.size()-1);
        partes.add(new Cuerposerpiente(end.x, end.y));
    }

    public void avance() {
        Cuerposerpiente serpiente = partes.get(0);

        int len = partes.size() - 1;
        for(int i = len; i > 0; i--) {
            Cuerposerpiente antes = partes.get(i-1);
            Cuerposerpiente parte = partes.get(i);
            parte.x = antes.x;
            parte.y = antes.y;
        }

        if(direccion == ARRIBA)
            serpiente.y -= 1;
        if(direccion == IZQUIERDA)
            serpiente.x -= 1;
        if(direccion == ABAJO)
            serpiente.y += 1;
        if(direccion == DERECHA)
            serpiente.x += 1;
    }

    public boolean comprobarChoque() {
        int len = partes.size();
        Cuerposerpiente serpiente = partes.get(0);
        for(int i = 1; i < len; i++) {
            Cuerposerpiente parte = partes.get(i);
            if(parte.x == serpiente.x && parte.y == serpiente.y)
                return true;
            if(serpiente.x < 0)
                return true;
            if(serpiente.x > 9)
                return true;
            if(serpiente.y < 0)
                return true;
            if(serpiente.y > 12)
                return true;
        }
        return false;
    }
}

