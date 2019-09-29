package com.orange_infinity.vkhack.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.ImageView;

import com.orange_infinity.vkhack.R;
import com.orange_infinity.vkhack.ui.fragments.TopProfileFragment;
import com.orange_infinity.vkhack.utils.QrEncoder;

public class QrCodeActivity extends AppCompatActivity {

    private ImageView imgQrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        createTopMainFragment();
        imgQrCode = findViewById(R.id.imgQrCode);
        imgQrCode.setImageBitmap(QrEncoder.convertStringToQr("Why did you do that?" +
                "dasldbasjkbdkjasbdjkasnfknkflndslkfgnkjdnfgkldsn", imgQrCode.getWidth()));
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
