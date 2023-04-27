package com.example.test_ui_components;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton rb_male , rb_female;
    CheckBox cb_football , cb_tennis , cb_gym ;
    String gender = "male";
    NumberPicker np ;
    CalendarView cv ;
    RatingBar rb;
    SeekBar sb_play_with_me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb_male = findViewById(R.id.rb_male);
        rb_female = findViewById(R.id.rb_female);

        rb_male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(getBaseContext(), "male is checked", Toast.LENGTH_LONG).show();
                    gender = "male";
                }else {
                    Toast.makeText(getBaseContext(), "female is checked", Toast.LENGTH_LONG).show();
                    gender = "female";
                }
            }
        });


        cb_football = findViewById(R.id.cb_football);
        cb_tennis = findViewById(R.id.cb_tennis);
        cb_gym = findViewById(R.id.cb_gym);

        cb_football.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(getBaseContext(),"Good I also like football",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(),"May be you like another sport ",Toast.LENGTH_LONG).show();
            }
        });

        cb_gym.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getBaseContext(),"Wow you are a fitness "+gender,Toast.LENGTH_LONG).show();
                }
            }
        });

        np = findViewById(R.id.np_clock);
        np.setMinValue(0);
        np.setMaxValue(24);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Toast.makeText(getBaseContext(),"amm it's now "+newVal,Toast.LENGTH_LONG).show();
            }
        });

        cv= findViewById(R.id.cv_date_of_birht);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getBaseContext(),"That's good you are born in "+year,Toast.LENGTH_LONG).show();
            }
        });

        rb= findViewById(R.id.rb);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getBaseContext(),"you now rating us by "+rating+" star",Toast.LENGTH_LONG).show();
            }
        });


        sb_play_with_me = findViewById(R.id.sb_play_with_me);
        sb_play_with_me.setMax(200);
        sb_play_with_me.setProgress(50);
        sb_play_with_me.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getBaseContext(),"We now pass "+progress+" of the total way",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getBaseContext()," Ohh you touch me ",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getBaseContext(),"Touch me again to test if I work !",Toast.LENGTH_LONG).show();
            }
        });



    }
}