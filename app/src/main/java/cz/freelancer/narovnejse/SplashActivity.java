package cz.freelancer.narovnejse;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;
    private static int splashTimeout=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen2);
        logo= (ImageView)findViewById(R.id.logo);

        //prechod//
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);
               finish();
            }
        },splashTimeout);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mysplashanimation);
        logo.startAnimation(myanim);
    }
}
