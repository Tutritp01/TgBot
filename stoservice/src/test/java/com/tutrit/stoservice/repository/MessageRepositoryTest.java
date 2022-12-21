package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Message;
import com.tutrit.stoservice.bean.MessageStatus;
import com.tutrit.stoservice.mock.MessageRepositoryUUIDMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageRepositoryTest {

    MessageRepository messageRepository;

    @BeforeEach
    public void setUp() {
        messageRepository = new MessageRepositoryUUIDMock();
    }

    @AfterEach
    void clear() {
        messageRepository.clean();
    }

    @Test
    void save() {
        Message message1 = new Message("id1", "event 1", LocalDateTime.now(), LocalDateTime.now(), null, MessageStatus.NEW);
        Message message2 = new Message("id2", "event 2", LocalDateTime.now(), LocalDateTime.now(), null, MessageStatus.SENT);
        Message message3 = new Message("id3", "event 3", LocalDateTime.now(), LocalDateTime.now(), null, MessageStatus.USED);
        int expected = messageRepository.count() + 3;
        messageRepository.save(message1);
        messageRepository.save(message2);
        messageRepository.save(message3);

        assertEquals(expected, messageRepository.count());
    }

    @Test
    void saveAll() {
        Message message4 = new Message("id4", "event 4", LocalDateTime.now(), LocalDateTime.now(), null, null);
        Message message5 = new Message("id5", "event 5", LocalDateTime.now(), LocalDateTime.now(), null, null);
        Message message6 = new Message("id6", "event 6", LocalDateTime.now(), LocalDateTime.now(), null, null);
        int expected = messageRepository.count() + 3;
        List<Message> list = List.of(message4, message5, message6);
        messageRepository.saveAll(list);

        assertEquals(expected, messageRepository.count());
    }

    @Test
    void find() {
        Message message7 = new Message("id7", "event 7", LocalDateTime.now(), LocalDateTime.now(), null, null);
        Message message8 = new Message("id8", "event 8", LocalDateTime.now(), LocalDateTime.now(), null, null);
        messageRepository.save(message7);

        assertEquals(message7, messageRepository.find(message7));
        assertNull(messageRepository.find(message8));
    }

    @Test
    void findAll() {
        Message message9 = new Message("id9", "event 9", LocalDateTime.now(), LocalDateTime.now(), null, null);
        Message message10 = new Message("id10", "event 10", LocalDateTime.now(), LocalDateTime.now(), null, null);
        messageRepository.save(message9);
        messageRepository.save(message10);
        int counter = 0;
        for (Message ignored : messageRepository.findAll()) {
            counter++;
        }

        assertEquals(messageRepository.count(), counter);
    }

    @Test
    void findById() {
        Message message11 = new Message("spyValues0", "event 11", LocalDateTime.now(), LocalDateTime.now(), null, null);
        Message message12 = new Message("spyValues1", "event 12", LocalDateTime.now(), LocalDateTime.now(), null, null);
        messageRepository.save(message11);
        messageRepository.save(message12);

        assertEquals(message11, messageRepository.findById("spyValues0"));
        assertNull(messageRepository.findById("id10000"));
    }

    @Test
    void update() {
        Message message13 = new Message("spyValues0", "event 13", LocalDateTime.now(), LocalDateTime.now(), null, null);
        Message message14 = new Message("spyValues1", "event 14", LocalDateTime.now(), LocalDateTime.now(), null, null);

        messageRepository.save(message13);
        messageRepository.save(message14);
        messageRepository.update(message14);

        assertEquals(message14, messageRepository.findById("spyValues1"));
    }

    @Test
    void delete() {
        Message message15 = new Message("id15", "event 15", LocalDateTime.now(), LocalDateTime.now(), null, null);
        Message message16 = new Message("id16", "event 16", LocalDateTime.now(), LocalDateTime.now(), null, null);
        messageRepository.save(message15);
        messageRepository.save(message16);
        int expected = messageRepository.count() - 1;
        messageRepository.delete(message15);
        assertEquals(expected, messageRepository.count());
        expected = messageRepository.count() - 1;
        messageRepository.delete(message16);
        assertEquals(expected, messageRepository.count());
    }

    @Test
    void deleteById() {
        Message message17 = new Message("spyValues0", "event 17", LocalDateTime.now(), LocalDateTime.now(), null, null);
        Message message18 = new Message("spyValues1", "event 18", LocalDateTime.now(), LocalDateTime.now(), null, null);
        messageRepository.save(message17);
        messageRepository.save(message18);
        int expected = messageRepository.count() - 1;
        messageRepository.deleteById("spyValues1");

        assertEquals(expected, messageRepository.count());
    }

    @Test
    void count() {
        int counter = 0;
        for (Message ignored : messageRepository.findAll()) {
            counter++;
        }

        assertEquals(messageRepository.count(), counter);
    }
}
