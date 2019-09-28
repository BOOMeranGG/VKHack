package com.orange_infinity.vkhack.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orange_infinity.vkhack.R;
import com.orange_infinity.vkhack.data.preferences.SessionManager;
import com.orange_infinity.vkhack.model.entity.dto.RegistrationDto;
import com.orange_infinity.vkhack.utils.StringUtils;
import com.orange_infinity.vkhack.web.WebController;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.orange_infinity.vkhack.utils.StringUtils.MAIN_TAG;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editLogin;
    private EditText editPassword;
    private EditText editName;
    private EditText editSurname;
    private Button btnEnter;
    private WebController webController = new WebController();

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sessionManager = new SessionManager(this); // инициализация context для sharedPreferences

        checkIsUserAuthorized();
        setContentView(R.layout.activity_registration);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        editLogin = findViewById(R.id.editLogin);
        editPassword = findViewById(R.id.editPassword);
        editName = findViewById(R.id.editName);
        editSurname = findViewById(R.id.editSurname);
        btnEnter = findViewById(R.id.btnRegistration);

        btnEnter.setOnClickListener(this);
    }

    private void checkIsUserAuthorized() {
        if (sessionManager.isUserAuth()) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRegistration) {
            if (createAccount()) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

    private boolean createAccount() {
        final String login = editLogin.getText().toString().trim(); // Почта
        final String password = editPassword.getText().toString();
        final String name = editName.getText().toString();
        final String surname = editSurname.getText().toString();

        if (!StringUtils.isValidEmail(login)) {
            return false;
        }

        sessionManager.saveUserAuthData(password, login, name + " " + surname);
        RegistrationDto regDto = new RegistrationDto();
        regDto.setEmail(login);
        regDto.setPassword(password);
        regDto.setName(name);
        regDto.setSurname(surname);
        regDto.setBdate("");
        regDto.setAbout_me("");
        regDto.setPhone_number("");
        regDto.setKey_abilities("");

        webController.registry(regDto, getApplicationContext()); // запрос регистрации

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Log.d(MAIN_TAG, "You are creating a new account");
        return true;
    }
}
