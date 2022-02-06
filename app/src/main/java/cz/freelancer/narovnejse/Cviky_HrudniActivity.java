package cz.freelancer.narovnejse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Cviky_HrudniActivity extends AppCompatActivity {
Button btn_krcnip,btn_bedernip,btn_hrudnip, previous;
CardView cardView_kocicihrbet,cardView_kocicihrbetPR,cardView_vytaceni,cardView_rucezahlavou,cardView_opis;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cviky_h);



        btn_krcnip = findViewById(R.id.btn_krcnip);
        btn_bedernip = findViewById(R.id.btn_bedernip);
        btn_hrudnip = findViewById(R.id.btn_hrudnip);
        cardView_kocicihrbet = findViewById(R.id.cardView_kocicihrbet);
        cardView_kocicihrbetPR = findViewById(R.id.cardView_kocicihrbetPR);
        cardView_vytaceni = findViewById(R.id.cardView_vytaceni);
        cardView_rucezahlavou = findViewById(R.id.cardView_rucezahlavou);
        cardView_opis = findViewById(R.id.cardView_opis);
        previous = findViewById(R.id.previous);




        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Cviky_HrudniActivity.this, CviceniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        btn_krcnip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_HrudniActivity.this, Cviky_KrcniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        btn_bedernip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_HrudniActivity.this, Cviky_BederniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        cardView_kocicihrbet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_HrudniActivity.this, Cviky_h_catActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        cardView_kocicihrbetPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_HrudniActivity.this, Cviky_h_cat_prActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        cardView_vytaceni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_HrudniActivity.this, Cviky_h_vytaceniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        cardView_rucezahlavou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_HrudniActivity.this, Cviky_h_rucezahlavouActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        cardView_opis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Cviky_HrudniActivity.this, Cviky_h_opisActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
    }

}
