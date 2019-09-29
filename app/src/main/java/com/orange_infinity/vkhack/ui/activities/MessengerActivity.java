package com.orange_infinity.vkhack.ui.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.orange_infinity.vkhack.R;
import com.orange_infinity.vkhack.model.chat.ChatUser;
import com.orange_infinity.vkhack.model.chat.Message;
import com.squareup.picasso.Picasso;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.messages.MessageInput;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.orange_infinity.vkhack.utils.StringUtils.MAIN_TAG;

public class MessengerActivity extends AppCompatActivity implements MessageInput.InputListener, MessagesListAdapter.OnMessageClickListener {

    private ChatUser user = new ChatUser(UUID.randomUUID().toString(), "Jack");
    private ChatUser yourself = new ChatUser(UUID.randomUUID().toString(), "You");
    private List<Message> historyMessage = new ArrayList<>();
    private MessagesList messagesList;
    private MessagesListAdapter adapter;
    private MessageInput input;
    private ImageLoader imageLoader;

    public MessengerActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        messagesList = findViewById(R.id.messagesList);
        input = findViewById(R.id.input);
        imageLoader = new ImageLoader() {
            @Override
            public void loadImage(ImageView imageView, @Nullable String url, @Nullable Object payload) {
                Picasso.with(MessengerActivity.this).load(url).into(imageView);
            }
        };

        ChatUser selfUser = new ChatUser(UUID.randomUUID().toString(), "Jenya");
        adapter = new MessagesListAdapter<Message>(selfUser.getId(), imageLoader);
        adapter.setOnMessageClickListener(this);

        setReports();
        drawAllReports();
        input.setInputListener(this);
    }

    @Override
    public boolean onSubmit(CharSequence input) {
        Message messageText = new Message(yourself, input.toString(), UUID.randomUUID().toString());
        Message messagePhoto = new Message(yourself, input.toString(), UUID.randomUUID().toString());
        messagePhoto.setImageUrl("https://otzyv-shop.ru/components/com_jshopping/files/img_products/full_google-maps.png");

        adapter.addToStart(messageText, true);
        adapter.addToStart(messagePhoto, true);
        this.input.getInputEditText().setText("");
//        double latitude = location.getLatitude(); // широта
//        double longitude = location.getLongitude(); // долгота
//        Log.d(MAIN_TAG, "Latitude = " + latitude + " Longitude = " + longitude);

        return false;
    }

    @Override
    public void onMessageClick(IMessage message) {
        Log.d(MAIN_TAG, "Click to message");
    }

    private void drawAllReports() {
        List<Message> messages = new ArrayList<>();
        messagesList.setAdapter(adapter);
        for (int i = 0; i < historyMessage.size(); i++) {
            messages.add(historyMessage.get(i));

            Message photo = new Message(user, "", "");
            photo.setImageUrl("https://otzyv-shop.ru/components/com_jshopping/files/img_products/full_google-maps.png");
            messages.add(photo);
        }
        adapter.addToEnd(messages, true);
    }

    private void setReports() {
        Message message;
        for (int i = 0; i < 5; i++) {
            message = new Message(user, "Hello, I have a problem " + i, i + "");
            historyMessage.add(message);
        }
    }
}
