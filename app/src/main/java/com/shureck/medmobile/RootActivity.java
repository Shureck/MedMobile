package com.shureck.medmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RootActivity extends AppCompatActivity implements View.OnClickListener {

    CardView cvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        startService(new Intent(this, SocketService.class));

        CardView photo_card = findViewById(R.id.photo_card);
        photo_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTest = new Intent(RootActivity.this, MainActivity.class);
                startActivity(intentTest);
            }
        });
        CardView register_device_card = findViewById(R.id.register_device_card);

        register_device_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTest = new Intent(RootActivity.this, RegisterDeviceActivity.class);
                startActivity(intentTest);
            }
        });
//        Intent intentTest = new Intent(RootActivity.this, RegisterDeviceActivity.class);
//        startActivity(intentTest);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.photo_card:
                Context context = getApplicationContext();
                CharSequence text = "Hello toast!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                break;
        }
    }
}