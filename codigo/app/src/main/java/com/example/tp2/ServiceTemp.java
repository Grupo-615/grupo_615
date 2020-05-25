package com.example.tp2;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import static java.lang.Thread.sleep;

public class ServiceTemp extends IntentService {
    private int tiempo = 0;
    private int tiempoEnPausa = 0;
    private int inicioPausa;
    private  static  boolean termino = false;
    private int milisegundos;
    private int tiempoInicial;
    private static  boolean play = true;


    public ServiceTemp() {
        super("ServiceTemp");
    }
    protected static void setearPlay(boolean nPlay) {
        play=nPlay;
    }


        @Override
    protected void onHandleIntent(Intent intent) {
        tiempoInicial = (int) System.currentTimeMillis();
        while (!termino) {
            Intent i = new Intent();

            int tiempoPausaActual = 0;
            if (!play)
                inicioPausa = (int) System.currentTimeMillis();
            while (!play) {
                int actual = (int) System.currentTimeMillis();
                tiempoPausaActual = actual - inicioPausa;
            }
            tiempoEnPausa += tiempoPausaActual;
            calcularTiempo();
            i.putExtra("cambioTiempo", tiempo);
            i.setAction("com.example.tp2.TIEMPO");
            sendBroadcast(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private void calcularTiempo() {
        milisegundos = (int) System.currentTimeMillis();
        this.tiempo = (milisegundos - tiempoInicial - tiempoEnPausa) / 1000;

    }
    public static void terminar(){
        Log.i("verTermina",String.valueOf(termino));
        termino=true;
    }
    }


