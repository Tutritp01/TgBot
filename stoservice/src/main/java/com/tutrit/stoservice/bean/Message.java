package com.tutrit.stoservice.bean;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private String id;
    private String eventText;
    private LocalDateTime timestamp;
    private LocalDateTime startDate;
    private User author;
    private MessageStatus status;

    public Message(String id, String eventText, LocalDateTime timestamp, LocalDateTime startDate, User author, MessageStatus status) {
        this.id = id;
        this.eventText = eventText;
        this.timestamp = timestamp;
        this.startDate = startDate;
        this.author = author;
        this.status = status;
    }

    public Message() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) && Objects.equals(eventText, message.eventText) && Objects.equals(timestamp, message.timestamp) && Objects.equals(startDate, message.startDate) && Objects.equals(author, message.author) && status == message.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventText, timestamp, startDate, author, status);
    }

    @Override
    public String toString() {
        return "Message{" +
                "Id='" + id + '\'' +
                ", eventText='" + eventText + '\'' +
                ", timestamp=" + timestamp +
                ", startDate=" + startDate +
                ", author=" + author +
                ", status=" + status +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getEventText() {
        return eventText;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public User getAuthor() {
        return author;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }
}



