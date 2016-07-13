package com.pro.foru.activity.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import com.pro.foru.foru.R;


/**
 * Created by hjy on 16/6/8.
 */
public class GraphicsMultiply extends View {
    private static final int ROW_MAX = 4;   // number of samples per row

    private Bitmap mSrcB;
    private Bitmap mDstB;
    private Shader mBG;
    private Xfermode mMode = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
    public GraphicsMultiply(Context context) {
        super(context);
        mSrcB = BitmapFactory.decodeResource(getResources(), R.drawable.icon_modle);
        mDstB = BitmapFactory.decodeResource(getResources(), R.drawable.splansh);
        mBG = new BitmapShader(mSrcB,
                Shader.TileMode.REPEAT,
                Shader.TileMode.REPEAT);
        Matrix m = new Matrix();
        m.setScale(100, 100);
        mBG.setLocalMatrix(m);
    }
//
//
    public GraphicsMultiply(Context context, AttributeSet attrs, Bitmap mSrcB) {
        super(context, attrs);
//        this.mSrcB = mSrcB;
        this.mSrcB = BitmapFactory.decodeResource(getResources(), R.drawable.icon_modle);
        mDstB = BitmapFactory.decodeResource(getResources(), R.drawable.splansh);
        mBG = new BitmapShader(mSrcB,
                Shader.TileMode.REPEAT,
                Shader.TileMode.REPEAT);
        Matrix m = new Matrix();
        m.setScale(100, 100);
        mBG.setLocalMatrix(m);
    }

    public GraphicsMultiply(Context context, AttributeSet attrs, int defStyleAttr, Bitmap mSrcB) {
        super(context, attrs, defStyleAttr);
        mSrcB = BitmapFactory.decodeResource(getResources(), R.drawable.icon_modle);
        mDstB = BitmapFactory.decodeResource(getResources(), R.drawable.splansh);
        mBG = new BitmapShader(mSrcB,
                Shader.TileMode.REPEAT,
                Shader.TileMode.REPEAT);
        Matrix m = new Matrix();
        m.setScale(100, 100);
        mBG.setLocalMatrix(m);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        Paint labelP = new Paint(Paint.ANTI_ALIAS_FLAG);
        labelP.setTextAlign(Paint.Align.CENTER);

        Paint paint = new Paint();
        paint.setFilterBitmap(false);

        canvas.translate(15, 35);
  
        int x = 0;
        int y = 0;
//        for (int i = 0; i < sModes.length; i++) {
            // draw the border
            paint.setStyle(Paint.Style.STROKE);
            paint.setShader(null);
            canvas.drawRect(x - 0.5f, y - 0.5f,
                    x + mSrcB.getWidth() + 0.5f, y + mSrcB.getHeight() + 0.5f, paint);

            // draw the checker-board pattern
            paint.setStyle(Paint.Style.FILL);
            paint.setShader(mBG);
            canvas.drawRect(x, y, x + mSrcB.getWidth(), y + mSrcB.getHeight(), paint);

            // draw the src/dst example into our offscreen bitmap
            int sc = canvas.saveLayer(x, y, x + mSrcB.getWidth(), y + mSrcB.getHeight(), null,
                    Canvas.MATRIX_SAVE_FLAG |
                            Canvas.CLIP_SAVE_FLAG |
                            Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                            Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                            Canvas.CLIP_TO_LAYER_SAVE_FLAG);
            canvas.translate(x, y);
            canvas.drawBitmap(mDstB, 0, 0, paint);
            paint.setXfermode(mMode);
            canvas.drawBitmap(mSrcB, 0, 0, paint);
            paint.setXfermode(null);
            canvas.restoreToCount(sc);

            // draw the label
//                canvas.drawText(sLabels[i],
//                        x + mSrcB.getWidth() / 2, y - labelP.getTextSize() / 2, labelP);

            x += mSrcB.getWidth() + 10;

            // wrap around when we've drawn enough for one row
            if ((1 % ROW_MAX) == ROW_MAX - 1) {
                x = 0;
                y += mSrcB.getHeight() + 30;
            }
//        }
    }


}
