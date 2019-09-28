package com.orange_infinity.vkhack.ui.activities;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.orange_infinity.vkhack.R;
import com.orange_infinity.vkhack.ui.fragments.EventViewerFragment;
import com.orange_infinity.vkhack.ui.fragments.OrganizationViewerFragment;

public class EventActivity extends BaseActivity {

    public EventActivity() {
        super(1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        setUpBottomNavigation();

        FragmentManager fm = getSupportFragmentManager();
        createOrganizationFragment(fm);
        createEventFragment(fm);
    }

    private void createOrganizationFragment(FragmentManager fm) {
        Fragment fragment = fm.findFragmentById(R.id.organizationListContainer);
        if (fragment == null) {
            fragment = new OrganizationViewerFragment();
            fm.beginTransaction()
                    .add(R.id.organizationListContainer, fragment)
                    .commit();
        }
    }

    private void createEventFragment(FragmentManager fm) {
        Fragment fragment = fm.findFragmentById(R.id.eventListContainer);
        if (fragment == null) {
            fragment = new EventViewerFragment();
            fm.beginTransaction()
                    .add(R.id.eventListContainer, fragment)
                    .commit();
        }
    }
}
