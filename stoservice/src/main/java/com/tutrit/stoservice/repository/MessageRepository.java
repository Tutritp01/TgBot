package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.bean.Message;

import java.util.*;
import java.util.logging.Logger;

public class MessageRepository implements Repository<Message, String>, MyIdGenerator<Message> {

    public static final Logger logger = Logger.getLogger(MessageRepository.class.getName());
    private static List<Message> messages = new ArrayList<>();

    @Override
    public Message save(Message sms) {
        messages.add(0, sms);
        setUUID(sms);
        return sms;
    }

    @Override
    public void saveAll(Iterable<Message> smsList) {
        Collection<Message> temp = new ArrayList<>();
        temp.addAll((Collection<? extends Message>) smsList);
        temp.forEach(this::setUUID);
        messages.addAll(temp);
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
        for (Message sms : messages) {
            if (id.equals(sms.getId())) {
                return sms;
            }
        }
        return null;
    }

    @Override
    public Message update(Message sms) {
        messages.set((messages.indexOf(findById(sms.getId()))), sms);
        return sms;
    }

    @Override
    public boolean delete(Message sms) {
        return messages.remove(findById(sms.getId()));
    }

    @Override
    public boolean deleteById(String id) {
        for (final Message message : messages) {
            if (message.getId().equals(id)) {
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

    @Override
    public void setUUID(Message sms) {
        sms.setId(UUID.randomUUID().toString());
    }
    public  void clean(){
        messages.clear();
    }
}
