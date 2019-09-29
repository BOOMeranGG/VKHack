package com.orange_infinity.vkhack.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.orange_infinity.vkhack.R;
import com.orange_infinity.vkhack.ui.fragments.TopProfileFragment;

import static com.orange_infinity.vkhack.utils.StringUtils.MAIN_TAG;

public class ProfileActivity extends BaseActivity implements View.OnClickListener{

    private View btnEditProfile;
    private Button btnETicket;

    public ProfileActivity() {
        super(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setUpBottomNavigation();
        btnEditProfile = findViewById(R.id.btnEditProfile);
        btnETicket = findViewById(R.id.btnETicket);
        btnEditProfile.setOnClickListener(this);
        btnETicket.setOnClickListener(this);

        createTopMainFragment();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnETicket) {
            Intent intent = new Intent(this, QrCodeActivity.class);
            startActivity(intent);
            Log.d(MAIN_TAG, "ETicket btn is clicked");
        }
        else if (v.getId() == R.id.btnEditProfile) {
            Intent intent = new Intent(this, EditProfileActivity.class);
            startActivity(intent);
        }
    }


    private void createTopMainFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.topProfileLayout);
        if (fragment == null) {
            fragment = new TopProfileFragment();
            fm.beginTransaction()
                    .add(R.id.topProfileLayout, fragment)
                    .commit();
        }
    }
}
