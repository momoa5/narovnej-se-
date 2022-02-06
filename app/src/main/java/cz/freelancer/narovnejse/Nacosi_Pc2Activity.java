package cz.freelancer.narovnejse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Nacosi_Pc2Activity extends AppCompatActivity {
    Button previous;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nacosi_pc2);

        previous = findViewById(R.id.previous);




        //!
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Nacosi_Pc2Activity.this, Nacosi_PcActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


    }

}
