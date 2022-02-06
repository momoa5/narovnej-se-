package cz.freelancer.narovnejse;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NacosidatpozorActivity extends AppCompatActivity {

LinearLayout inLinear3;
CardView cardViewspravnedrzenitela,cardViewspravnedrzenitela2,cardViewspravnedrzenitela3,cardViewspravnedrzenitela4,cardViewspravnedrzenitela5,
        cardViewspravnedrzenitela6,cardViewspravnedrzenitela7;
Animation anim_lin_lay_semicircle,anim_grid_chuze,anim_grid_drepovani,anim_grid_jizda,anim_grid_lezeni,anim_grid_pracespc,anim_grid_sezeni,anim_grid_zvedani;
Button previous;
ImageView danger_pic,danger_pic2,danger_pic3,danger_pic4,danger_pic5,danger_pic6,danger_pic7,danger_pic8,danger_pic9,danger_pic10,danger_pic11,danger_pic12,danger_pic13,danger_pic14;
TextView text_posture,text_posture2,text_posture3,text_posture4,text_posture5,text_posture6,text_posture7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nacosidatpozor);


        inLinear3 = findViewById(R.id.inLinear3);
        previous = findViewById(R.id.previous);
        cardViewspravnedrzenitela = findViewById(R.id.cardViewspravnedrzenitela);
        cardViewspravnedrzenitela2 = findViewById(R.id.cardViewspravnedrzenitela2);
        cardViewspravnedrzenitela3 = findViewById(R.id.cardViewspravnedrzenitela3);
        cardViewspravnedrzenitela4 = findViewById(R.id.cardViewspravnedrzenitela4);
        cardViewspravnedrzenitela5 = findViewById(R.id.cardViewspravnedrzenitela5);
        cardViewspravnedrzenitela6 = findViewById(R.id.cardViewspravnedrzenitela6);
        cardViewspravnedrzenitela7 = findViewById(R.id.cardViewspravnedrzenitela7);
        //
        danger_pic = findViewById(R.id.danger_pic);
        danger_pic2 = findViewById(R.id.danger_pic2);
        danger_pic3 = findViewById(R.id.danger_pic3);
        danger_pic4 = findViewById(R.id.danger_pic4);
        danger_pic5 = findViewById(R.id.danger_pic5);
        danger_pic6 = findViewById(R.id.danger_pic6);
        danger_pic7 = findViewById(R.id.danger_pic7);
        danger_pic8 = findViewById(R.id.danger_pic8);
        danger_pic9 = findViewById(R.id.danger_pic9);
        danger_pic10 = findViewById(R.id.danger_pic10);
        danger_pic11 = findViewById(R.id.danger_pic11);
        danger_pic12 = findViewById(R.id.danger_pic12);
        danger_pic13 = findViewById(R.id.danger_pic13);
        danger_pic14 = findViewById(R.id.danger_pic14);
        //
        text_posture = findViewById(R.id.text_posture);
        text_posture2 = findViewById(R.id.text_posture2);
        text_posture3 = findViewById(R.id.text_posture3);
        text_posture4 = findViewById(R.id.text_posture4);
        text_posture5 = findViewById(R.id.text_posture5);
        text_posture6 = findViewById(R.id.text_posture6);
        text_posture7 = findViewById(R.id.text_posture7);



        anim_lin_lay_semicircle = AnimationUtils.loadAnimation(this,R.anim.anim_lin_lay_semicircle);
        anim_grid_chuze = AnimationUtils.loadAnimation(this, R.anim.anim_grid_chuze);
        anim_grid_drepovani = AnimationUtils.loadAnimation(this, R.anim.anim_grid_drepovani);
        anim_grid_jizda = AnimationUtils.loadAnimation(this, R.anim.anim_grid_jizda);
        anim_grid_lezeni = AnimationUtils.loadAnimation(this, R.anim.anim_grid_lezeni);
        anim_grid_pracespc = AnimationUtils.loadAnimation(this, R.anim.anim_grid_pracespc);
        anim_grid_sezeni = AnimationUtils.loadAnimation(this, R.anim.anim_grid_sezeni);
        anim_grid_zvedani = AnimationUtils.loadAnimation(this, R.anim.anim_grid_zvedani);

        inLinear3.startAnimation(anim_lin_lay_semicircle);
        cardViewspravnedrzenitela.startAnimation(anim_grid_chuze);
        cardViewspravnedrzenitela2.startAnimation(anim_grid_drepovani);
        cardViewspravnedrzenitela3.startAnimation(anim_grid_zvedani);
        cardViewspravnedrzenitela4.startAnimation(anim_grid_pracespc);
        cardViewspravnedrzenitela5.startAnimation(anim_grid_jizda);
        cardViewspravnedrzenitela6.startAnimation(anim_grid_sezeni);
        cardViewspravnedrzenitela7.startAnimation(anim_grid_lezeni);


        /*1)PODMÍNKA chuze*/
        if (Build.VERSION.SDK_INT >= 21) {

            /*1)chuze*/
            cardViewspravnedrzenitela.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sharedIntent = new Intent(NacosidatpozorActivity.this, Nacosi_ChuzeActivity.class);

                    Pair[] pairs = new Pair[3];
                    pairs[0] = new Pair<View, String>(danger_pic, "imageTransition");
                    pairs[1] = new Pair<View, String>(danger_pic2, "image2Transition");
                    pairs[2] = new Pair<View, String>(text_posture, "descTransition");

                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(NacosidatpozorActivity.this, pairs);
                    startActivity(sharedIntent, options.toBundle());
                }
            });


        } else {

            cardViewspravnedrzenitela.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a = new Intent(NacosidatpozorActivity.this, Nacosi_ChuzeActivity.class);
                    a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(a);
                }
            });
        }







        /*2)PODMÍNKA drepy*/
        if (Build.VERSION.SDK_INT >= 21) {

            /*2)drepy*/
            cardViewspravnedrzenitela2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sharedIntent = new Intent(NacosidatpozorActivity.this, Nacosi_DrepovaniActivity.class);

                    Pair[] pairs = new Pair[3];
                    pairs[0] = new Pair<View, String>(danger_pic3, "imageTransition");
                    pairs[1] = new Pair<View, String>(danger_pic4, "image2Transition");
                    pairs[2] = new Pair<View, String>(text_posture2, "descTransition");

                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(NacosidatpozorActivity.this, pairs);
                    startActivity(sharedIntent, options.toBundle());
                }
            });

        }else {

            cardViewspravnedrzenitela2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a = new Intent(NacosidatpozorActivity.this, Nacosi_DrepovaniActivity.class);
                    a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(a);
                }
            });

        }



        /*3)PODMÍNKA zvedani*/
        if (Build.VERSION.SDK_INT >= 21) {

            /*3)zvedani*/
            cardViewspravnedrzenitela3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sharedIntent = new Intent(NacosidatpozorActivity.this, Nacosi_ZvedaniActivity.class);

                    Pair[] pairs = new Pair[3];
                    pairs[0] = new Pair<View, String>(danger_pic5, "imageTransition");
                    pairs[1] = new Pair<View, String>(danger_pic6, "image2Transition");
                    pairs[2] = new Pair<View, String>(text_posture3, "descTransition");

                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(NacosidatpozorActivity.this, pairs);
                    startActivity(sharedIntent, options.toBundle());
                }
            });

        }else{

            cardViewspravnedrzenitela3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a = new Intent(NacosidatpozorActivity.this, Nacosi_ZvedaniActivity.class);
                    a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(a);
                }
            });

        }




        /*4)PODMÍNKA PC*/
        if (Build.VERSION.SDK_INT >= 21) {

            /*4)PC*/
            cardViewspravnedrzenitela4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sharedIntent = new Intent(NacosidatpozorActivity.this, Nacosi_PcActivity.class);

                    Pair[] pairs = new Pair[3];
                    pairs[0] = new Pair<View, String>(danger_pic7, "imageTransition");
                    pairs[1] = new Pair<View, String>(danger_pic8, "image2Transition");
                    pairs[2] = new Pair<View, String>(text_posture4, "descTransition");

                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(NacosidatpozorActivity.this, pairs);
                    startActivity(sharedIntent, options.toBundle());
                }
            });

        }else{
            cardViewspravnedrzenitela4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a = new Intent(NacosidatpozorActivity.this, Nacosi_PcActivity.class);
                    a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(a);
                }
            });
        }





        /*5)PODMÍNKA CAR*/
        if (Build.VERSION.SDK_INT >= 21) {

            /*5)CAR*/
            cardViewspravnedrzenitela5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sharedIntent = new Intent(NacosidatpozorActivity.this, Nacosi_CarActivity.class);

                    Pair[] pairs = new Pair[3];
                    pairs[0] = new Pair<View, String>(danger_pic9, "imageTransition");
                    pairs[1] = new Pair<View, String>(danger_pic10, "image2Transition");
                    pairs[2] = new Pair<View, String>(text_posture5, "descTransition");

                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(NacosidatpozorActivity.this, pairs);
                    startActivity(sharedIntent, options.toBundle());
                }
            });
        }else{
            cardViewspravnedrzenitela5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a = new Intent(NacosidatpozorActivity.this, Nacosi_CarActivity.class);
                    a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(a);
                }
            });
        }





        /*6)PODMÍNKA sezení*/
        if (Build.VERSION.SDK_INT >= 21) {
            /*6)sezení*/
            cardViewspravnedrzenitela6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sharedIntent = new Intent(NacosidatpozorActivity.this, Nacosi_SezeniActivity.class);

                    Pair[] pairs = new Pair[3];
                    pairs[0] = new Pair<View, String>(danger_pic11, "imageTransition");
                    pairs[1] = new Pair<View, String>(danger_pic12, "image2Transition");
                    pairs[2] = new Pair<View, String>(text_posture6, "descTransition");

                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(NacosidatpozorActivity.this, pairs);
                    startActivity(sharedIntent, options.toBundle());
                }
            });
        }else{
            cardViewspravnedrzenitela6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a = new Intent(NacosidatpozorActivity.this, Nacosi_SezeniActivity.class);
                    a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(a);
                }
            });
        }




        /*7)PODMÍNKA ležení*/
        if (Build.VERSION.SDK_INT >= 21) {
            /*ležení7)*/
            cardViewspravnedrzenitela7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sharedIntent = new Intent(NacosidatpozorActivity.this, Nacosi_LezeniActivity.class);

                    Pair[] pairs = new Pair[3];
                    pairs[0] = new Pair<View, String>(danger_pic13, "imageTransition");
                    pairs[1] = new Pair<View, String>(danger_pic14, "image2Transition");
                    pairs[2] = new Pair<View, String>(text_posture7, "descTransition");

                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(NacosidatpozorActivity.this, pairs);
                    startActivity(sharedIntent, options.toBundle());
                }
            });
        }else{
            cardViewspravnedrzenitela7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a = new Intent(NacosidatpozorActivity.this, Nacosi_LezeniActivity.class);
                    a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(a);
                }
            });

        }


        previous.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent a = new Intent(NacosidatpozorActivity.this, CviceniActivity.class);
               a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
               startActivity(a);
           }
       });

    }



}
