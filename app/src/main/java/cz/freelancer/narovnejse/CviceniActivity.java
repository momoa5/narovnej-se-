package cz.freelancer.narovnejse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;


public class CviceniActivity extends AppCompatActivity {
    Animation anim_lin_lay_semicircle,anim_grid_layout;
    LinearLayout inLinear;
    GridLayout gridLayout;
    Button previous;
    CardView cardViewspravnedrzenitela,cardViewnacosidatpozor,cardViewcviky;




  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cviceni);


inLinear = findViewById(R.id.inLinear);
gridLayout = findViewById(R.id.gridlayout);
previous = findViewById(R.id.previous);
cardViewspravnedrzenitela = findViewById(R.id.cardViewspravnedrzenitela);
cardViewnacosidatpozor = findViewById(R.id.cardViewnacosidatpozor);
cardViewcviky = findViewById(R.id.cardViewcviky);

anim_lin_lay_semicircle = AnimationUtils.loadAnimation(this, R.anim.anim_lin_lay_semicircle);
anim_grid_layout = AnimationUtils.loadAnimation(this,R.anim.anim_grid_layout);

inLinear.startAnimation(anim_lin_lay_semicircle);
gridLayout.startAnimation(anim_grid_layout);


//tlačítko zpět

previous.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent a = new Intent(CviceniActivity.this, MainActivity.class);
        a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(a);
    }
});


//první box
cardViewspravnedrzenitela.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent a = new Intent(CviceniActivity.this, SpravnedrzenitelaActivity.class);
        a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(a);
    }
});

//druhý box
cardViewnacosidatpozor.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent a = new Intent(CviceniActivity.this, NacosidatpozorActivity.class);
        a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(a);
    }
});
cardViewcviky.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent a = new Intent(CviceniActivity.this, Cviky_KrcniActivity.class);
              a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
              startActivity(a);
          }
      });





         }
     }

