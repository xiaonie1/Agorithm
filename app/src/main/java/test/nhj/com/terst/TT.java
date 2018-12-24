package test.nhj.com.terst;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by nhj on 2018/12/6.
 */

public class TT extends FrameLayout {
    public TT(@NonNull Context context) {
        super(context);
    }

    public TT(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TT(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("@@","dispatchTouchEvent = "+event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean vg  = super.onTouchEvent(event);
        Log.i("@@","onTouchEvent = "+event.getAction()+ "   vg = "+vg);
        return vg;
    }
int i = 0;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Log.i("@@","onInterceptTouchEvent = "+event.getAction());
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                return true ;
            case MotionEvent.ACTION_MOVE:
                i++;
                if(i>5){
                    Log.i("@@","不拦截 "+event.getAction());
                    return false;
                }else{
                    return false ;
                }


            case MotionEvent.ACTION_UP:
                return false ;
        }
        return true ;
    }
}
