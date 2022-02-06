package cz.freelancer.narovnejse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NastaveniActivity extends AppCompatActivity {
    Button previous, settings_button, ohodnot_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nastaveni);


        previous = findViewById(R.id.previous);
        settings_button = findViewById(R.id.settings_button);
        ohodnot_button = findViewById(R.id.ohodnot_button);



        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(NastaveniActivity.this, MainActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


        settings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(NastaveniActivity.this, NotifikaceActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        ohodnot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(NastaveniActivity.this, MainActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


    }







    @Override
    public void onBackPressed(){    //blokace btn back

    }



}
