package com.orange_infinity.vkhack.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orange_infinity.vkhack.R;
import com.orange_infinity.vkhack.data.preferences.SessionManager;
import com.orange_infinity.vkhack.model.entity.dto.EditedData;
import com.orange_infinity.vkhack.web.WebController;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.orange_infinity.vkhack.utils.StringUtils.MAIN_TAG;

public class MainActivity extends BaseActivity {

    private List<String> skills = new ArrayList<>();

    public MainActivity() {
        super(0);
    }

    private EditText mName;
    private EditText mSurname;
    private EditText mBdate;
    private EditText mProfField;
    private EditText mEmail;
    private EditText mPhone;
    private EditText mGeneralData;

    private WebController webController = new WebController();

    private ImageView edit_request;

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(this); // инициализация context для sharedPreferences

        mName = (EditText) findViewById(R.id.editName);
        mSurname = (EditText) findViewById(R.id.editSurname);
        mBdate = (EditText) findViewById(R.id.editDateOfBirthday);
        mProfField = (EditText) findViewById(R.id.editProfFields);
        mEmail = (EditText) findViewById(R.id.editEmail);
        mPhone = (EditText) findViewById(R.id.editPhone);
        mGeneralData = (EditText) findViewById(R.id.editGeneralInfo);

        edit_request = findViewById(R.id.edit_request);

        String[] fs_name = sessionManager.getNickName().split(" ");

        mName.setText(fs_name[0]);
        mSurname.setText(fs_name[1]);
        mEmail.setText(sessionManager.getEmail());

        setUpBottomNavigation();
        skills.add("Hello");
        skills.add("Kitty");
        skills.add("Motherfucker");
        skills.add("fu*ck");
        skills.add("mamaamakriminak");
        skills.add("255");

        LinearLayout linearLayout = findViewById(R.id.skill1);
        TextView tv1 = linearLayout.findViewById(R.id.tvSkill);
        tv1.setText("Первый навык!");

        edit_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_data();
                Toast.makeText(getApplicationContext(), "Данные изменены!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    // Создание AuthToken
    public String getAuthToken() {
        byte[] data = new byte[0];
        try {
            data = (sessionManager.getEmail() + ":" + sessionManager.getPassword()).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }

    public boolean edit_data(){
        EditedData data = new EditedData();
        data.setName(mName.getText().toString());
        data.setSurname(mSurname.getText().toString());
        data.setEmail(mEmail.getText().toString());
        data.setBdate(mBdate.getText().toString());
        data.setAbout_me(mGeneralData.getText().toString());
        data.setPhone_number(mPhone.getText().toString());
        data.setKey_abilities(mProfField.getText().toString());

        webController.send_edited_data(getAuthToken(), data, sessionManager.getId());

        return  true;
    }
}
