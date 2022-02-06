package cz.freelancer.narovnejse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Cviky_BederniActivity extends AppCompatActivity {
Button btn_krcnip,btn_hrudnip, previous;
CardView cardView_zatlaceni,cardView_panev, cardView_kolebka, cardView_sedy;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cviky_b);

        btn_krcnip = findViewById(R.id.btn_krcnip);
        btn_hrudnip = findViewById(R.id.btn_hrudnip);
        cardView_zatlaceni = findViewById(R.id.cardView_zatlaceni);
        cardView_panev = findViewById(R.id.cardView_panev);
        previous = findViewById(R.id.previous);
        cardView_kolebka = findViewById(R.id.cardView_kolebka);
        cardView_sedy = findViewById(R.id.cardView_sedy);



        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Cviky_BederniActivity.this, CviceniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });



        btn_hrudnip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_BederniActivity.this, Cviky_HrudniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        btn_krcnip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_BederniActivity.this, Cviky_KrcniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        cardView_zatlaceni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_BederniActivity.this, Cviky_b_zatlaceniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


        cardView_panev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_BederniActivity.this, Cviky_b_panevActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        cardView_kolebka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_BederniActivity.this, Cviky_b_kolebkaActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        cardView_sedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_BederniActivity.this, Cviky_b_sedyActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


    }


}
