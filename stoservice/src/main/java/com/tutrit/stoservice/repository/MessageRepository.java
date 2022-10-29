package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Message;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public class MessageRepository implements Repository<Message, String> {

    public static final Logger logger = Logger.getLogger(MessageRepository.class.getName());
    private static final List<Message> messages = new ArrayList<>();

    @Override
    public Message save(Message sms) {
        messages.add(0, sms);
        return sms;
    }

    @Override
    public void saveAll(Iterable<Message> smsList) {
        MessageRepository.messages.addAll((Collection<Message>) smsList);
    }

    @Override
    public Message find(Message sms) {
        for (final Message mes : messages) {
            if (mes.equals(sms)) {
                return mes;
            }
        }
        logger.info("There is no such message");
        return null;
    }

    @Override
    public Iterable<Message> findAll() {
        return messages;
    }

    @Override
    public Message findById(String id) {
        for (final Message sms : messages) {
            if (id.equals(sms.Id())) {
                return sms;
            }
        }
        return null;
    }

    @Override
    public Message update(Message sms) {
        messages.set((messages.indexOf(findById(sms.Id()))), sms);
        return sms;
    }

    @Override
    public boolean delete(Message sms) {
        return messages.remove(findById(sms.Id()));
    }

    @Override
    public boolean deleteById(String id) {
        for (final Message message : messages) {
            if (message.Id().equals(id)) {
                messages.remove(message);
                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        return messages.size();
    }
}
