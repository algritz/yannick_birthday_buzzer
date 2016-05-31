package ca.nosrecettes.ybb.yannick_birthday_buzzer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private TextView days_to_go_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        long days_to_go = 0;

        Calendar currentCalendar = Calendar.getInstance();

        Date today = new Date();

        long next_year = currentCalendar.get(Calendar.YEAR) + 1;
        currentCalendar.set(Calendar.MONTH, 5);
        currentCalendar.set(Calendar.DAY_OF_MONTH, 15);

        Date next_bday = currentCalendar.getTime();

        long diff = next_bday.getTime() - today.getTime();


        //long diff_days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        long a_year_millisec = TimeUnit.MILLISECONDS.convert(365, TimeUnit.DAYS);

        days_to_go = 365 - (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

        TextView days_to_go_text = (TextView) findViewById(R.id.days_to_go);
        days_to_go_text.setText(days_to_go + " days to go!");
    }
}
