package com.orange_infinity.vkhack.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.orange_infinity.vkhack.R;
import com.orange_infinity.vkhack.utils.StringUtils;

public class AuthActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editLogin;
    private EditText editPassword;
    private Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        editLogin = findViewById(R.id.editLogin);
        editPassword = findViewById(R.id.editPassword);
        btnEnter = findViewById(R.id.btnRegistration);

        btnEnter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRegistration) {
            String login = editLogin.getText().toString().trim();
            String password = editPassword.getText().toString();

            if (!StringUtils.isValidEmail(login)) {
                return;
            }
            Intent intent = new Intent(this, EditProfileActivity.class);
            startActivity(intent);
        }
    }
}
