package com.theinvader360.scene2dtutorial.swiperace;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class MainActivity extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useGL20 = false;
        
        initialize(new MyGame(), cfg);
    }
    
    public void onBackPressed() {
        final Dialog dialog = new Dialog(this);
        dialog.setTitle("More by TheInvader360");

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        
        TableLayout tl = new TableLayout(this);
        TableRow tr1 = new TableRow(this);
        TableRow tr2 = new TableRow(this);
        
        Button b1 = new Button(this);
        b1.setText("Games");
        b1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:TheInvader360")));
                dialog.dismiss();
            }
        });
        tr1.addView(b1);

        Button b2 = new Button(this);
        b2.setText("Blog");
        b2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://theinvader360.blogspot.co.uk")));
                dialog.dismiss();
            }
        });
        tr1.addView(b2);

        Button b3 = new Button(this);
        b3.setText("Github");
        b3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://github.com/theinvader360")));
                dialog.dismiss();
            }
        });
        tr1.addView(b3);

        tl.addView(tr1);

        Button b4 = new Button(this);
        b4.setText("Facebook");
        b4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/TheInvader360")));
                dialog.dismiss();
            }
        });
        tr2.addView(b4);

        Button b5 = new Button(this);
        b5.setText("Twitter");
        b5.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://twitter.com/TheInvader360")));
                dialog.dismiss();
            }
        });
        tr2.addView(b5);

        Button b6 = new Button(this);
        b6.setText("Youtube");
        b6.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/theinvader360")));
                dialog.dismiss();
            }
        });
        tr2.addView(b6);

        tl.addView(tr2);
        
        ll.addView(tl);

        TextView tv = new TextView(this);
        tv.setText("TheInvader360 is an independent game developer making small, fun, casual games for mobile devices. Thanks for your support :)");
        tv.setPadding(4, 0, 4, 10);
        ll.addView(tv);
        
        Button b7 = new Button(this);
        b7.setText("Quit");
        b7.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	finish();
            }
        });
        ll.addView(b7);
        
        dialog.setContentView(ll);        
        dialog.show();        
    }
}
