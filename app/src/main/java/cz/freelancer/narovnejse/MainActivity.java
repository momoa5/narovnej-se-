package cz.freelancer.narovnejse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Animation anim_image_chlapik, anim_image_pater,anim_btn_oaplikaci,anim_btn_cviceni,anim_btn_nastaveni;
    LinearLayout chlapik, pater;
    Button oaplikaci, cviceni, nastaveni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chlapik = findViewById(R.id.chlapik);
        pater = findViewById(R.id.pater);
        oaplikaci = findViewById(R.id.btn_oaplikaci);
        cviceni = findViewById(R.id.btn_cviceni);
        nastaveni = findViewById(R.id.btn_nastaveni);

        anim_image_chlapik = AnimationUtils.loadAnimation(this, R.anim.anim_image_chlapik);
        anim_image_pater = AnimationUtils.loadAnimation(this,R.anim.anim_image_pater);
        anim_btn_oaplikaci = AnimationUtils.loadAnimation(this,R.anim.anim_btn_oaplikaci);
        anim_btn_cviceni = AnimationUtils.loadAnimation(this,R.anim.anim_btn_cviceni);
        anim_btn_nastaveni = AnimationUtils.loadAnimation(this,R.anim.anim_btn_nastaveni);

        chlapik.startAnimation(anim_image_chlapik);
        pater.startAnimation(anim_image_pater);
        oaplikaci.startAnimation(anim_btn_oaplikaci);
        cviceni.startAnimation(anim_btn_cviceni);
        nastaveni.startAnimation(anim_btn_nastaveni);



        //přechody na další layouty
        oaplikaci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, OaplikaciActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);

            }
        });

        cviceni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent (MainActivity.this, CviceniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        nastaveni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent (MainActivity.this, NastaveniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        ;









    }
}