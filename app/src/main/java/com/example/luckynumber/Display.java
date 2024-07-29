package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Display extends AppCompatActivity {
    Button  shareBtn;
    TextView title2,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        number = findViewById(R.id.luckyNumber);
        shareBtn = findViewById(R.id.shareButton);
        title2 = findViewById(R.id.title2);

        Intent share =getIntent();
        String userName = share.getStringExtra("name");
        int randomNumber = RandomNumber();
        number.setText(" "+randomNumber);

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            shareData(userName,randomNumber);
            }
        });



    }
    public int RandomNumber(){
        Random random = new Random();

        int randomNumber = random.nextInt(1000);
        return randomNumber;
    }
    public void  shareData(String userName,int RandomNumber){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,userName + "'s Lucky number is "+RandomNumber);
        i.putExtra(Intent.EXTRA_TEXT,userName + "'s Lucky number is \n"+RandomNumber+"\nTo  get your lucky number download the app LUCKY NUMBER !! \n Have a great day !!");
        startActivity(Intent.createChooser(i,"chose a platform"));
    }
}