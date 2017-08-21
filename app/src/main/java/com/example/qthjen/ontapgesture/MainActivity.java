package com.example.qthjen.ontapgesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    TextView tv;
    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.image);
        tv = (TextView) findViewById(R.id.tv);

        gestureDetector = new GestureDetector(this, new MyGesture());
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });

    }

    class MyGesture extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {  // chạm lần đầu
            tv.setText("onDown: " + e.toString());
            return super.onDown(e);
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) { // chạm lâu hơn chút
            tv.setText("onSingleTapUp: " + e.toString());
            return super.onSingleTapUp(e);
        }

        @Override
        public void onShowPress(MotionEvent e) { // chạm lâu hơn nữa
            tv.setText("onShowPress: " + e.toString());
            super.onShowPress(e);
        }

        @Override
        public void onLongPress(MotionEvent e) { // chạm lâu hơn nữa 
            tv.setText("onLongPress: " + e.toString());
            super.onLongPress(e);
        }

    }

}
