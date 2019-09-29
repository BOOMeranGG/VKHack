package com.orange_infinity.vkhack.model.entity.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChatUrl {

    @SerializedName("chat")
    @Expose
    private String chat;

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

}
