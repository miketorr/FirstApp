package empty.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText day;
    private Button startb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.mNameField);
        day = (EditText) findViewById(R.id.mDayField);
        startb = (Button) findViewById(R.id.mStartBut);

        startb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String d = day.getText().toString();

                startApp(n,d);

            }
        });

    }


    private void startApp(String name, String day) {
        Intent i = new Intent(this, ChooseColour.class);
        i.putExtra("name",name);
        i.putExtra("day",day);
        startActivity(i);

    }

    protected void onResume() {
        super.onResume();
        name.setText("");
        day.setText("");
    }

}

