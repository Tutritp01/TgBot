package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Message;
import com.tutrit.stoservice.bean.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMessageRepository {

    private static final Map<User, List<Message>> messages = new HashMap<>();

    public Message save(User user, Message message) {
        List<Message> messageList = messages.get(user);
        if (messageList != null) {
            messageList.add(message);
            messages.put(user, messageList);
        } else {
            messages.put(user, new ArrayList<>(List.of(message)));
        }
        return message;
    }

    public void save(User user, List<Message> newMessages) {
        List<Message> listOfMessages = messages.get(user);
        if (listOfMessages != null) {
            listOfMessages.addAll(newMessages);
            messages.put(user, listOfMessages);
        } else {
            messages.put(user, newMessages);
        }
    }

    public Map<User, List<Message>> findAll() {
        return messages;
    }
}
