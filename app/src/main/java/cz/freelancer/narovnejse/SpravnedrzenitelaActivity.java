package cz.freelancer.narovnejse;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class SpravnedrzenitelaActivity extends AppCompatActivity {
    Button previous,kliknanotifik;
    Animation anim_grid_layout,anim_lin_lay_semicircle,anim_kliknanotifik;
    LinearLayout inLinear2;
    GridLayout gridLayout2;
    VideoView videoview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spravnedrzenitela);

        previous = findViewById(R.id.previous);
        inLinear2 = findViewById(R.id.inLinear2);
        kliknanotifik = findViewById(R.id.kliknanotifik);
        gridLayout2 = findViewById(R.id.gridlayout2);
        videoview = findViewById(R.id.videoview);

        anim_lin_lay_semicircle = AnimationUtils.loadAnimation(this, R.anim.anim_lin_lay_semicircle);
        anim_grid_layout = AnimationUtils.loadAnimation(this,R.anim.anim_grid_layout);
        anim_kliknanotifik = AnimationUtils.loadAnimation(this,R.anim.anim_kliknanotifik);


        inLinear2.startAnimation(anim_lin_lay_semicircle);
        kliknanotifik.startAnimation(anim_kliknanotifik);
        gridLayout2.startAnimation(anim_grid_layout);
        videoview.startAnimation(anim_grid_layout);


        //video

        VideoView videoView = findViewById(R.id.videoview);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.pater2;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);



        //tlačítko zpátky

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(SpravnedrzenitelaActivity.this, CviceniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


        kliknanotifik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(SpravnedrzenitelaActivity.this, NastaveniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

    }



}