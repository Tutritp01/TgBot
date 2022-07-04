package com.tutrit.tgbot.example.bean;

import java.util.Objects;

public class UserDataTg {
    private String name;
    private long userId;
    private long chatId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDataTg userDataTg)) return false;
        return userId == userDataTg.userId && chatId == userDataTg.chatId && Objects.equals(name, userDataTg.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, userId, chatId);
    }
}
