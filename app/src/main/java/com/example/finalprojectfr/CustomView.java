package com.example.finalprojectfr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CustomView  extends View{
    private List<Point> points = new ArrayList<>();

    public CustomView(Context context, AttributeSet attr) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas){

        canvas.drawColor(Color.rgb(32,32,32));

        for(Point p : points){
            Paint paint = new Paint();
            paint.setColor(Color.rgb((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));
            canvas.drawCircle(p.x, p.y, 50, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        points.add(new Point((int)event.getX(), (int)event.getY()));
        invalidate();
        return true;
    }
}
