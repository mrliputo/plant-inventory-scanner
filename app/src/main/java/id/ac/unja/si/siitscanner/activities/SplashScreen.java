package id.ac.unja.si.siitscanner.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import id.ac.unja.si.siitscanner.R;

public class SplashScreen extends AppCompatActivity {
    TextView textView, textView2;
    Typeface helvetica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        helvetica = Typeface.createFromAsset(getAssets(), "fonts/helvetica.ttf");

        textView.setTypeface(helvetica);
        textView2.setTypeface(helvetica);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, HomeActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        }, 1500);
    }
}
