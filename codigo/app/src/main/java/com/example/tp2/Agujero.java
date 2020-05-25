package com.example.tp2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class Agujero extends View {
    Paint paint;
    float centroX;
    float centroY;
    float radio;
    public Agujero(Context context) {
        super(context);
        paint=new Paint();

    }
    public void onDraw(Canvas canvas){
        radio=getWidth()/14+5;
        centroX=2*radio-10;
        centroY=getHeight()-2*radio;
        canvas.drawCircle(centroX,centroY,radio,paint);

    }

    public boolean isCovered(float pelotaX,float pelotaY){
        float minimoX=this.centroX-5;
        float minimoY=this.centroY-5;
        float maximoX=this.centroX+5;
        float maximoY=this.centroY+5;
        Log.i("pminimoX",String.valueOf(minimoX));
        Log.i("pmCentroPelotaX",String.valueOf(pelotaX));
        Log.i("pmaximoX",String.valueOf(maximoX));
        Log.i("pminimoY",String.valueOf(minimoY));
        Log.i("pmCentroPelotaY",String.valueOf(pelotaY));
        Log.i("pmaximoY",String.valueOf(maximoY));


        if(pelotaX>minimoX && pelotaX<maximoX && pelotaY>minimoY && pelotaY<maximoY ) {
            return true;
        }
            return false;

    }
}