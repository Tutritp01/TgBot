package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Message;
import com.tutrit.stoservice.bean.Promo;
import com.tutrit.stoservice.repository.MessageRepository;


public class MessageService {

    private MessageRepository messageRepository;

    public MessageService(final MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message saveMessage(Message message) {
       return messageRepository.save(message);
    }
    public Message findMessage(String name){
        Iterable<Message> result = messageRepository.findAll();
        for (Message message : result) {
            if(message.getEventText().equals(name)){
                return message;
            }
        }
        return null;
    }
    public Message updateMessage(Message message, Promo promo){
        StringBuilder newMessage = new StringBuilder(message.getEventText());
        newMessage.append(String.format("! Name promo kod: <<%s>> discount: <<%d>>", promo.getNamePromo(), promo.getDiscount()));
        message.setEventText(newMessage.toString());
        messageRepository.save(message);
        return messageRepository.save(message);
    }

    public void setMessageRepository(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }
}
