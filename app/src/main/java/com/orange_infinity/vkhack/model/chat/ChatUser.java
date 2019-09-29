package com.orange_infinity.vkhack.model.chat;

import com.stfalcon.chatkit.commons.models.IUser;

public class ChatUser implements IUser {

    private String id;
    private String fullName;

    public ChatUser(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return fullName;
    }

    @Override
    public String getAvatar() {
        return "";
    }
}
