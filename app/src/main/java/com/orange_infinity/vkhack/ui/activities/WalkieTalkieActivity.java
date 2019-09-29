package com.orange_infinity.vkhack.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.orange_infinity.vkhack.R;
import com.orange_infinity.vkhack.chat.ChatApplication;
import com.orange_infinity.vkhack.data.preferences.SessionManager;
import com.orange_infinity.vkhack.model.entity.dto.ConnectData;
import com.orange_infinity.vkhack.web.WebController;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.orange_infinity.vkhack.utils.StringUtils.MAIN_TAG;

public class WalkieTalkieActivity extends AppCompatActivity {

    private FrameLayout mCauseRadio;

    private Socket mSocket;

    private WebController webController = new WebController();

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkie_talkie);

        ConnectData data = new ConnectData();

        data.setName("Roman");//sessionManager.getNickName().split(" ")[0]
        data.setRoom("45615315631");//sessionManager.getUID()

        webController.getUrl(data, getApplicationContext());

        ChatApplication app = (ChatApplication) getApplication();
        mSocket = app.getSocket();

        sessionManager = new SessionManager(this);

        // perform the user login attempt.
        mSocket.emit("joined", sessionManager.getNickName());

        mSocket.on("login", onLogin);

//        mCauseRadio = findViewById(R.id.cause_radio);
//
//        mCauseRadio.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                causeService();
//            }
//        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mSocket.off("login", onLogin);
    }

    private Emitter.Listener onLogin = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            JSONObject data = (JSONObject) args[0];

            int numUsers;
            try {
                numUsers = data.getInt("numUsers");
            } catch (JSONException e) {
                return;
            }

            Intent intent = new Intent();
            intent.putExtra("username", sessionManager.getNickName());
            intent.putExtra("numUsers", numUsers);
            setResult(RESULT_OK, intent);
            finish();
        }
    };

//    public void causeService(){
//
//        Toast.makeText(getApplicationContext(), "Рация запущена!", Toast.LENGTH_SHORT).show();
//
//
//        //процесс
//
//    }

}
