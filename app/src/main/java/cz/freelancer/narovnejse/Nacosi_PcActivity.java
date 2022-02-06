package cz.freelancer.narovnejse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Nacosi_PcActivity extends AppCompatActivity {
    Button previous,vice;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nacosi_pc);

        previous = findViewById(R.id.previous);
        vice = findViewById(R.id.vice);





vice.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent a = new Intent(Nacosi_PcActivity.this, Nacosi_Pc2Activity.class);
        a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(a);
    }
});

        //!
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Nacosi_PcActivity.this, NacosidatpozorActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


    }

}
