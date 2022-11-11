package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Message;
import com.tutrit.stoservice.repository.MessageRepository;


public class MessageService {

    private MessageRepository messageRepository;

    public MessageService(final MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message saveMessage(Message message) {
       return messageRepository.save(message);
    }
    public void setMessageRepository(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }
}
