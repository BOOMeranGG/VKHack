package com.orange_infinity.vkhack.ui.activities;

import android.os.Bundle;

import com.orange_infinity.vkhack.R;

public class EventActivity extends BaseActivity {

    public EventActivity() {
        super(1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        setUpBottomNavigation();
    }
}
