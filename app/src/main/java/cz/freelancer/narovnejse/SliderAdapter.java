package cz.freelancer.narovnejse;

import android.content.Context;
import android.graphics.Paint;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {




    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }



public int[] slide_images = {
           R.drawable.eat,
           R.drawable.workout,
        R.drawable.correct_posture2,
        R.drawable.notification
};


 public String [] slide_headings = {
   "NAROVNEJ SE!",
    "CVIKY",
         "SPRÁVNÉ DRŽENÍ TĚLA",
         "NOTIFIKACE"

 };

public String[] slide_descs = {

       "Ahoj! Vítáme tě v naší aplikaci. Naše appka je zaměřena za životní styl, konkrétně na korektní postoj a správné držení tvého těla. Cílem aplikace je dokázat, že bolestem zad lze předejít poze správným pohybem a správným provedením cviků.",
       "Aplikace obsahuje seznam cviků, rozdělený na krční, hrudní a bederní část páteře! Daný seznam se v průběhu, bude postupně doplňovat o další cvičení.",
        "Jak už bylo zmíněno, aplikace obsahuje, jak docílit správného držení těla i v každodenních činnostech.",
        "V nastavení si můžeš vytvořit notifikaci, která tě bude upozorňovat a ptát se tě, zda-li se nehrbíš a máš narovnaná záda."
};



    @Override
    public int getCount(){
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o){
        return view == (RelativeLayout) o;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout1, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.imageView2);
        TextView slideHeading = (TextView) view.findViewById(R.id.heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.textView2);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){

        container.removeView((RelativeLayout)object);
    }


}
