package com.orange_infinity.vkhack.model.chat;

import androidx.annotation.Nullable;

import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.commons.models.IUser;
import com.stfalcon.chatkit.commons.models.MessageContentType;

import java.util.Date;

public class Message implements IMessage, MessageContentType.Image {

    private ChatUser author;
    private String description;
    private String id;
    private String imageUrl;

    public Message(ChatUser author, String description, String id) {
        this.author = author;
        this.description = description;
        this.id = id;
    }

    @Nullable
    @Override
    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getText() {
        return description;
    }

    @Override
    public IUser getUser() {
        return author;
    }

    @Override
    public Date getCreatedAt() {
        return new Date();
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
