package cz.freelancer.narovnejse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class OaplikaciActivity extends AppCompatActivity {




    private ViewPager mSlideViewPager;
  private LinearLayout mDotLayout;

  private TextView [] mDots;

  private SliderAdapter sliderAdapter;

  private Button mNextBtn;
  private Button mBackBtn;


  private int mCurrentPage;
//

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oaplikaci);


        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        mNextBtn = (Button) findViewById(R.id.next_btn);
        mBackBtn = (Button) findViewById(R.id.back_btn);


        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);


     mNextBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             mSlideViewPager.setCurrentItem(mCurrentPage +1);
         }
     });

     mBackBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             mSlideViewPager.setCurrentItem(mCurrentPage -1);
         }
     });




        }

        public void addDotsIndicator(int position){


          mDots = new TextView[4];
          mDotLayout.removeAllViews();

          for (int i = 0; i < mDots.length; i++) {

              mDots[i] = new TextView(this);
              mDots[i].setText(Html.fromHtml("&#8226;"));
              mDots[i].setTextSize(35);
              mDots[i].setTextColor(getResources().getColor(R.color.dots_out_color));

              mDotLayout.addView(mDots[i]);
          }

      if (mDots.length > 0){
          mDots[position].setTextColor(getResources().getColor(R.color.dots_in_color));
      }



}

ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

        addDotsIndicator(i);

        mCurrentPage= i;

                         if(i == 0){
                               mNextBtn.setEnabled(true);

                               mBackBtn.setEnabled(false);
                               mBackBtn.setVisibility(View.INVISIBLE);



                               mNextBtn.setText("Další");
                               mBackBtn.setText("");

                          } else if (i == mDots.length -1){

                             mNextBtn.setEnabled(true);
                             mBackBtn.setEnabled(true);
                             mBackBtn.setVisibility(View.VISIBLE);
                             mNextBtn.setVisibility(View.VISIBLE);


                             mNextBtn.setText("Menu");
                             mBackBtn.setText("Zpět");

                             mNextBtn.setOnClickListener(new View.OnClickListener() {


                                 @Override
                                 public void onClick(View view) {                                                              // přechod zpátky ma MENU
                                     Intent a =new Intent(OaplikaciActivity.this, MainActivity.class);
                                     a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                     startActivity(a);
                                 }

                             });


                         } else {
                             mNextBtn.setEnabled(true);
                             mBackBtn.setEnabled(true);
                             mBackBtn.setVisibility(View.VISIBLE);

                             mNextBtn.setText("Další");
                             mBackBtn.setText("Zpět");
                         }




    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
};



  @Override
  public void onBackPressed(){    //blokace btn back

  }

}
