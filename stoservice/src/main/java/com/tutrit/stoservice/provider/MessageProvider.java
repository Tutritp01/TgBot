package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Message;
import com.tutrit.stoservice.bean.MessageStatus;
import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.repository.MessageRepository;
import com.tutrit.stoservice.repository.UserMessageRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageProvider {

    private static final UserMessageRepository userMessageRepository = new UserMessageRepository();
    private static final MessageRepository messageRepository = new MessageRepository();

    private MessageProvider() {
        throw new IllegalStateException("Utility class");
    }

    public static void getMessages() {
        for (int i = 0; i < 10; i++) {
            User user = getUserInstance(i);
            Message message = getMessageInstance(i);
            userMessageRepository.save(user, new ArrayList<>(List.of(message)));
            messageRepository.save(message);
        }
    }

    private static User getUserInstance(int i) {
        return new User("Id" + i, "User" + i, "Phone" + i);
    }

    private static Message getMessageInstance(int i) {
        return new Message("id" + i, "event" + i, LocalDateTime.now(), LocalDateTime.of(2022, 11, 4, 18, 0), null, MessageStatus.NEW);
    }
}
