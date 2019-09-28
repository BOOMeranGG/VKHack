package com.orange_infinity.vkhack.ui.activities;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orange_infinity.vkhack.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private List<String> skills = new ArrayList<>();

    public MainActivity() {
        super(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpBottomNavigation();
        skills.add("Hello");
        skills.add("Kitty");
        skills.add("Motherfucker");
        skills.add("fu*ck");
        skills.add("mamaamakriminak");
        skills.add("255");

        LinearLayout linearLayout = findViewById(R.id.skill1);
        TextView tv1 = linearLayout.findViewById(R.id.tvSkill);
        tv1.setText("PID*R");
    }
}
