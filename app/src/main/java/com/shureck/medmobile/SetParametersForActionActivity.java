package com.shureck.medmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.media.tv.TvContentRating;
import android.os.Bundle;
import android.widget.TextView;

public class SetParametersForActionActivity extends AppCompatActivity {

    TextView headerView;
    TextView subHeaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_parameters_for_action);

        String header = getIntent().getStringExtra("HEADER");
        String subHeader = '(' + getIntent().getStringExtra("SUB_HEADER")  + ')';

        headerView = findViewById(R.id.set_params_action_header);
        subHeaderView = findViewById(R.id.set_params_action_sub_header);

        headerView.setText(header);
        subHeaderView.setText(subHeader);
    }
}