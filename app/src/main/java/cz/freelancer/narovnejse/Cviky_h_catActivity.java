package cz.freelancer.narovnejse;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.varunest.sparkbutton.SparkButton;

public class Cviky_h_catActivity extends AppCompatActivity {
LinearLayout inLinear3;
ImageView pic_krk1,pic_krk2,close_btn;
Animation anim_lin_lay_semicircle,anim_silueta;
Dialog epicDialog;
TextView napoveda,dialogText;
SparkButton spark_button;
Button previous;
int []imageArray={R.drawable.silueta_hrud_1,R.drawable.silueta_hrud_5};
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_cat);

        pic_krk1 = findViewById(R.id.pic_krk1);


        final Handler handler = new Handler();
       Runnable runnable = new Runnable() {

    int i=0;
    public void run() {
        pic_krk1.setImageResource(imageArray[i]);
        i++;
        if (i>imageArray.length-1){
            i=0;
        }
        handler.postDelayed(this,1800);
    }
};
handler.postDelayed(runnable, 2000);




        epicDialog = new Dialog(this);

        inLinear3 = findViewById(R.id.inLinear3);


        close_btn = findViewById(R.id.close_btn);
        spark_button = findViewById(R.id.spark_button);
        previous = findViewById(R.id.previous);




        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Cviky_h_catActivity.this, Cviky_HrudniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

/*------------------------------------*/

        anim_lin_lay_semicircle = AnimationUtils.loadAnimation(this, R.anim.anim_lin_lay_semicircle);
        anim_silueta = AnimationUtils.loadAnimation(this,R.anim.anim_silueta);

        pic_krk1.startAnimation(anim_silueta);



        spark_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowPopup();
            }
        });



    }


    public void ShowPopup(){
        epicDialog.setContentView(R.layout.activity_h_cat_dialog);
        close_btn = epicDialog.findViewById(R.id.close_btn);
        napoveda = epicDialog.findViewById(R.id.napoveda);
        dialogText = epicDialog.findViewById(R.id.dialog_text);
        spark_button = epicDialog.findViewById(R.id.spark_button);

        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
    }
}
