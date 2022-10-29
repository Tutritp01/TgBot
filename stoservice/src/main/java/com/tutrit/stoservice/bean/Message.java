package com.tutrit.stoservice.bean;

import java.time.LocalDateTime;

public record Message(String Id, String eventText, LocalDateTime timestamp, LocalDateTime startDate, User author, MessageStatus status) {

}
