package com.orange_infinity.vkhack;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.orange_infinity.vkhack.ui.activities.BaseActivity;

public class MainActivity extends BaseActivity {

    public MainActivity() {
        super(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpBottomNavigation();
    }
}
