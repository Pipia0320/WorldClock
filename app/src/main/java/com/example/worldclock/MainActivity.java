package com.example.worldclock;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_12hr = findViewById(R.id.button_12);
        Button button_24hr = findViewById(R.id.button_24);
        LinearLayout layout = findViewById(R.id.linearlayout);


        final ArrayList<TextClock> textClock_list = new ArrayList<TextClock>();

        for (int i = 0; i < layout.getChildCount(); i++){

            // TextClocks are nested in FrameLayout
            FrameLayout frame = (FrameLayout) layout.getChildAt(i);

            for (int x = 0; x < frame.getChildCount(); x++) {
                if (frame.getChildAt(x) instanceof TextClock)
                    textClock_list.add( (TextClock) frame.getChildAt(x) );
            }

        }

        View.OnClickListener change_to_12 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("12 Pressed");

                for (TextClock each_textClock : textClock_list) {
                    each_textClock.setFormat12Hour("hh:mm:ss a       dd/MM/yyyy");
                }
            }
        };

        View.OnClickListener change_to_24 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("24 Pressed");

                for (TextClock each_textClock : textClock_list) {
                    each_textClock.setFormat12Hour("kk:mm:ss       dd/MM/yyyy");
                }

            }
        };

        button_12hr.setOnClickListener(change_to_12);
        button_24hr.setOnClickListener(change_to_24);



        // Australia
        FrameLayout include_syd = findViewById(R.id.include_syd);
        ImageView image = include_syd.findViewById(R.id.image_view);
        TextView text = include_syd.findViewById(R.id.text_view);
        TextClock clock = include_syd.findViewById(R.id.text_clock);

        image.setImageResource(R.drawable.sydney);
        text.setText(R.string.Australia_Sydney);
        clock.setTimeZone("Australia/Sydney");

        //Tokyo
        FrameLayout include_tok = findViewById(R.id.include_tok);
        image = include_tok.findViewById(R.id.image_view);
        text = include_tok.findViewById(R.id.text_view);
        clock = include_tok.findViewById(R.id.text_clock);

        image.setImageResource(R.drawable.tokyo);
        text.setText(R.string.Asia_Tokyo);
        clock.setTimeZone("Asia/Tokyo");

        // America
        FrameLayout include_ny = findViewById(R.id.include_ny);
        image = include_ny.findViewById(R.id.image_view);
        text = include_ny.findViewById(R.id.text_view);
        clock = include_ny.findViewById(R.id.text_clock);

        image.setImageResource(R.drawable.newyork);
        text.setText(R.string.America_New_York);
        clock.setTimeZone("America/New_York");


        // China
        FrameLayout include_sha = findViewById(R.id.include_sha);
        image = include_sha.findViewById(R.id.image_view);
        text = include_sha.findViewById(R.id.text_view);
        clock = include_sha.findViewById(R.id.text_clock);

        image.setImageResource(R.drawable.shanghai);
        text.setText(R.string.Asia_Shanghai);
        clock.setTimeZone("Asia/Shanghai");

        // London
        FrameLayout include_lon = findViewById(R.id.include_lon);
        image = include_lon.findViewById(R.id.image_view);
        text = include_lon.findViewById(R.id.text_view);
        clock = include_lon.findViewById(R.id.text_clock);

        image.setImageResource(R.drawable.london);
        text.setText(R.string.Europe_London);
        clock.setTimeZone("Europe/London");




    }



}
