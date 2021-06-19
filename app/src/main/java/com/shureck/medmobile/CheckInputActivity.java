package com.shureck.medmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckInputActivity extends AppCompatActivity {

    Button sendButton;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_input);

        sendButton = findViewById(R.id.button_send);
        backButton = findViewById(R.id.button_back);

        sendButton.setOnClickListener(v -> {
            Intent intent = new Intent(CheckInputActivity.this, AddActionsActivity.class);
            startActivity(intent);
        });

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(CheckInputActivity.this, RootActivity.class);
            startActivity(intent);
            finish();
        });
    }

}