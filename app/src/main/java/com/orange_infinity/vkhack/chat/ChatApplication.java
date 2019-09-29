package com.orange_infinity.vkhack.chat;

import android.app.Application;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class ChatApplication extends Application {

    String CHAT_SERVER_URL = "http://99aa95f9.ngrok.io/chat"; // полученный урл

    private Socket mSocket; {

        try {
            mSocket = IO.socket(CHAT_SERVER_URL);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return mSocket;
    }
}
