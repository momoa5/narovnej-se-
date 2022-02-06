package cz.freelancer.narovnejse;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Calendar;

public class NotifikaceActivity extends AppCompatActivity {

Button notifikace_button, previous;
Switch main_switch, min_hout_switch;
EditText edit_minuty;
    EditText edit_hodiny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikace);
        createNotificationChannel();


        notifikace_button = findViewById(R.id.notifikace_button);
        main_switch = findViewById(R.id.main_switch);
        min_hout_switch = findViewById(R.id.min_hout_switch);
        edit_minuty = findViewById(R.id.edit_minuty);
        edit_hodiny = findViewById(R.id.edit_hodin);
        previous = findViewById(R.id.previous);




        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(NotifikaceActivity.this, NastaveniActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });



        SharedPreferences settings = getSharedPreferences(POWER_SERVICE, 0);
        boolean silent = settings.getBoolean("switchkey", false);
        main_switch.setChecked(silent);


        SharedPreferences settings2 = getSharedPreferences(POWER_SERVICE, 0);
        boolean silent2 = settings2.getBoolean("switchkey2", false);
        min_hout_switch.setChecked(silent2);

        SharedPreferences settings3 = getSharedPreferences(POWER_SERVICE,0);
        String silent3 = settings3.getString("neco", "");
        edit_hodiny.setText(silent3);

        //kontrola při navratu do aplikace
        if (main_switch.isChecked())
        {
            min_hout_switch.setEnabled(true);

        }
        else{
            min_hout_switch.setEnabled(false);
            edit_minuty.setEnabled(false);
            edit_hodiny.setEnabled(false);
        }



        main_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {


                    min_hout_switch.setEnabled(true);



                     //kontrola při navratu do aplikace
                    if(min_hout_switch.isChecked())
                    {
                        edit_hodiny.setEnabled(true);
                        edit_minuty.setEnabled(false);

                        edit_hodiny.addTextChangedListener(loginTextWatcher);

                        SharedPreferences settings3 = getSharedPreferences(POWER_SERVICE, 0);
                        SharedPreferences.Editor editor3 = settings3.edit();
                        editor3.putString("neco", "");
                        editor3.commit();


                        notifikace_button.setOnClickListener(v -> {




                            Intent intent = new Intent(NotifikaceActivity.this, ReminderBroadcast.class);
                            PendingIntent pendingIntent = PendingIntent.getBroadcast(NotifikaceActivity.this,0,intent,0);

                            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                            long timeAtButtonClick = System.currentTimeMillis();
                            int hodina = Integer.parseInt(edit_hodiny.getText().toString());


                            Calendar calendar = Calendar.getInstance();
                            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                            int currentMinute = calendar.get(Calendar.MINUTE);
                            calendar.setTimeInMillis(System.currentTimeMillis());
                            calendar.set(Calendar.HOUR_OF_DAY, currentHour);
                            calendar.set(Calendar.MINUTE, currentMinute);

                            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                                    1000 * 60 * 60 * hodina, pendingIntent);


                            Toast.makeText(NotifikaceActivity.this, "Notifikace úspěšně nastavena!",Toast.LENGTH_SHORT).show();

                            Intent a = new Intent(NotifikaceActivity.this, NastaveniActivity.class);
                            a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(a);


                        });











                    }
                   //defaultni hodnota po spusteni hlavniho switche
                    else{
                        edit_hodiny.setEnabled(false);
                        edit_minuty.setEnabled(true);

                        edit_minuty.addTextChangedListener(loginTextWatcher);



                        notifikace_button.setOnClickListener(v -> {




                            Intent intent = new Intent(NotifikaceActivity.this, ReminderBroadcast.class);
                            PendingIntent pendingIntent = PendingIntent.getBroadcast(NotifikaceActivity.this,0,intent,0);

                            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                            long timeAtButtonClick = System.currentTimeMillis();
                            int minuta = Integer.parseInt(edit_minuty.getText().toString());


                            Calendar calendar = Calendar.getInstance();
                            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                            int currentMinute = calendar.get(Calendar.MINUTE);
                            calendar.setTimeInMillis(System.currentTimeMillis());
                            calendar.set(Calendar.HOUR_OF_DAY, currentHour);
                            calendar.set(Calendar.MINUTE, currentMinute);

                            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                                    1000 * 60 * minuta, pendingIntent);


                            Toast.makeText(NotifikaceActivity.this, "Notifikace úspěšně nastavena!",Toast.LENGTH_SHORT).show();

                            Intent a = new Intent(NotifikaceActivity.this, NastaveniActivity.class);
                            a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(a);


                        });


                    }


                    min_hout_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(isChecked)
                            {
                                edit_hodiny.setEnabled(true);
                                edit_minuty.setEnabled(false);


                                edit_hodiny.addTextChangedListener(loginTextWatcher);




                                notifikace_button.setOnClickListener(v -> {




                                    Intent intent = new Intent(NotifikaceActivity.this, ReminderBroadcast.class);
                                    PendingIntent pendingIntent = PendingIntent.getBroadcast(NotifikaceActivity.this,0,intent,0);

                                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                                    long timeAtButtonClick = System.currentTimeMillis();
                                    int hodina = Integer.parseInt(edit_hodiny.getText().toString());


                                    Calendar calendar = Calendar.getInstance();
                                    int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                                    int currentMinute = calendar.get(Calendar.MINUTE);
                                    calendar.setTimeInMillis(System.currentTimeMillis());
                                    calendar.set(Calendar.HOUR_OF_DAY, currentHour);
                                    calendar.set(Calendar.MINUTE, currentMinute);

                                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                                            1000 * 60 * 60 * hodina, pendingIntent);


                                    Toast.makeText(NotifikaceActivity.this, "Notifikace úspěšně nastavena!",Toast.LENGTH_SHORT).show();

                                    Intent a = new Intent(NotifikaceActivity.this, NastaveniActivity.class);
                                    a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(a);


                                });












                            }

                            else{
                                edit_hodiny.setEnabled(false);
                                edit_minuty.setEnabled(true);



                                edit_minuty.addTextChangedListener(loginTextWatcher);






                                notifikace_button.setOnClickListener(v -> {



                                    Intent intent = new Intent(NotifikaceActivity.this, ReminderBroadcast.class);
                                    PendingIntent pendingIntent = PendingIntent.getBroadcast(NotifikaceActivity.this,0,intent,0);

                                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                                    long timeAtButtonClick = System.currentTimeMillis();
                                    int minuta = Integer.parseInt(edit_minuty.getText().toString());

                                    Calendar calendar = Calendar.getInstance();
                                    int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                                    int currentMinute = calendar.get(Calendar.MINUTE);
                                    calendar.setTimeInMillis(System.currentTimeMillis());
                                    calendar.set(Calendar.HOUR_OF_DAY, currentHour);
                                    calendar.set(Calendar.MINUTE, currentMinute);

                                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                                            1000 * 60 * minuta, pendingIntent);

                                    Toast.makeText(NotifikaceActivity.this, "Notifikace úspěšně nastavena!",Toast.LENGTH_SHORT).show();

                                    Intent a = new Intent(NotifikaceActivity.this, NastaveniActivity.class);
                                    a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(a);



                                });



                            }



                            SharedPreferences settings2 = getSharedPreferences(POWER_SERVICE, 0);
                            SharedPreferences.Editor editor2 = settings2.edit();
                            editor2.putBoolean("switchkey2", isChecked);
                            editor2.commit();


                        }
                    });



                }
                else{
                   edit_minuty.setEnabled(false);
                   edit_hodiny.setEnabled(false);
                    min_hout_switch.setEnabled(false);
                    notifikace_button.setEnabled(false);

               Intent intent = new Intent( NotifikaceActivity.this, ReminderBroadcast.class);
               PendingIntent pendingIntent = PendingIntent.getBroadcast(NotifikaceActivity.this,0,intent,0);
               AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

               if(pendingIntent != null)
               {
                   alarmManager.cancel(pendingIntent);
               }

                    Toast.makeText(NotifikaceActivity.this, "Notifikace úspěšně zrušena / vypnuta!",Toast.LENGTH_SHORT).show();


                }




SharedPreferences settings = getSharedPreferences(POWER_SERVICE, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("switchkey", isChecked);
                editor.commit();

            }
        });
















    }





//zobrazeni tlacitka notifikace, pouze zda se vyplni textové pole
private TextWatcher loginTextWatcher = new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        String hodiny = edit_hodiny.getText().toString().trim();
        String minuty = edit_minuty.getText().toString().trim();


        notifikace_button.setEnabled(!hodiny.isEmpty() || !minuty.isEmpty());
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
};






private void createNotificationChannel(){

    if(Build.VERSION.SDK_INT >= 26) {


            CharSequence name = "Nehrb se!";
            String description = "Uz ses narovnal/a?";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyLemubit", name, importance);
            channel.setDescription(description);


            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }




        }




    }



