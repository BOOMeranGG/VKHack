package com.orange_infinity.vkhack.ui.activities;

import android.os.Bundle;

import com.orange_infinity.vkhack.R;

public class MessengerActivity extends BaseActivity {

    public MessengerActivity() {
        super(2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        setUpBottomNavigation();
    }
}
