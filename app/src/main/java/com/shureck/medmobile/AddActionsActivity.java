package com.shureck.medmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddActionsActivity extends AppCompatActivity {

    List<Integer> defaultIcons;
    List<String> actionNames;
    List<String> actionDescriptions;

    LinearLayout actionsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_actions);

        actionsContainer = findViewById(R.id.actions_container);

        setActionsInfo();
        setActionsListContent();
    }

    private void setActionsInfo() {
        // TODO: change to query for shared preferences
        defaultIcons =
                Arrays.asList(
                        R.drawable.ic_baseline_airline_seat_recline_normal_24,
                        R.drawable.ic_baseline_stairs_24,
                        R.drawable.ic_baseline_directions_walk_24,
                        R.drawable.ic_baseline_directions_run_24,
                        R.drawable.ic_baseline_bolt_24
                );
        actionNames =
                Arrays.asList(
                        "Состояние покоя",
                        "Подъём по лестнице",
                        "Ходьба",
                        "Бег",
                        "Стресс"
                );
        actionDescriptions =
                Arrays.asList(
                        "Не было активности",
                        "5 этажей",
                        "10 минут",
                        "3 минуты",
                        "Вы нервничали"
                );
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setActionsListContent() {
        LayoutInflater inflaterPinned = LayoutInflater.from(actionsContainer.getContext());


        for (int i = 0; i < actionNames.size(); i++) {
            View newAction = inflaterPinned.inflate(R.layout.action_button_item, null);

            ImageView newActionIcon = newAction.findViewById(R.id.action_icon);
            TextView newActionName = newAction.findViewById(R.id.action_name);
            TextView newActionDesc = newAction.findViewById(R.id.action_desc);
            newActionIcon.setImageResource(defaultIcons.get(i));
            newActionName.setText(actionNames.get(i));
            newActionDesc.setText(actionDescriptions.get(i));
            actionsContainer.addView(newAction);
        }

    }
}