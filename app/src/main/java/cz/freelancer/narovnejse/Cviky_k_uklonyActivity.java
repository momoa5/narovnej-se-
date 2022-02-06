package cz.freelancer.narovnejse;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.CountDownTimer;

import com.varunest.sparkbutton.SparkButton;
import com.varunest.sparkbutton.SparkButtonBuilder;

public class Cviky_k_uklonyActivity extends AppCompatActivity {
LinearLayout inLinear3;
ImageView pic_krk1,pic_krk2,close_btn;
Animation anim_lin_lay_semicircle,anim_krk1,anim_krk2;
Dialog epicDialog;
TextView napoveda,dialogText;
SparkButton spark_button;
Button previous;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k_uklony);




        epicDialog = new Dialog(this);

        inLinear3 = findViewById(R.id.inLinear3);
        pic_krk1 = findViewById(R.id.pic_krk1);
        pic_krk2 = findViewById(R.id.pic_krk2);

        close_btn = findViewById(R.id.close_btn);
        spark_button = findViewById(R.id.spark_button);
        previous = findViewById(R.id.previous);




        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Cviky_k_uklonyActivity.this, Cviky_KrcniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


        /*------------------------------------*/

        anim_lin_lay_semicircle = AnimationUtils.loadAnimation(this, R.anim.anim_lin_lay_semicircle);
        anim_krk1 = AnimationUtils.loadAnimation(this,R.anim.anim_krk1);
        anim_krk2 = AnimationUtils.loadAnimation(this,R.anim.anim_krk2);


        inLinear3.startAnimation(anim_lin_lay_semicircle);
        pic_krk1.startAnimation(anim_krk1);
        pic_krk2.startAnimation(anim_krk2);


        spark_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowPopup();
            }
        });



    }


    public void ShowPopup(){
        epicDialog.setContentView(R.layout.activity_k_uklony_dialog);
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
