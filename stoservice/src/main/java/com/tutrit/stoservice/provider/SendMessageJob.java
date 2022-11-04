package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Message;
import com.tutrit.stoservice.bean.MessageStatus;
import com.tutrit.stoservice.bean.User;
import com.tutrit.stoservice.repository.MessageRepository;
import com.tutrit.stoservice.repository.UserMessageRepository;
import com.tutrit.stoservice.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.tutrit.stoservice.controller.RequestDispatcher.logger;

public class SendMessageJob extends Thread {

    private final MessageRepository messageRepository = new MessageRepository();
    private final UserRepository userRepository = new UserRepository();
    private final UserMessageRepository userMessageRepository = new UserMessageRepository();

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                TimeUnit.DAYS.sleep(1);
                process();
            }
        } catch (InterruptedException e) {
            logger.info("Interrupted");
            Thread.currentThread().interrupt();
        }
    }

    public void process() {
        ArrayList<Message> newMessages = getNewMessages();
        if (!newMessages.isEmpty()) {
            setSentStatus(newMessages);
            sendMessagesToUsers(newMessages, userMessageRepository.findAll());
        } else {
            logger.info("No new messages");
        }
    }

    private void setSentStatus(ArrayList<Message> newMessages) {
        for (Message message : newMessages) {
            message.setStatus(MessageStatus.SENT);
            messageRepository.update(message);
        }
    }

    private ArrayList<Message> getNewMessages() {
        return StreamSupport.stream(messageRepository.findAll().spliterator(), false)
                .filter(e -> e.getStatus() == MessageStatus.NEW)
                .filter(e -> e.getStartDate().isBefore(LocalDateTime.now()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void sendMessagesToUsers(List<Message> newMessages, Map<User, List<Message>> messages) {
        for (User user : userRepository.findAll()) {
            List<Message> messageList = messages.get(user);
            messageList.addAll(newMessages);
            messages.put(user, messageList);
        }
    }
}
