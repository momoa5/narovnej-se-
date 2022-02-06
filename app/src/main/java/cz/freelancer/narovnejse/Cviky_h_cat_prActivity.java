package cz.freelancer.narovnejse;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.varunest.sparkbutton.SparkButton;

public class Cviky_h_cat_prActivity extends AppCompatActivity {
LinearLayout inLinear3;
ImageView alert,close_btn;
Animation anim_lin_lay_semicircle,anim_silueta;
Dialog epicDialog;
TextView napoveda,dialogText;
SparkButton spark_button;
Button previous;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_cat_pr);


        alert = findViewById(R.id.alert);



        epicDialog = new Dialog(this);

        inLinear3 = findViewById(R.id.inLinear3);

        close_btn = findViewById(R.id.close_btn);
        spark_button = findViewById(R.id.spark_button);
        previous = findViewById(R.id.previous);




        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Cviky_h_cat_prActivity.this, Cviky_HrudniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

/*------------------------------------*/

        anim_lin_lay_semicircle = AnimationUtils.loadAnimation(this, R.anim.anim_lin_lay_semicircle);






        spark_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowPopup();
            }
        });



    }


    public void ShowPopup(){
        epicDialog.setContentView(R.layout.activity_h_cat_pr_dialog);
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
