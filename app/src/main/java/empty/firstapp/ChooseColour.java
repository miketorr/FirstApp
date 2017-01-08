package empty.firstapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.logging.Handler;

import empty.firstapp.model.rText;

import static android.R.attr.duration;
import static empty.firstapp.R.id.text;

public class ChooseColour extends AppCompatActivity {


    private Button red;
    private Button green;
    private Button blue;
    private Button fin;
    private String name;
    private String day;
    private TextView toptext;
    private Random r = new Random();
    private rText ran = new rText();


    public ChooseColour() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_colour);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        day = i.getStringExtra("day").toLowerCase();

        if (name == null || name.isEmpty()) {
            name = "Friend";
        }



        //assign variables to the layout - buttons, text fields from their ids
        toptext = (TextView) findViewById(R.id.mNameSpace);
        toptext.setText("Hello, "+ name);
        red = (Button) findViewById(R.id.button);
        green = (Button) findViewById(R.id.button2);
        blue = (Button) findViewById(R.id.button3);
        fin = (Button) findViewById(R.id.mFinish);

        //create a loadPage method, for next actionlistner on button and create
        livePage();



    }


    private void livePage() {

        toToast(day);

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.mNeedToChange).setBackgroundColor(Color.RED);
                toptext.setText(name+" "+ranText());
                livePage();
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.mNeedToChange).setBackgroundColor(Color.GREEN);
                toptext.setText(name+" "+ranText());
                livePage();
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.mNeedToChange).setBackgroundColor(Color.BLUE);
                toptext.setText(name+" "+ranText());
                livePage();
            }
        });
        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });





    }

    public void toToast(String d) {
        if (day.matches("(mon|tues|wednes|thurs|fri|)day")) {
            Toast.makeText(ChooseColour.this, "The day you entered is a weekday.", Toast.LENGTH_SHORT).show();
        } else if (day.matches("(satur|sun|)day")) {
            Toast.makeText(ChooseColour.this, "The day you entered falls on the weekend.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ChooseColour.this, "You did not enter a valid day. TOOOOOOOAAAAAAAST TEST", Toast.LENGTH_SHORT).show();
        }
    }

    public String ranText() {
        int i = r.nextInt(10);
        return ran.getList().get(i);

    }




    // copied to make toast reaapear  on repeated interval



    // was trying to use string resources and pick a random string from there. I DONT KNOW HOW TO DO THAT so just create a new class next time



}
