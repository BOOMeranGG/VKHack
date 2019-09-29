package com.orange_infinity.vkhack.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.orange_infinity.vkhack.R;

import java.util.ArrayList;
import java.util.List;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private List<String> skills = new ArrayList<>();
    private View close_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        close_image = findViewById(R.id.close_image);
        close_image.setOnClickListener(this);

        skills.add("Programming");
        skills.add("Java");
        skills.add("Знание англа");
        skills.add("Вод. права");
        skills.add("Стрессоучстойчивый");
        skills.add("Быстро считаю");

//        LinearLayout linearLayout = findViewById(R.id.skill1);
//        TextView tv1 = linearLayout.findViewById(R.id.tvSkill);
//        tv1.setText("NOPE");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.close_image) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
    }
}
