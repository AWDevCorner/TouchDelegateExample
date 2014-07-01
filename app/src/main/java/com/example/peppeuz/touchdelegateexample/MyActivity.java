package com.example.peppeuz.touchdelegateexample;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MyActivity extends Activity implements View.OnClickListener{
    ImageView noTD;
    ImageView siTD;
    View parent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        noTD = (ImageView) findViewById(R.id.noTD);
        siTD = (ImageView) findViewById(R.id.siTD);
        parent = (View) siTD.getParent();
        siTD.setOnClickListener(this);
        noTD.setOnClickListener(this);
        parent.post(new Runnable() {
            public void run() {
                Rect rect = new Rect();
                siTD.getHitRect(rect);
                rect.top -= 500;
                rect.bottom += 500;
                rect.left -= 500;
                rect.right += 500;
                TouchDelegate touchDelegate = new TouchDelegate(rect,
                        siTD);
                parent.setTouchDelegate(touchDelegate);
            };
        });
    }


    @Override
    public void onClick(View view) {
         if(view.getId()==siTD.getId()) {
             Toast.makeText(this, "La potenza del TouchDelegate!", Toast.LENGTH_SHORT).show();
         }
        else
         {
             Toast.makeText(this, "Buhh! Niente TouchDelegate!?", Toast.LENGTH_SHORT).show();
         }

        }


    }

