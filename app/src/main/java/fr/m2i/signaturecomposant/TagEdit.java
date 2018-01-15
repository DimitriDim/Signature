package fr.m2i.signaturecomposant;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;



/**
 * Created by Administrateur on 15/01/2018.
 */

public class TagEdit extends AppCompatImageView {


    private int tagColor;
    private int tagWidth;

    // Déclaration des objets
    Path path;
    Paint paint;



    public TagEdit(Context context, @Nullable AttributeSet attrs) {
        super(context,attrs);

        // définir un objet Paint: ensemble des paramètres de dessin
        paint = new Paint();
        paint.setDither(true);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(30);

        //type de trait (plein, pointillé...)
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);

        //style début et fin (droit, arrondi...)
        paint.setStrokeCap(Paint.Cap.ROUND);

        // Objet pour mémoriser le tacer
        path = new Path();

        //Récupérer des valeurs définies dans le layout XML
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.TagEdit);
        tagColor = ta.getInt(R.styleable.TagEdit_tagColor,0);
        tagWidth = ta.getInt(R.styleable.TagEdit_tagWidth,1);

    }
    public void clear(){
        //efface avec un nouvel objet vide
        path = new Path();
        //force a redessin
        invalidate();

    }

    public int getTagColor() {
        return tagColor;
    }

    public void setTagColor(int tagColor) {
        this.tagColor = tagColor;
        paint.setColor(tagColor);
    }

    public int getTagWidth() {
        return tagWidth;
    }

    public void setTagWidth(int tagWidth) {
        this.tagWidth = tagWidth;
    }

    //Pour les mouvements de doigts
    public boolean onTouchEvent(MotionEvent ev) {
        float eventX = ev.getX();
        float eventY = ev.getY();
        switch (ev.getAction()) {
            //position en fonction du doigt
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                return true;
             // mouvement
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            default:
                return false;
        }
        invalidate(); // Force le redessin
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }


}
