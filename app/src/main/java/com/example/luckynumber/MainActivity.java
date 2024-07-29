package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText  name;
    TextView  title;
    Button btn;
    ImageView dice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        title = findViewById(R.id.title1);
        dice = findViewById(R.id.dice);
        btn  = findViewById(R.id.generate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               shareScreen();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }
    public void shareScreen(){
        String userName = name.getText().toString();
        Intent share = new Intent(this, Display.class);
        share.putExtra("name",userName);
        startActivity(share);

    }
}