package cz.freelancer.narovnejse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Cviky_KrcniActivity extends AppCompatActivity {
    Button previous,btn_krcnip,btn_hrudnip,btn_bedernip;
    CardView cardView_uklony,cardView_krouzeni,cardView_predklon;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cviky_k);

        previous = findViewById(R.id.previous);
        btn_krcnip = findViewById(R.id.btn_krcnip);
        btn_hrudnip = findViewById(R.id.btn_hrudnip);
        btn_bedernip = findViewById(R.id.btn_bedernip);
        cardView_uklony = findViewById(R.id.cardView_uklony);
        cardView_krouzeni = findViewById(R.id.cardView_krouzeni);
        cardView_predklon = findViewById(R.id.cardView_predklon);

        btn_hrudnip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_KrcniActivity.this, Cviky_HrudniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        btn_bedernip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_KrcniActivity.this, Cviky_BederniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


        //submenu

        cardView_uklony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_KrcniActivity.this, Cviky_k_uklonyActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        cardView_krouzeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_KrcniActivity.this, Cviky_k_krouzeniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        cardView_predklon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_KrcniActivity.this, Cviky_k_predklonActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        //!
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Cviky_KrcniActivity.this, CviceniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


    }

}
