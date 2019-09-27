package com.orange_infinity.vkhack.ui.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orange_infinity.vkhack.MainActivity;
import com.orange_infinity.vkhack.R;
import com.orange_infinity.vkhack.data.preferences.UserPreferences;
import com.orange_infinity.vkhack.model.entity.dto.RegistrationDto;
import com.orange_infinity.vkhack.utils.StringUtils;
import com.orange_infinity.vkhack.web.WebController;

import static com.orange_infinity.vkhack.utils.StringUtils.MAIN_TAG;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editLogin;
    private EditText editPassword;
    private EditText editNickname;
    private Button btnEnter;
    private WebController webController = new WebController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkIsUserAuthorized();
        setContentView(R.layout.activity_registration);

        editLogin = findViewById(R.id.editLogin);
        editPassword = findViewById(R.id.editPassword);
        editNickname = findViewById(R.id.editNickname);
        btnEnter = findViewById(R.id.btnRegistration);

        btnEnter.setOnClickListener(this);
    }

    private void checkIsUserAuthorized() {
        if (UserPreferences.isUserAuth(this)) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRegistration) {
            if (createAccount()) {
                Intent intent = new Intent(this, FormActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

    private boolean createAccount() {
        String login = editLogin.getText().toString().trim();
        String password = editPassword.getText().toString();
        String nickname = editNickname.getText().toString();

        if (!StringUtils.isValidEmail(login)) {
            return false;
        }

        UserPreferences.saveUserAuthData(this, password, login, nickname);
        RegistrationDto regDto = new RegistrationDto();
        regDto.setEmail(login);
        regDto.setPassword(password);
        regDto.setUsername(nickname);

        webController.registry(regDto);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(regDto);
        Log.d(MAIN_TAG, "You are creating a new account, login: " + regDto.getEmail() + ", password: "
                + regDto.getPassword() + ", username: " + regDto.getUsername());
        Log.d(MAIN_TAG, "json: " + json);
        return true;
    }
}
