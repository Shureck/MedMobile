package com.shureck.medmobile.InputData;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.shureck.medmobile.ActionsManaging.AddActionsActivity;
import com.shureck.medmobile.R;
import com.shureck.medmobile.RootActivity;

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